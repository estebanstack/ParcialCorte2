grammar CRUD;

programa
  : sentenciaLista EOF
  ;

sentenciaLista
  : (sentencia)*
  ;

sentencia
  : createTable ';'
  | insertStmt  ';'
  | selectStmt  ';'
  | updateStmt  ';'
  | deleteStmt  ';'
  ;

// CREATE TABLE 

createTable
  : CREATE TABLE ID '(' defCampoLista optPK ')'
  ;

defCampoLista
  : defCampo (',' defCampo)*
  ;

defCampo
  : ID tipo
  ;

tipo
  : INT
  | FLOAT
  | TEXT
  ;

optPK
  : (',' PRIMARY KEY '(' ID ')')?
  ;

// INSERT

insertStmt
  : INSERT INTO ID optCols VALUES '(' valorLista ')'
  ;

optCols
  : ('(' idLista ')')?
  ;

idLista
  : ID (',' ID)*
  ;

valorLista
  : valor (',' valor)*
  ;

valor
  : NUM
  | STR
  | TRUE
  | FALSE
  ;

// SELECT

selectStmt
  : SELECT seleccion FROM ID optWhere
  ;

seleccion
  : STAR
  | idLista
  ;

optWhere
  : (WHERE boolExpr)?
  ;

// UPDATE

updateStmt
  : UPDATE ID SET asignLista optWhere
  ;

asignLista
  : asign (',' asign)*
  ;

asign
  : ID EQ expr
  ;

// DELETE

deleteStmt
  : DELETE FROM ID optWhere
  ;

// --- Expresiones aritméticas (LL(1)) ---

expr
  : term (('+' | '-') term)*
  ;

term
  : fact (('*' | '/') fact)*
  ;

fact
  : '(' expr ')'
  | ID
  | NUM
  | STR
  ;

// Relacionales y booleanas

rel
  : expr opRel expr
  ;

opRel
  : EQ
  | NEQ
  | LT
  | LE
  | GT
  | GE
  ;

boolExpr
  : boolT ('OR' boolT)*
  ;

boolT
  : boolF ('AND' boolF)*
  ;

boolF
  : NOT boolF
  | '(' boolExpr ')'
  | rel
  | ID
  | TRUE
  | FALSE
  ;

// Reglas del LEXER

// Palabras clave
CREATE : 'CREATE';
TABLE  : 'TABLE';
INSERT : 'INSERT';
INTO   : 'INTO';
VALUES : 'VALUES';
SELECT : 'SELECT';
FROM   : 'FROM';
WHERE  : 'WHERE';
UPDATE : 'UPDATE';
SET    : 'SET';
DELETE : 'DELETE';
AND    : 'AND';
OR     : 'OR';
NOT    : 'NOT';
TRUE   : 'TRUE';
FALSE  : 'FALSE';
INT    : 'INT';
FLOAT  : 'FLOAT';
TEXT   : 'TEXT';
PRIMARY: 'PRIMARY';
KEY    : 'KEY';

// Operadores y símbolos
EQ   : '=';
NEQ  : '<>';     
LE   : '<=';
LT   : '<';
GE   : '>=';
GT   : '>';
STAR : '*';

// Identificadores y literales
ID   : [a-zA-Z_][a-zA-Z_0-9]* ;

// Números: enteros o reales (simple)
NUM  : [0-9]+ ('.' [0-9]+)? ;

// Cadenas "..." con escapes básicos
STR  : '"' ( '\\' . | ~["\\\r\n] )* '"' ;

// Espacios y comentarios
WS       : [ \t\r\n]+ -> skip ;
LINE_CMT : '//' ~[\r\n]* -> skip ;
BLOCK_CMT: '/*' .*? '*/' -> skip ;
