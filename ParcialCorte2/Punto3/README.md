1) Transformación a LL(1) (eliminando recursión izquierda)

Gramática original
E → E + T | T
T → T * F | F
F → ( E ) | id

Versión LL(1):

E → T E'

E' → + T E' | ε

T → F T'

T' → * F T' | ε

F → ( E ) | id

No hay más factores comunes, así que es LL(1).

2) Conjuntos FIRST, FOLLOW y PRED

FIRST
FIRST(F) = { '(', id }
FIRST(T) = { '(', id }
FIRST(T') = { '*', ε }
FIRST(E) = { '(', id }
FIRST(E') = { '+', ε }

FOLLOW (símbolo de fin: $)
FOLLOW(E) = { ')', $ }
FOLLOW(E') = { ')', $ }
FOLLOW(T) = { '+', ')', $ }
FOLLOW(T') = { '+', ')', $ }
FOLLOW(F) = { '*', '+', ')', $ }

PRED (conjuntos de predicción)
E → T E' : { '(', id }
E' → + T E' : { '+' }
E' → ε : { ')', $ }
T → F T' : { '(', id }
T' → * F T' : { '*' }
T' → ε : { '+', ')', $ }
F → ( E ) : { '(' }
F → id : { id }
