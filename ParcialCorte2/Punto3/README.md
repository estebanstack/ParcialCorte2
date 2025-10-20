# Analizador Sintáctico LL(1)

## Descripción General

Este proyecto implementa un **analizador sintáctico predictivo descendente LL(1)** en Python.  
El programa:

1. Lee una **gramática libre de contexto (GLC)** desde un archivo de texto.  
2. Calcula automáticamente los conjuntos FIRST, FOLLOW y PRED para cada producción.  
3. Construye la tabla LL(1) correspondiente.  
4. Lee un conjunto de cadenas de entrada desde un archivo externo.  
5. Analiza cada cadena paso a paso mediante una pila predictiva, mostrando el proceso completo.  

El analizador determina si cada cadena pertenece o no al lenguaje generado por la gramática.


# 1) Transformación a LL(1)

## Gramática original

  
  E → E + T | T

  T → T * F | F

  F → ( E ) | id

   
## Versión LL(1):

  E → T E'

  E' → + T E' | ε

  T → F T'

  T' → * F T' | ε

  F → ( E ) | id
  

# 2) Conjuntos Primeros, Siguientes y Prediccion.

## Primeros:
  
  E = { ')', '$' }

  T = { ')', '+', '$' }

  E' = { ')', '$' }

  F = { ')', '*', '+', '$' }

  T' = { ')', '+', '$' }
  

## Siguientes:
  
  E = { ')', '$' }

  T = { ')', '+', '$' }

  E' = { ')', '$' }

  F = { ')', '*', '+', '$' }

  T' = { ')', '+', '$' }
  

## Prediccion

  E → T E' : { '(', id }
  
  E' → + T E' : { '+' }
  
  E' → ε : { ')', $ }
  
  T → F T' : { '(', id }
  
  T' → * F T' : { '*' }
  
  T' → ε : { '+', ')', $ }
  
  F → ( E ) : { '(' }
  
  F → id : { id }

  ###  Conjunto FIRST
El conjunto FIRST(A) de un no terminal A contiene todos los símbolos terminales que pueden aparecer al inicio de alguna cadena derivada de **A**.

El algoritmo:
1. Si el primer símbolo de una producción es terminal, se agrega directamente.
2. Si es no terminal, se incorporan los FIRST de ese símbolo (sin ε).
3. Si todos los símbolos pueden derivar ε, entonces ε ∈ FIRST(A).

---

### Conjunto FOLLOW
El conjunto **FOLLOW(A)** contiene los terminales que pueden aparecer inmediatamente después de A en alguna derivación.

Reglas:
1. Agregar `$` a FOLLOW(S) del símbolo inicial.
2. Si hay una producción `A → α B β`, se añaden `FIRST(β) - {ε}` a FOLLOW(B).
3. Si `β ⇒* ε`, entonces `FOLLOW(A)` se agrega a `FOLLOW(B)`.

---

### Conjunto PRED
Para cada producción `A → α`, se define:

```
PRED(A → α) = FIRST(α) ∪ FOLLOW(A)  si ε ∈ FIRST(α)
```

Los conjuntos PRED determinan qué producción aplicar dependiendo del token de entrada.

---

###  Tabla LL(1)
La tabla LL(1) es una matriz [NoTerminal, Terminal], donde cada celda contiene la producción que se debe aplicar cuando el símbolo superior de la pila y el token actual coinciden.

---

###  Análisis Predictivo (por pila)
El analizador emplea una **pila** que inicia con `["$", S]` (S = símbolo inicial).  
En cada paso:

1. Se observa el símbolo superior de la pila (X) y el token actual (a).
2. Si X es terminal y coincide con `a`, se hace *match* y se avanza.
3. Si X es no terminal, se consulta la tabla LL(1) para aplicar la producción correspondiente.
4. Si no existe entrada válida en la tabla, se produce un error sintáctico.
5. El proceso termina con **ACEPTA** cuando ambos símbolos (`$`) se encuentran al tope y en la entrada.

---
