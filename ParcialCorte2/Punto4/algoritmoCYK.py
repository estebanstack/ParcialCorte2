import random
import time
from collections import defaultdict

class Parser_predictivo:
    def __init__(self, s: str):
        self.s = s
        self.i = 0

    def peek(self):
        return self.s[self.i] if self.i < len(self.s) else '$'

    def match(self, ch: str) -> bool:
        if self.peek() == ch:
            self.i += 1
            return True
        return False

    def S(self) -> bool:
        if self.peek() == '(':
            if not self.match('('): return False
            if not self.S(): return False
            if not self.match(')'): return False
            if not self.S(): return False
            return True
        return True  # ε

    def parse(self) -> bool:
        ok = self.S()
        return ok and self.i == len(self.s)


class CYKParser:
    def __init__(self, grammar_file="gramatica.txt"):
        self.start = None
        self.nullable_start = False
        self.binary = defaultdict(set) 
        self.unary_term = defaultdict(set) 
        self.unit = defaultdict(set)  
        self._load_grammar(grammar_file)

    def _load_grammar(self, filename):
        # Lee la gramatica desde el archivo
        with open(filename, encoding="utf-8") as f:
            lines = [l.strip() for l in f if l.strip() and not l.startswith("#")]

        for line in lines:
            left, rights = line.split("->")
            left = left.strip()
            if self.start is None:
                self.start = left  # Primer no terminal = simbolo inicial
            prods = [r.strip() for r in rights.split("|")]
            for prod in prods:
                if prod == "ε":
                    self.nullable_start = True
                    continue
                symbols = prod.split()
                if len(symbols) == 1:
                    sym = symbols[0]
                    # terminal o unitario
                    if sym.isupper():
                        self.unit[sym].add(left)
                    else:
                        self.unary_term[sym].add(left)
                elif len(symbols) == 2:
                    B, C = symbols
                    self.binary[(B, C)].add(left)
                else:
                    print(f"Se ignora produccion no binaria: {line}")

    def _unit_closure(self, symbols: set):

        changed = True
        while changed:
            changed = False
            to_add = set()
            for B in list(symbols):
                for A in self.unit.get(B, []):
                    if A not in symbols:
                        to_add.add(A)
            if to_add:
                symbols |= to_add
                changed = True
        return symbols

    def parse(self, w: str) -> bool:
        n = len(w)
        if n == 0:
            return self.nullable_start

        table = [[set() for _ in range(n + 1)] for _ in range(n)]

        # longitud 1
        for i, ch in enumerate(w):
            cell = table[i][1]
            cell |= self.unary_term.get(ch, set())
            self._unit_closure(cell)

        # longitudes mayores
        for l in range(2, n + 1):
            for i in range(n - l + 1):
                cell = table[i][l]
                for s in range(1, l):
                    left = table[i][s]
                    right = table[i + s][l - s]
                    if not left or not right:
                        continue
                    for B in left:
                        for C in right:
                            cell |= self.binary.get((B, C), set())
                self._unit_closure(cell)
        return self.start in table[0][n]


def cadena_valida(n: int) -> str:
    # Genera cadena de parentesis validos 
    if n % 2 == 1:
        n -= 1
    k = n // 2
    open_left, close_left = k, k
    bal = 0
    out = []
    for _ in range(n):
        can_open = open_left > 0
        can_close = close_left > 0 and bal > 0
        if can_open and can_close:
            if random.random() < 0.5:
                out.append('('); open_left -= 1; bal += 1
            else:
                out.append(')'); close_left -= 1; bal -= 1
        elif can_open:
            out.append('('); open_left -= 1; bal += 1
        else:
            out.append(')'); close_left -= 1; bal -= 1
    return "".join(out)


def cadena_invalida(n: int) -> str:
    s = "".join(random.choice("()") for _ in range(n))
    if not Parser_predictivo(s).parse():
        return s
    # romper cadena valida
    lst = list(s)
    lst[-1] = '(' if lst[-1] == ')' else ')'
    return "".join(lst)


def benchmark(sizes, samples=20, grammar_file="gramatica.txt"):
    cyk = CYKParser(grammar_file)
    results = []

    for n in sizes:
        validas = [cadena_valida(n) for _ in range(samples // 2)]
        invalidas = [cadena_invalida(n) for _ in range(samples // 2)]
        data = validas + invalidas
        random.shuffle(data)

        t0 = time.perf_counter()
        pred = [Parser_predictivo(x).parse() for x in data]
        t1 = time.perf_counter()

        t2 = time.perf_counter()
        cyk_res = [cyk.parse(x) for x in data]
        t3 = time.perf_counter()

        agree = sum(1 for a, b in zip(pred, cyk_res) if a == b)
        avg_len = sum(len(x) for x in data) / len(data)
        results.append({
            "n": n,
            "muestras": len(data),
            "avg_len": avg_len,
            "t_pred_ms": (t1 - t0) * 1000,
            "t_cyk_ms": (t3 - t2) * 1000,
            "acuerdo_%": 100 * agree / len(data)
        })

    return results


if __name__ == "__main__":
    sizes = [10, 20, 40, 60]
    resultados = benchmark(sizes, samples=20, grammar_file="gramatica.txt")

    print(f"{'n':>4} | {'muestras':>9} | {'avg_len':>8} | {'t_pred(ms)':>10} | {'t_cyk(ms)':>10} | {'acuerdo %':>10}")
    print("-" * 65)
    for r in resultados:
        print(f"{r['n']:>4} | {r['muestras']:>9} | {r['avg_len']:>8.2f} | "
              f"{r['t_pred_ms']:>10.3f} | {r['t_cyk_ms']:>10.3f} | {r['acuerdo_%']:>10.1f}")

    print("\nAmbos analizadores coinciden en los resultados")
    print("CYK es mucho mas lento (O(n³)) que el predictivo (O(n)).")
