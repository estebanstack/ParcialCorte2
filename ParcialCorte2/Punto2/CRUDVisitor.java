// Generated from CRUD.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CRUDParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CRUDVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CRUDParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(CRUDParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#sentenciaLista}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentenciaLista(CRUDParser.SentenciaListaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#sentencia}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSentencia(CRUDParser.SentenciaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#createTable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateTable(CRUDParser.CreateTableContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#defCampoLista}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefCampoLista(CRUDParser.DefCampoListaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#defCampo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefCampo(CRUDParser.DefCampoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#tipo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo(CRUDParser.TipoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#optPK}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptPK(CRUDParser.OptPKContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#insertStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsertStmt(CRUDParser.InsertStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#optCols}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptCols(CRUDParser.OptColsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#idLista}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdLista(CRUDParser.IdListaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#valorLista}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValorLista(CRUDParser.ValorListaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#valor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValor(CRUDParser.ValorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#selectStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectStmt(CRUDParser.SelectStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#seleccion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeleccion(CRUDParser.SeleccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#optWhere}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptWhere(CRUDParser.OptWhereContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#updateStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdateStmt(CRUDParser.UpdateStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#asignLista}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsignLista(CRUDParser.AsignListaContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#asign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsign(CRUDParser.AsignContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#deleteStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteStmt(CRUDParser.DeleteStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(CRUDParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(CRUDParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#fact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFact(CRUDParser.FactContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRel(CRUDParser.RelContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#opRel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpRel(CRUDParser.OpRelContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#boolExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolExpr(CRUDParser.BoolExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#boolT}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolT(CRUDParser.BoolTContext ctx);
	/**
	 * Visit a parse tree produced by {@link CRUDParser#boolF}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolF(CRUDParser.BoolFContext ctx);
}