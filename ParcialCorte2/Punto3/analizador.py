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

    # Inicializa los primeros con terminales
    for A, prods in gramatica.items():
        for prod in prods:
            if prod[0] not in gramatica:
                first[A].add(prod[0])

    cambio = True
    while cambio:
        cambio = False
        for A, prods in gramatica.items():
            for prod in prods:
                old_len = len(first[A])
                for simbolo in prod:
                    if simbolo in gramatica:
                        first[A] |= (first[simbolo] - {"ε"})
                        if "ε" not in first[simbolo]:
                            break
                    else:
                        first[A].add(simbolo)
                        break
                else:
                    first[A].add("ε")
                if len(first[A]) > old_len:
                    cambio = True
    return first


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
                        first_beta = set()
                        if beta:
                            for s in beta:
                                first_beta |= (first[s] - {"ε"}) if s in gramatica else {s}
                                if s not in gramatica or "ε" not in first[s]:
                                    break
                            else:
                                first_beta.add("ε")
                        else:
                            first_beta.add("ε")

                        old_len = len(follow[B])
                        follow[B] |= (first_beta - {"ε"})
                        if "ε" in first_beta:
                            follow[B] |= follow[A]
                        if len(follow[B]) > old_len:
                            cambio = True
    return follow


def construir_tabla(gramatica, first, follow):
    tabla = defaultdict(dict)
    for A, producciones in gramatica.items():
        for prod in producciones:
            first_prod = set()
            for s in prod:
                first_prod |= (first[s] - {"ε"}) if s in gramatica else {s}
                if s not in gramatica or "ε" not in first[s]:
                    break
            else:
                first_prod.add("ε")
            for a in first_prod - {"ε"}:
                tabla[A][a] = prod
            if "ε" in first_prod:
                for b in follow[A]:
                    tabla[A][b] = prod
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
            print(f"{paso:<5}{pila_str:<25}{entrada_str:<25}ERROR (símbolo '{tope}')")
            return False

        paso += 1


if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Uso: python analizador.py <archivo_cadenas>")
        sys.exit(1)

    archivo_gramatica = "gramatica.txt"
    archivo_cadenas = sys.argv[1]

    gramatica = leer_gramatica(archivo_gramatica)
    simbolo_inicial = list(gramatica.keys())[0]

    first = calcular_primeros(gramatica)
    follow = calcular_siguientes(gramatica, first, simbolo_inicial)
    tabla = construir_tabla(gramatica, first, follow)

    print("Gramatica:")
    for nt, reglas in gramatica.items():
        print(f"  {nt} -> {' | '.join(' '.join(r) for r in reglas)}")

    print("\nPrimeros:")
    for k, v in first.items():
        print(f" ({k}) = {v}")

    print("\nSiguientes:")
    for k, v in follow.items():
        print(f" ({k}) = {v}")

    print("\nANALISIS DE CADENAS")

    # Lee cadenas desde archivo
    with open(archivo_cadenas, "r", encoding="utf-8") as f:
        lineas = [l.strip() for l in f.readlines() if l.strip()]

    for expr in lineas:
        print(f"\nAnalizando: {expr}")
        analizar(expr, simbolo_inicial, tabla)
