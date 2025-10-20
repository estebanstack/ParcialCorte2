# 1) Transformación a LL(1)


- Gramática original
  
  E → E + T | T

  T → T * F | F

  F → ( E ) | id
  

- Versión LL(1):

  E → T E'

  E' → + T E' | ε

  T → F T'

  T' → * F T' | ε

  F → ( E ) | id
  

# 2) Conjuntos Primeros, Siguientes y Prediccion.


Primeros

  F = { '(', id }
  
  T = { '(', id }
  
  T' = { '*', ε }
  
  E = { '(', id }
  
  E' = { '+', ε }
  

Siguientes

  E = { ')', $ }
  
  E' = { ')', $ }
  
  T = { '+', ')', $ }
  
  T' = { '+', ')', $ }
  
  F = { '*', '+', ')', $ }
  

Prediccion

  E → T E' : { '(', id }
  
  E' → + T E' : { '+' }
  
  E' → ε : { ')', $ }
  
  T → F T' : { '(', id }
  
  T' → * F T' : { '*' }
  
  T' → ε : { '+', ')', $ }
  
  F → ( E ) : { '(' }
  
  F → id : { id }
  
