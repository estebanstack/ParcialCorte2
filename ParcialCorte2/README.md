# Punto 2: Implementacion en ANTLR4 con visitor

## 1. Introducción

Este proyecto implementa un **intérprete de un lenguaje SQL reducido** que permite realizar las operaciones CRUD básicas:
- **C**reate → creación de tablas.  
- **R**ead → consultas con `SELECT`.  
- **U**pdate → modificación de registros.  
- **D**elete → eliminación de registros.

El sistema fue desarrollado en Java a partir de una **gramática formal** definida en el archivo `CRUD.g4`, la cual modela la sintaxis del lenguaje.  
El comportamiento semántico se implementa en la clase `EvalVisitor.java`, y la ejecución se controla desde el archivo `Main.java`.  
Las instrucciones a ejecutar se encuentran en el archivo `prueba.txt`.

---

## 2. Descripción de los archivos

### 1. `CRUD.g4`
Este archivo contiene la **gramática del lenguaje CRUD**, escrita en formato compatible con analizadores sintácticos de tipo LL(1).  
Define todas las reglas necesarias para reconocer la estructura de las sentencias SQL básicas.

#### Secciones principales:
- **Reglas de parser (sintaxis):**
  - `programa`, `sentencia`, `createTable`, `insertStmt`, `selectStmt`, `updateStmt`, `deleteStmt`.
  - También incluye subreglas como `expr`, `term`, `fact`, `rel`, `boolExpr`, etc., para manejar expresiones aritméticas y lógicas.
- **Reglas léxicas (tokens):**
  - Palabras clave (`CREATE`, `TABLE`, `INSERT`, `SELECT`, `UPDATE`, `DELETE`, `AND`, `OR`, etc.).
  - Operadores (`=`, `<>`, `<`, `>`, `<=`, `>=`, `+`, `-`, `*`, `/`).
  - Tipos de dato (`INT`, `FLOAT`, `TEXT`).
  - Identificadores (`ID`), números (`NUM`), cadenas (`STR`), y valores lógicos (`TRUE`, `FALSE`).
  - Ignora comentarios y espacios en blanco.

#### En resumen:
`CRUD.g4` define **cómo debe escribirse una sentencia CRUD** para que el programa la reconozca correctamente.

---

### 2. `EvalVisitor.java`

Este archivo contiene la **lógica semántica del lenguaje**, es decir, lo que el intérprete hace cuando encuentra una instrucción válida.  
Implementa un *visitor* que recorre el árbol sintáctico generado y ejecuta las operaciones correspondientes.

#### Funciones principales:

| Operación | Método principal | Descripción |
|------------|------------------|--------------|
| **CREATE TABLE** | `visitCreateTable` | Crea una tabla en memoria con su nombre, columnas, tipos de datos y clave primaria opcional. |
| **INSERT** | `visitInsertStmt` | Inserta una nueva fila (registro) en una tabla existente. Valida tipos y PK duplicada. |
| **SELECT** | `visitSelectStmt` | Consulta y muestra los registros de una tabla. Soporta `*` y condiciones `WHERE`. |
| **UPDATE** | `visitUpdateStmt` | Modifica los valores de una o varias columnas según una condición. |
| **DELETE** | `visitDeleteStmt` | Elimina registros según la condición especificada. |
| **Expresiones aritméticas** | `visitExpr`, `visitTerm`, `visitFact` | Evalúan sumas, restas, multiplicaciones y divisiones. |
| **Expresiones booleanas** | `visitRel`, `visitBoolExpr`, `visitBoolT`, `visitBoolF` | Evalúan condiciones con `AND`, `OR`, `NOT` y operadores relacionales. |

#### Estructura de datos interna:
- Las tablas se representan con una clase interna `Table`, que contiene:
  - Un `LinkedHashMap<String, String>` para el esquema (`columna → tipo`).
  - Una lista de registros (`List<LinkedHashMap<String, Object>>`).
  - Un campo `primaryKey` opcional.
- Los datos se almacenan **en memoria** (no hay persistencia en disco).

#### Ejemplo de ejecución interna:
1. `CREATE TABLE estudiantes (...)` → crea la estructura de la tabla.  
2. `INSERT INTO estudiantes ...` → agrega filas con validación de tipos.  
3. `SELECT * FROM estudiantes` → imprime registros en consola.  
4. `UPDATE` y `DELETE` modifican la lista interna de registros.

---

###  3. `Main.java`

El archivo `Main.java` es el **punto de entrada del programa**.  
Su función es **leer un archivo de texto con sentencias CRUD**, analizarlo y ejecutarlo con ayuda del visitor.

#### Flujo de ejecución:
1. Verifica que se haya pasado un archivo como parámetro (`prueba.txt`).
2. Lee todo el contenido del archivo.
3. Crea los componentes del analizador:
   - **Lexer:** separa las palabras clave y símbolos.
   - **Parser:** construye el árbol sintáctico.
4. Si hay errores de sintaxis, los muestra con la línea y posición exactas.
5. Si todo es válido, crea un `EvalVisitor` y lo usa para ejecutar las operaciones.

#### Uso en consola:
```bash
javac *.java
java Main prueba.txt
```

---

###  4. `prueba.txt`

Archivo de entrada que contiene las **sentencias CRUD** que el programa interpretará.

#### Contenido de ejemplo:
```sql
CREATE TABLE estudiantes (id INT, nombre TEXT, edad INT, PRIMARY KEY (id));
INSERT INTO estudiantes VALUES (1, "Julian", 20);
INSERT INTO estudiantes VALUES (2, "Camila", 21);
SELECT * FROM estudiantes;
UPDATE estudiantes SET edad = edad + 1 WHERE nombre = "Julian";
SELECT * FROM estudiantes;
DELETE FROM estudiantes WHERE id = 2;
SELECT * FROM estudiantes;
```

#### Descripción del flujo:
1. **CREATE TABLE** → crea la tabla `estudiantes`.  
2. **INSERT** → inserta dos registros.  
3. **SELECT** → muestra todos los registros.  
4. **UPDATE** → incrementa en 1 la edad de “Julian”.  
5. **DELETE** → elimina a la estudiante con `id = 2`.  
6. **SELECT final** → muestra el resultado actualizado.

#### Salida esperada:
```
Tabla creada: estudiantes {id=INT, nombre=TEXT, edad=INT} PK=id
INSERT en estudiantes: {id=1, nombre=Julian, edad=20}
INSERT en estudiantes: {id=2, nombre=Camila, edad=21}
{id=1, nombre=Julian, edad=20}
{id=2, nombre=Camila, edad=21}
UPDATE estudiantes: filas afectadas = 1
{id=1, nombre=Julian, edad=21}
{id=2, nombre=Camila, edad=21}
DELETE estudiantes: filas afectadas = 1
{id=1, nombre=Julian, edad=21}

 Ejecución completada sin errores.
```

---

## 3. Ejecucion y pruebas de ejecución

Para ejecutar el programa se deben ingresar los siguientes comandos:

```bash
antlr4 -visitor -no-listener CRUD.g4
javac Main.java CRUD*.java
java Main prueba.txt
```
A continuacion se presentan las pruebas de ejecución con los archivos del repositorio

<img width="650" height="512" alt="image" src="https://github.com/user-attachments/assets/73f43c61-da46-40d8-a0f0-53ada0cd62c1" />

---

## 4. Conclusión

El conjunto de archivos implementa un **sistema completo de interpretación de lenguaje CRUD**, donde:

- `CRUD.g4` define la **estructura formal del lenguaje**.
- `EvalVisitor.java` define la **semántica de ejecución**.
- `Main.java` controla el **flujo de análisis y ejecución**.
- `prueba.txt` actúa como **entrada de pruebas**.

