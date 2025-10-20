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
  
