# Punto 1: Creación de la gramatica CRUD

## 1. Introducción

Este documento describe la gramática formal de un lenguaje tipo SQL CRUD, el cual permite realizar operaciones básicas de **creación, inserción, consulta, actualización y eliminación de datos**.  


---

## 2. Símbolo inicial

El símbolo inicial de la gramática es:

```
Programa → SentenciaLista
```

Esto significa que todo programa válido está compuesto por una lista (posiblemente vacía) de sentencias CRUD.

---

## 3. Sentencias principales

El lenguaje soporta cinco tipos de sentencias, cada una finalizada por punto y coma (`;`):

```
Sentencia → CreateTable ';'
           | Insert ';'
           | Select ';'
           | Update ';'
           | Delete ';'
```

### Explicación
Cada alternativa corresponde a una operación fundamental:
- `CreateTable` define una nueva tabla y su estructura.
- `Insert` agrega registros a una tabla existente.
- `Select` consulta información.
- `Update` modifica registros existentes.
- `Delete` elimina registros de la tabla.

---

## 4. Definición de una tabla (CREATE TABLE)

```
CreateTable → 'CREATE' 'TABLE' id '(' DefCampoLista OptPK ')'
DefCampoLista → DefCampo RestCampos
RestCampos    → ',' DefCampo RestCampos | ε
DefCampo      → id Tipo
Tipo          → 'INT' | 'FLOAT' | 'TEXT'
OptPK         → ',' 'PRIMARY' 'KEY' '(' id ')' | ε
```

### Explicación
- La sentencia comienza con las palabras reservadas **CREATE TABLE**, seguidas del nombre de la tabla (`id`).
- Dentro de paréntesis se listan los **campos** con su tipo de dato (`INT`, `FLOAT` o `TEXT`).
- De forma opcional (`OptPK`), se puede declarar una **clave primaria (PRIMARY KEY)** que identifica de forma única cada registro.

**Ejemplo:**
```
CREATE TABLE estudiantes (id INT, nombre TEXT, edad INT, PRIMARY KEY (id));
```

---

## 5. Inserción de registros (INSERT)

```
Insert → 'INSERT' 'INTO' id OptCols 'VALUES' '(' ValorLista ')'
OptCols → '(' IdLista ')' | ε
IdLista → id RestoIds
RestoIds → ',' id RestoIds | ε
ValorLista → Valor RestoVals
RestoVals → ',' Valor RestoVals | ε
Valor → num | str | 'TRUE' | 'FALSE'
```

### Explicación
- Se utiliza para **insertar filas** dentro de una tabla.
- Si se especifican columnas (`OptCols`), solo se insertan en esas columnas; si no, se asume el orden del esquema.
- Los valores pueden ser numéricos (`num`), cadenas (`str`) o booleanos (`TRUE`, `FALSE`).

**Ejemplo:**
```
INSERT INTO estudiantes VALUES (1, "Julian", 20);
```

---

## 6. Consulta de registros (SELECT)

```
Select → 'SELECT' Seleccion 'FROM' id OptWhere
Seleccion → '*' | IdLista
OptWhere → 'WHERE' Bool | ε
```

### Explicación
- Permite **consultar información** desde una tabla.
- Si se usa `*`, se seleccionan todas las columnas.
- La cláusula `WHERE` es opcional y permite filtrar los resultados mediante expresiones booleanas.

**Ejemplo:**
```
SELECT * FROM estudiantes WHERE edad > 18;
```

---

## 7. Actualización de registros (UPDATE)

```
Update → 'UPDATE' id 'SET' AsignLista OptWhere
AsignLista → Asign RestoAsign
RestoAsign → ',' Asign RestoAsign | ε
Asign → id '=' Expr
```

### Explicación
- Modifica uno o varios campos de las filas que cumplan la condición `WHERE`.
- `AsignLista` permite hacer varias asignaciones separadas por comas.
- `Expr` define una expresión aritmética o literal.

**Ejemplo:**
```
UPDATE estudiantes SET edad = edad + 1 WHERE id = 1;
```

---

## 8. Eliminación de registros (DELETE)

```
Delete → 'DELETE' 'FROM' id OptWhere
```

### Explicación
- Elimina los registros de una tabla.
- Si no se incluye la condición `WHERE`, se eliminan todas las filas.

**Ejemplo:**
```
DELETE FROM estudiantes WHERE edad < 18;
```

---

## 9. Expresiones aritméticas

```
Expr → Expr '+' Term | Expr '-' Term | Term
Term → Term '*' Fact | Term '/' Fact | Fact
Fact → '(' Expr ')' | id | num
```

### Explicación
Define las operaciones matemáticas básicas con precedencia de operadores:
- `*` y `/` tienen mayor prioridad que `+` y `-`.
- Los paréntesis permiten alterar la precedencia natural.
- Las expresiones pueden incluir identificadores de columnas (`id`) o números (`num`).

**Ejemplo:**
```
edad = edad + 1
```

---

## 10. Expresiones relacionales y booleanas

```
Rel → Expr OpRel Expr
OpRel → '=' | '<>' | '<' | '<=' | '>' | '>='

Bool → Bool 'OR' BoolT | BoolT
BoolT → BoolT 'AND' BoolF | BoolF
BoolF → 'NOT' BoolF | '(' Bool ')' | Rel | id | 'TRUE' | 'FALSE'
```

### Explicación
- `Rel` permite comparar dos expresiones aritméticas.
- Los operadores relacionales (`=`, `<>`, `<`, `>`, `<=`, `>=`) devuelven un valor booleano.
- Las reglas `Bool`, `BoolT` y `BoolF` permiten combinar expresiones con operadores lógicos (`AND`, `OR`, `NOT`).

**Ejemplo:**
```
WHERE edad >= 18 AND nombre <> "Camila"
```

---

## 11. Características generales

- Todas las sentencias terminan con punto y coma `;`.
- Los identificadores (`id`) representan nombres de tablas o columnas.
- El lenguaje distingue entre tipos de datos básicos: **INT**, **FLOAT**, y **TEXT**.
- Las expresiones booleanas permiten realizar condiciones compuestas.
- La gramática está diseñada para ser **determinista y sin ambigüedades**, adecuada para ser procesada por un analizador sintáctico descendente (LL(1)).

---

## 12. Conclusión

Esta gramática define un lenguaje formal simple pero completo para realizar operaciones CRUD sobre estructuras tabulares.  
La gramática sirve como base teórica para el diseño e implementación de un **analizador sintáctico o intérprete** de un lenguaje SQL reducido.
