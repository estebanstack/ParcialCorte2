import re
import sys
from collections import defaultdict

def leer_gramatica(archivo):
    gramatica = defaultdict(list)
    with open(archivo, "r", encoding="utf-8") as f:
        for linea in f:
            linea = linea.strip()
            if not linea or "->" not in linea:
                continue
            izquierda, derecha = linea.split("->")
            izquierda = izquierda.strip()
            producciones = [p.strip().split() for p in derecha.split("|")]
            gramatica[izquierda].extend(producciones)
    return gramatica


def calcular_primeros(gramatica):
    first = defaultdict(set)


    for A, prods in gramatica.items():
        for prod in prods:
            if prod and prod[0] not in gramatica and prod[0] != "ε":
                first[A].add(prod[0])
            if prod == ["ε"]:
                first[A].add("ε")

    cambio = True
    while cambio:
        cambio = False
        for A, prods in gramatica.items():
            for prod in prods:
                old_len = len(first[A])
                if prod == ["ε"]:
                    first[A].add("ε")
                else:
                    for simbolo in prod:
                        if simbolo in gramatica:
                            first[A] |= (first[simbolo] - {"ε"})
                            if "ε" not in first[simbolo]:
                                break
                        else:
                            if simbolo != "ε":
                                first[A].add(simbolo)
                            else:
                                first[A].add("ε")
                            break
                    else:
                        first[A].add("ε")
                if len(first[A]) > old_len:
                    cambio = True
    return first

# Primero de una cadena α , devolviendo set con posible 'ε'
def first_de_cadena(alpha, gramatica, first):
    if not alpha:
        return {"ε"}
    out = set()
    for s in alpha:
        if s in gramatica:
            out |= (first[s] - {"ε"})
            if "ε" not in first[s]:
                return out
        else:
            if s != "ε":
                out.add(s)
                return out
            # si s == ε seguimos, equivalente a vacio
    # si todos pueden producir ε
    out.add("ε")
    return out


def calcular_siguientes(gramatica, first, simbolo_inicial):
    follow = defaultdict(set)
    follow[simbolo_inicial].add("$")

    cambio = True
    while cambio:
        cambio = False
        for A, prods in gramatica.items():
            for prod in prods:
                for i, B in enumerate(prod):
                    if B in gramatica:
                        beta = prod[i+1:]
                        first_beta = first_de_cadena(beta, gramatica, first)
                        old_len = len(follow[B])
                        follow[B] |= (first_beta - {"ε"})
                        if "ε" in first_beta:
                            follow[B] |= follow[A]
                        if len(follow[B]) > old_len:
                            cambio = True
    return follow

def calcular_predicciones(gramatica, first, follow):
    pred = {}
    for A, prods in gramatica.items():
        for prod in prods:
            first_alpha = first_de_cadena(prod, gramatica, first)
            conj = set(first_alpha) - {"ε"}
            if "ε" in first_alpha:
                conj |= follow[A]
            pred[(A, tuple(prod))] = conj
    return pred

def construir_tabla(gramatica, first, follow):
    tabla = defaultdict(dict)
    for A, producciones in gramatica.items():
        for prod in producciones:
            first_prod = first_de_cadena(prod, gramatica, first)
            for a in (first_prod - {"ε"}):
                tabla[A][a] = prod
            if "ε" in first_prod:
                for b in follow[A]:
                    tabla[A][b] = ["ε"]
    return tabla

def analizar(cadena, simbolo_inicial, tabla):
    tokens = re.findall(r"id|\+|\*|\(|\)|ε|\$", cadena)
    if "$" not in tokens:
        tokens.append("$")

    pila = ["$", simbolo_inicial]
    i = 0
    paso = 1

    print(f"{'Paso':<5}{'Pila':<25}{'Entrada':<25}{'Accion'}")
    print("-" * 70)

    while pila:
        tope = pila[-1]
        actual = tokens[i]

        pila_str = " ".join(pila[::-1])
        entrada_str = " ".join(tokens[i:])

        if tope == actual == "$":
            print(f"{paso:<5}{pila_str:<25}{entrada_str:<25}ACEPTA")
            return True

        if tope not in tabla and tope == actual:
            print(f"{paso:<5}{pila_str:<25}{entrada_str:<25}match '{actual}'")
            pila.pop()
            i += 1

        elif tope in tabla:
            if actual in tabla[tope]:
                prod = tabla[tope][actual]
                pila.pop()
                if prod != ["ε"]:
                    for s in reversed(prod):
                        pila.append(s)
                prod_str = " ".join(prod)
                print(f"{paso:<5}{pila_str:<25}{entrada_str:<25}{tope} → {prod_str}")
            else:
                print(f"{paso:<5}{pila_str:<25}{entrada_str:<25}ERROR (no regla para {tope}, {actual})")
                return False
        else:
            print(f"{paso:<5}{pila_str:<25}{entrada_str:<25}ERROR (simbolo '{tope}')")
            return False

        paso += 1

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Uso: python analizador.py <cadena.txt>")
        sys.exit(1)

    archivo_gramatica = "gramatica.txt"
    archivo_cadenas = sys.argv[1]

    gramatica = leer_gramatica(archivo_gramatica)
    simbolo_inicial = list(gramatica.keys())[0]

    first = calcular_primeros(gramatica)
    follow = calcular_siguientes(gramatica, first, simbolo_inicial)
    pred = calcular_predicciones(gramatica, first, follow)
    tabla = construir_tabla(gramatica, first, follow)

    print("Gramatica:")
    for nt, reglas in gramatica.items():
        print(f"  {nt} -> {' | '.join(' '.join(r) for r in reglas)}")

    print("\nPrimeros:")
    for k in gramatica.keys():
        print(f"  {k} = {first[k]}")

    print("\nSiguientes:")
    for k in gramatica.keys():
        print(f"  {k} = {follow[k]}")

    print("\nPredicciones:")
    # ordenar salida por no terminal y producción
    for (A, prod) in sorted(pred.keys(), key=lambda x: (x[0], list(x[1]))):
        rhs = " ".join(prod)
        print(f"  PRED({A} -> {rhs}) = {pred[(A, prod)]}")

    print("\nANALISIS DE CADENAS")
    with open(archivo_cadenas, "r", encoding="utf-8") as f:
        lineas = [l.strip() for l in f.readlines() if l.strip()]

    for expr in lineas:
        print(f"\nCadena: {expr}")
        analizar(expr, simbolo_inicial, tabla)
