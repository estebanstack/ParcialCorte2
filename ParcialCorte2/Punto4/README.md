# 📘 Análisis Sintáctico: Parser Predictivo vs. CYK  
**Universidad Sergio Arboleda – Lenguajes de Programación**  
**Autor:** Julián David Briñez Sánchez  
**Archivo principal:** `algoritmoCYK.py`  
**Gramática:** `gramatica.txt`

---

## 🧩 Descripción General

El proyecto implementa y compara dos métodos de **análisis sintáctico** para el mismo lenguaje formal de **paréntesis bien balanceados**:

- **Parser predictivo (LL(1))**  
  Implementa un analizador recursivo descendente que usa una gramática libre de contexto simple.

- **Parser CYK (Cocke–Younger–Kasami)**  
  Implementa un analizador sintáctico basado en **programación dinámica**, utilizando una **gramática en forma normal de Chomsky (FNC)** cargada desde un archivo externo `gramatica.txt`.

Ambos parsers determinan si una cadena pertenece al lenguaje definido por la gramática y comparan sus resultados y tiempos de ejecución.

---

## 📄 Estructura de Archivos

### 1. `algoritmoCYK.py`
Contiene toda la lógica del programa, dividida en cuatro secciones principales:

#### a) **Parser Predictivo**
```python
class Parser_predictivo:
```
- Usa la gramática:
  ```
  S → ( S ) S | ε
  ```
- Funciona de manera recursiva con una pila implícita (llamadas de función).
- La función `parse()` acepta si toda la cadena es consumida correctamente.

#### b) **Parser CYK**
```python
class CYKParser:
```
- Lee la gramática desde `gramatica.txt`.
- Convierte las reglas a tres tipos de producciones:
  - **Binarias:** A → BC
  - **Unarias de terminal:** A → a
  - **Unitarias:** A → B  
- Calcula el *closure* de reglas unitarias (`_unit_closure`) para completar la tabla.

#### c) **Generación de cadenas**
Funciones que crean datos de prueba:

```python
def cadena_valida(n)
def cadena_invalida(n)
```
- `cadena_valida(n)` genera cadenas bien balanceadas de longitud aproximada `n`.
- `cadena_invalida(n)` genera cadenas aleatorias que **no** pertenecen al lenguaje.

#### d) **Benchmark**
```python
def benchmark(sizes, samples=20, grammar_file="gramatica.txt")
```
- Prueba ambos parsers con cadenas válidas e inválidas de diferentes tamaños (`sizes`).
- Mide el tiempo de ejecución (en milisegundos).
- Calcula el porcentaje de acuerdo entre los dos analizadores.
- Muestra los resultados en formato de tabla.

---

### 2. `gramatica.txt`
Define la **gramática en FNC (Forma Normal de Chomsky)** usada por el algoritmo CYK.

```text
S -> L U | ε
U -> S V | V
V -> R S | R
L -> (
R -> )
```

**Explicación de la gramática:**

| No terminal | Descripción | Producciones |
|--------------|--------------|--------------|
| S | Símbolo inicial, puede generar una secuencia balanceada o vacía | L U  /  ε |
| U | Parte derecha de una producción balanceada | S V / V |
| V | Cierra un par de paréntesis y continúa | R S / R |
| L | Paréntesis izquierdo | ( |
| R | Paréntesis derecho | ) |

Esta gramática genera exactamente las cadenas con paréntesis balanceados, por ejemplo:
```
(), (()), ()(), (()())
```

---

## ⚙️ Ejecución del Programa

1. Asegúrate de tener ambos archivos en la misma carpeta:
   ```
   algoritmoCYK.py
   gramatica.txt
   ```

2. Ejecuta el programa desde terminal:
   ```bash
   python3 algoritmoCYK.py
   ```

3. Verás una salida como la siguiente:

```
   n |  muestras |  avg_len | t_pred(ms) |  t_cyk(ms) |  acuerdo %
-----------------------------------------------------------------
  10 |        20 |     9.00 |      0.028 |      0.342 |      100.0
  20 |        20 |    18.00 |      0.042 |      1.215 |      100.0
  40 |        20 |    36.00 |      0.085 |      7.421 |      100.0
  60 |        20 |    54.00 |      0.132 |     21.844 |      100.0

✅ Ambos analizadores coinciden en los resultados.
   CYK es mucho más lento (O(n³)) que el predictivo (O(n)).
```

---

## 📊 Análisis de Resultados

- **Exactitud:**  
  Ambos analizadores coinciden al 100% en sus decisiones (aceptar o rechazar una cadena).

- **Rendimiento:**  
  - El **predictivo** tiene complejidad lineal **O(n)**.
  - El **CYK** tiene complejidad cúbica **O(n³)**.  
    Por eso, el tiempo crece mucho más rápido al aumentar el tamaño de las cadenas.

- **Conclusión:**  
  El parser predictivo es mucho más eficiente pero solo funciona con gramáticas LL(1).  
  CYK es más general y puede manejar cualquier gramática en FNC, aunque a costa de un mayor costo computacional.

---

## 💡 Cómo Sustentar

1. **Explica el lenguaje:** paréntesis bien balanceados.  
2. **Muestra la gramática original y su forma en FNC.**  
3. **Comenta las diferencias:**  
   - Predictivo → recursivo y eficiente.  
   - CYK → dinámico y más general.  
4. **Interpreta la tabla de resultados.**  
5. **Conclusión:** Ambos detectan las mismas cadenas, pero el parser predictivo es más rápido.

---

## 📚 Referencias
- Hopcroft, J. E., Motwani, R., & Ullman, J. D. *Introduction to Automata Theory, Languages, and Computation*.
- Aho, A. V., Lam, M. S., Sethi, R., & Ullman, J. D. *Compilers: Principles, Techniques, and Tools* (Dragon Book).
- Notas de clase: **Lenguajes de Programación – Universidad Sergio Arboleda**
