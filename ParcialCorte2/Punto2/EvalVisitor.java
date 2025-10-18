import java.util.*;
import org.antlr.v4.runtime.Token;

public class EvalVisitor extends CRUDBaseVisitor<Object> {

    static class Table {
        final String name;
        final LinkedHashMap<String, String> schema = new LinkedHashMap<>();
        final List<LinkedHashMap<String, Object>> rows = new ArrayList<>();
        String primaryKey;

        Table(String name) { this.name = name; }
    }

    private final Map<String, Table> db = new HashMap<>();
    private final ThreadLocal<LinkedHashMap<String, Object>> rowCtx = ThreadLocal.withInitial(() -> null);

    // Programa 
    @Override
    public Object visitPrograma(CRUDParser.ProgramaContext ctx) {
        return visit(ctx.sentenciaLista());
    }

    @Override
    public Object visitSentenciaLista(CRUDParser.SentenciaListaContext ctx) {
        for (CRUDParser.SentenciaContext s : ctx.sentencia()) visit(s);
        return null;
    }

    // CREATE TABLE
    @Override
    public Object visitCreateTable(CRUDParser.CreateTableContext ctx) {
        String tname = ctx.ID().getText();
        if (db.containsKey(tname)) throw new RuntimeException("La tabla '" + tname + "' ya existe");
        Table t = new Table(tname);

        for (CRUDParser.DefCampoContext dc : ctx.defCampoLista().defCampo()) {
            String col = dc.ID().getText();
            String type = dc.tipo().getText(); // INT|FLOAT|TEXT
            if (!type.equals("INT") && !type.equals("FLOAT") && !type.equals("TEXT"))
                throw new RuntimeException("Tipo no soportado: " + type);
            if (t.schema.containsKey(col))
                throw new RuntimeException("Columna duplicada: " + col);
            t.schema.put(col, type);
        }

        if (ctx.optPK() != null && ctx.optPK().getText().length() > 0) {
            String pk = ctx.optPK().ID().getText();
            if (!t.schema.containsKey(pk))
                throw new RuntimeException("PRIMARY KEY '" + pk + "' no existe en el esquema");
            t.primaryKey = pk;
        }

        db.put(tname, t);
        System.out.println("Tabla creada: " + tname + " " + t.schema + (t.primaryKey != null ? " PK=" + t.primaryKey : ""));
        return null;
    }

    // INSERT 
    @Override
    public Object visitInsertStmt(CRUDParser.InsertStmtContext ctx) {
        String tname = ctx.ID().getText();
        Table t = db.get(tname);
        if (t == null) throw new RuntimeException("Tabla no existe: " + tname);

        List<String> cols = new ArrayList<>();
        if (ctx.optCols() != null && ctx.optCols().idLista() != null) {
            for (var idTok : ctx.optCols().idLista().ID()) cols.add(idTok.getText());
        } else {
            cols.addAll(t.schema.keySet());
        }

        List<Object> values = new ArrayList<>();
        for (CRUDParser.ValorContext vctx : ctx.valorLista().valor()) {
            if (vctx.NUM() != null) {
                String n = vctx.NUM().getText();
                values.add(n.contains(".") ? Double.parseDouble(n) : Integer.parseInt(n));
            } else if (vctx.STR() != null) {
                String raw = vctx.STR().getText(); 
                String inner = raw.substring(1, raw.length() - 1);
                StringBuilder sb = new StringBuilder();
                boolean esc = false;
                for (int i = 0; i < inner.length(); i++) {
                    char c = inner.charAt(i);
                    if (esc) {
                        switch (c) {
                            case 'n': sb.append('\n'); break;
                            case 't': sb.append('\t'); break;
                            case 'r': sb.append('\r'); break;
                            case '"': sb.append('"'); break;
                            case '\\': sb.append('\\'); break;
                            default: sb.append(c); break;
                        }
                        esc = false;
                    } else if (c == '\\') {
                        esc = true;
                    } else {
                        sb.append(c);
                    }
                }
                values.add(sb.toString());
            } else if (vctx.TRUE() != null) {
                values.add(Boolean.TRUE);
            } else if (vctx.FALSE() != null) {
                values.add(Boolean.FALSE);
            } else {
                throw new RuntimeException("Valor inválido en INSERT");
            }
        }

        if (cols.size() != values.size())
            throw new RuntimeException("Número de columnas (" + cols.size() + ") != valores (" + values.size() + ")");

        LinkedHashMap<String, Object> row = new LinkedHashMap<>();
        for (String c : t.schema.keySet()) row.put(c, null);

        for (int i = 0; i < cols.size(); i++) {
            String c = cols.get(i);
            if (!t.schema.containsKey(c))
                throw new RuntimeException("Columna '" + c + "' no existe en " + tname);
            String tp = t.schema.get(c);
            Object v = values.get(i);
            Object casted;
            if (tp.equals("INT")) {
                if (v instanceof Number) casted = ((Number) v).intValue();
                else if (v instanceof Boolean) casted = ((Boolean) v) ? 1 : 0;
                else if (v instanceof String) casted = Integer.parseInt((String) v);
                else throw new RuntimeException("No se puede convertir a INT: " + v);
            } else if (tp.equals("FLOAT")) {
                if (v instanceof Number) casted = ((Number) v).doubleValue();
                else if (v instanceof Boolean) casted = ((Boolean) v) ? 1.0 : 0.0;
                else if (v instanceof String) casted = Double.parseDouble((String) v);
                else throw new RuntimeException("No se puede convertir a FLOAT: " + v);
            } else if (tp.equals("TEXT")) {
                casted = String.valueOf(v);
            } else {
                throw new RuntimeException("Tipo no soportado: " + tp);
            }
            row.put(c, casted);
        }

        if (t.primaryKey != null) {
            Object keyVal = row.get(t.primaryKey);
            for (var r : t.rows) {
                if (Objects.equals(r.get(t.primaryKey), keyVal))
                    throw new RuntimeException("Violación de PRIMARY KEY (" + t.primaryKey + ") valor duplicado: " + keyVal);
            }
        }

        t.rows.add(row);
        System.out.println("INSERT en " + tname + ": " + row);
        return null;
    }

    // SELECT
    @Override
    public Object visitSelectStmt(CRUDParser.SelectStmtContext ctx) {
        String tname = ctx.ID().getText();
        Table t = db.get(tname);
        if (t == null) throw new RuntimeException("Tabla no existe: " + tname);

        List<String> cols = new ArrayList<>();
        if (ctx.seleccion().STAR() != null) {
            cols.addAll(t.schema.keySet());
        } else {
            for (var idTok : ctx.seleccion().idLista().ID()) {
                String c = idTok.getText();
                if (!t.schema.containsKey(c)) throw new RuntimeException("Columna '" + c + "' no existe en " + tname);
                cols.add(c);
            }
        }

        List<LinkedHashMap<String, Object>> out = new ArrayList<>();
        for (var r : t.rows) {
            rowCtx.set(r);
            boolean pass = true;
            if (ctx.optWhere() != null && ctx.optWhere().boolExpr() != null) {
                Object b = visit(ctx.optWhere().boolExpr());
                pass = (b instanceof Boolean) ? (Boolean) b
                      : (b instanceof Number) ? (((Number) b).doubleValue() != 0.0)
                      : (b instanceof String) ? !((String) b).isEmpty()
                      : (b != null);
            }
            rowCtx.set(null);
            if (pass) {
                LinkedHashMap<String, Object> proj = new LinkedHashMap<>();
                for (String c : cols) proj.put(c, r.get(c));
                out.add(proj);
            }
        }

        for (var r : out) System.out.println(r);
        return out;
    }

    // UPDATE
    @Override
    public Object visitUpdateStmt(CRUDParser.UpdateStmtContext ctx) {
        String tname = ctx.ID().getText();
        Table t = db.get(tname);
        if (t == null) throw new RuntimeException("Tabla no existe: " + tname);

        List<Map.Entry<String, CRUDParser.ExprContext>> assigns = new ArrayList<>();
        for (CRUDParser.AsignContext ac : ctx.asignLista().asign()) {
            String col = ac.ID().getText();
            if (!t.schema.containsKey(col))
                throw new RuntimeException("Columna '" + col + "' no existe en " + tname);
            assigns.add(new AbstractMap.SimpleEntry<>(col, ac.expr()));
        }

        int count = 0;
        for (var r : t.rows) {
            rowCtx.set(r);
            boolean pass = true;
            if (ctx.optWhere() != null && ctx.optWhere().boolExpr() != null) {
                Object b = visit(ctx.optWhere().boolExpr());
                pass = (b instanceof Boolean) ? (Boolean) b
                      : (b instanceof Number) ? (((Number) b).doubleValue() != 0.0)
                      : (b instanceof String) ? !((String) b).isEmpty()
                      : (b != null);
            }
            if (pass) {
                for (var e : assigns) {
                    String col = e.getKey();
                    Object val = visit(e.getValue());
                    String tp = t.schema.get(col);
                    Object casted;
                    if (tp.equals("INT")) {
                        if (val instanceof Number) casted = ((Number) val).intValue();
                        else if (val instanceof Boolean) casted = ((Boolean) val) ? 1 : 0;
                        else if (val instanceof String) casted = Integer.parseInt((String) val);
                        else throw new RuntimeException("No se puede convertir a INT: " + val);
                    } else if (tp.equals("FLOAT")) {
                        if (val instanceof Number) casted = ((Number) val).doubleValue();
                        else if (val instanceof Boolean) casted = ((Boolean) val) ? 1.0 : 0.0;
                        else if (val instanceof String) casted = Double.parseDouble((String) val);
                        else throw new RuntimeException("No se puede convertir a FLOAT: " + val);
                    } else if (tp.equals("TEXT")) {
                        casted = String.valueOf(val);
                    } else {
                        throw new RuntimeException("Tipo no soportado: " + tp);
                    }
                    r.put(col, casted);
                }
                count++;
            }
            rowCtx.set(null);
        }
        System.out.println("UPDATE " + tname + ": filas afectadas = " + count);
        return count;
    }

    // DELETE
    @Override
    public Object visitDeleteStmt(CRUDParser.DeleteStmtContext ctx) {
        String tname = ctx.ID().getText();
        Table t = db.get(tname);
        if (t == null) throw new RuntimeException("Tabla no existe: " + tname);

        int count = 0;
        Iterator<LinkedHashMap<String, Object>> it = t.rows.iterator();
        while (it.hasNext()) {
            var r = it.next();
            rowCtx.set(r);
            boolean pass = true;
            if (ctx.optWhere() != null && ctx.optWhere().boolExpr() != null) {
                Object b = visit(ctx.optWhere().boolExpr());
                pass = (b instanceof Boolean) ? (Boolean) b
                      : (b instanceof Number) ? (((Number) b).doubleValue() != 0.0)
                      : (b instanceof String) ? !((String) b).isEmpty()
                      : (b != null);
            }
            rowCtx.set(null);
            if (pass) { it.remove(); count++; }
        }
        System.out.println("DELETE " + tname + ": filas afectadas = " + count);
        return count;
    }

    // Expresiones aritmeticas
    @Override
    public Object visitExpr(CRUDParser.ExprContext ctx) {
        Object acc = visit(ctx.term(0));
        for (int i = 1; i < ctx.term().size(); i++) {
            Object right = visit(ctx.term(i));
            double a = toNumberOrFail(acc);
            double b = toNumberOrFail(right);
            String op = ctx.getChild(2 * i - 1).getText();
            acc = op.equals("+") ? (a + b) : (a - b);
        }
        return acc;
    }

    @Override
    public Object visitTerm(CRUDParser.TermContext ctx) {
        Object acc = visit(ctx.fact(0));
        for (int i = 1; i < ctx.fact().size(); i++) {
            Object right = visit(ctx.fact(i));
            double a = toNumberOrFail(acc);
            double b = toNumberOrFail(right);
            String op = ctx.getChild(2 * i - 1).getText();
            acc = op.equals("*") ? (a * b) : (a / b);
        }
        return acc;
    }

    @Override
    public Object visitFact(CRUDParser.FactContext ctx) {
        if (ctx.expr() != null) return visit(ctx.expr());

        if (ctx.NUM() != null) {
            String n = ctx.NUM().getText();
            return n.contains(".") ? Double.parseDouble(n) : (double) Integer.parseInt(n);
        }

        if (ctx.STR() != null) {
            String raw = ctx.STR().getText(); // incluye comillas
            String inner = raw.substring(1, raw.length() - 1);
            StringBuilder sb = new StringBuilder();
            boolean esc = false;
            for (int i = 0; i < inner.length(); i++) {
                char c = inner.charAt(i);
                if (esc) {
                    switch (c) {
                        case 'n': sb.append('\n'); break;
                        case 't': sb.append('\t'); break;
                        case 'r': sb.append('\r'); break;
                        case '"': sb.append('"'); break;
                        case '\\': sb.append('\\'); break;
                        default: sb.append(c); break;
                    }
                    esc = false;
                } else if (c == '\\') {
                    esc = true;
                } else {
                    sb.append(c);
                }
            }
            return sb.toString();
        }

        if (ctx.ID() != null) {
            var row = rowCtx.get();
            if (row == null) throw new RuntimeException("Uso de ID fuera de contexto de fila: " + ctx.ID().getText());
            String col = ctx.ID().getText();
            if (!row.containsKey(col)) throw new RuntimeException("Columna no encontrada: " + col);
            return row.get(col); // devolvemos tal cual (num, texto o bool)
        }

        throw new RuntimeException("factor inválido");
    }

    // Relacionales y booleanas
    @Override
    public Object visitRel(CRUDParser.RelContext ctx) {
        Object a = visit(ctx.expr(0));
        Object b = visit(ctx.expr(1));

        Object na = a, nb = b;
        if (na instanceof String) { try { na = Double.parseDouble((String) na); } catch (NumberFormatException ignore) {} }
        if (nb instanceof String) { try { nb = Double.parseDouble((String) nb); } catch (NumberFormatException ignore) {} }

        int cmp;
        if (na instanceof Number && nb instanceof Number) {
            cmp = Double.compare(((Number) na).doubleValue(), ((Number) nb).doubleValue());
        } else if (na instanceof Boolean && nb instanceof Boolean) {
            cmp = Boolean.compare((Boolean) na, (Boolean) nb);
        } else {
            cmp = String.valueOf(na).compareTo(String.valueOf(nb));
        }

        int tok = ctx.opRel().getStart().getType();
        boolean res;
        if (tok == CRUDParser.EQ) res = (cmp == 0);
        else if (tok == CRUDParser.NEQ) res = (cmp != 0);
        else if (tok == CRUDParser.LT) res = (cmp < 0);
        else if (tok == CRUDParser.LE) res = (cmp <= 0);
        else if (tok == CRUDParser.GT) res = (cmp > 0);
        else if (tok == CRUDParser.GE) res = (cmp >= 0);
        else throw new RuntimeException("Operador relacional desconocido");
        return res;
    }

    @Override
    public Object visitBoolExpr(CRUDParser.BoolExprContext ctx) {
        Object left = visit(ctx.boolT(0));
        for (int i = 1; i < ctx.boolT().size(); i++) {
            Object right = visit(ctx.boolT(i));
            boolean L = (left instanceof Boolean) ? (Boolean) left
                    : (left instanceof Number) ? (((Number) left).doubleValue() != 0.0)
                    : (left instanceof String) ? !((String) left).isEmpty()
                    : (left != null);
            boolean R = (right instanceof Boolean) ? (Boolean) right
                    : (right instanceof Number) ? (((Number) right).doubleValue() != 0.0)
                    : (right instanceof String) ? !((String) right).isEmpty()
                    : (right != null);
            left = L || R;
        }
        return left;
    }

    @Override
    public Object visitBoolT(CRUDParser.BoolTContext ctx) {
        Object left = visit(ctx.boolF(0));
        for (int i = 1; i < ctx.boolF().size(); i++) {
            Object right = visit(ctx.boolF(i));
            boolean L = (left instanceof Boolean) ? (Boolean) left
                    : (left instanceof Number) ? (((Number) left).doubleValue() != 0.0)
                    : (left instanceof String) ? !((String) left).isEmpty()
                    : (left != null);
            boolean R = (right instanceof Boolean) ? (Boolean) right
                    : (right instanceof Number) ? (((Number) right).doubleValue() != 0.0)
                    : (right instanceof String) ? !((String) right).isEmpty()
                    : (right != null);
            left = L && R;
        }
        return left;
    }

    @Override
    public Object visitBoolF(CRUDParser.BoolFContext ctx) {
        if (ctx.NOT() != null) {
            Object v = visit(ctx.boolF());
            boolean b = (v instanceof Boolean) ? (Boolean) v
                    : (v instanceof Number) ? (((Number) v).doubleValue() != 0.0)
                    : (v instanceof String) ? !((String) v).isEmpty()
                    : (v != null);
            return !b;
        }
        if (ctx.boolExpr() != null) return visit(ctx.boolExpr());
        if (ctx.rel() != null) return visit(ctx.rel());
        if (ctx.TRUE() != null) return true;
        if (ctx.FALSE() != null) return false;
        if (ctx.ID() != null) {
            var row = rowCtx.get();
            if (row == null) throw new RuntimeException("ID booleana fuera de contexto: " + ctx.ID().getText());
            String col = ctx.ID().getText();
            if (!row.containsKey(col)) throw new RuntimeException("Columna no encontrada: " + col);
            Object v = row.get(col);
            return (v instanceof Boolean) ? (Boolean) v
                 : (v instanceof Number) ? (((Number) v).doubleValue() != 0.0)
                 : (v instanceof String) ? !((String) v).isEmpty()
                 : (v != null);
        }
        throw new RuntimeException("boolF inválida");
    }

    
    private double toNumberOrFail(Object o) {
        if (o instanceof Number) return ((Number) o).doubleValue();
        if (o instanceof Boolean) return ((Boolean) o) ? 1.0 : 0.0;
        if (o instanceof String) {
            try {
                return Double.parseDouble((String) o);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Valor TEXT no numérico en expr: " + o);
            }
        }
        throw new RuntimeException("No numérico: " + o);
    }
}
