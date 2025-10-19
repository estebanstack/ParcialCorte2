# Análisis sintáctico descendente recursivo

## 1. Diseño general del sistema

El proyecto está dividido en dos partes:  
- Un **documento de diseño** (`diseño`) donde se explica la estructura teórica y la planeación del analizador.  
- Un **programa en Java** (`Parser.java`) que implementa un **parser descendente recursivo** basado en el diseño.

El objetivo del trabajo es **simular el funcionamiento de un analizador sintáctico** que reconozca expresiones aritméticas simples con suma (`mas`) y multiplicación (`por`), a partir de una **gramática libre de contexto**.

---

## 2. Diseño

En este archivo se define la **planeación conceptual** del parser, que incluye:

### 🔹 a) Tipo de analizador
El diseño plantea un **analizador sintáctico descendente recursivo**, es decir:
- Cada **no terminal** de la gramática se representa como un **método en Java**.
- El analizador **llama recursivamente** a estos métodos siguiendo las reglas de producción.
- El proceso termina cuando toda la entrada ha sido leída correctamente.

### 🔹 b) Estructura general
El sistema se divide en tres componentes:

1. **Analizador léxico (Lexico):**  
   - Se encarga de entregar los tokens uno a uno al parser.  
   - En este caso se implementa una clase de prueba llamada `LexicoPrueba`, que simula una secuencia de tokens predefinida en un arreglo.

2. **Analizador sintáctico (Parser):**  
   - Contiene la lógica recursiva para verificar si la secuencia de tokens cumple la gramática.  
   - Implementa la función `emparejar()` para validar tokens.

3. **Gramática usada:**  
   El diseño trabaja con la siguiente gramática:
   ```
   S → T mas T 
   T → F por F 
   F → num | id | lparen S rparen
   ```
   Esta gramática reconoce **expresiones aritméticas** formadas por números, identificadores y operaciones con suma y multiplicación, incluyendo paréntesis.

---

## 3. Implementación (archivo `Parser.java`)

### 🔸 Estructura del código

El archivo contiene todas las clases necesarias para ejecutar el análisis:

1. **Enum Token:**  
   Define los posibles tokens del lenguaje:
   ```java
   enum Token {
       id, num, mas, por, lparen, rparen, eof
   }
   ```

2. **Interfaz Lexico:**  
   Declara los métodos que debe tener un analizador léxico:
   ```java
   interface Lexico {
       Token getNextToken();
       int getLine();
       int getColumn();
   }
   ```

3. **Clase LexicoPrueba:**  
   Simula un léxico muy simple usando un arreglo de tokens.  
   Su función es devolver el siguiente token en cada llamada a `getNextToken()`.

4. **Clase Parser:**  
   Es la clase principal del programa.  
   - Contiene el **token actual** y el **objeto léxico**.  
   - Implementa los métodos que representan los **no terminales** de la gramática (`S`, `T`, `F`).  
   - Usa el método **`emparejar()`** para verificar los tokens.

---

## 4. Funcionamiento del parser

### 🔹 a) Método `parse()`
Es el punto de entrada del análisis:
```java
public void parse() {
    token = lexico.getNextToken();  // obtiene el primer token
    S();                            // símbolo inicial
    if (token != Token.eof) {
        errorSintaxis("eof");
    } else {
        System.out.println("Análisis sintáctico completado correctamente");
    }
}
```
1. Toma el primer token.  
2. Llama al método `S()` (símbolo inicial de la gramática).  
3. Al finalizar, verifica que la entrada haya llegado al final (`eof`).

---

### 🔹 b) Método `emparejar()`
Verifica si el token actual coincide con el esperado:
```java
private void emparejar(Token tokEsperado) {
    if (token == tokEsperado) {
        System.out.println("Emparejado: " + tokEsperado);
        token = lexico.getNextToken();
    } else {
        errorSintaxis(tokEsperado.name());
    }
}
```
- Si **coincide**, imprime el token emparejado y avanza.  
- Si **no coincide**, lanza un error de sintaxis.

En otras palabras, *“emparejar”* significa *confirmar que el token actual corresponde al que la gramática esperaba en ese punto*.

---

### 🔹 c) Métodos `S()`, `T()`, `F()`
Cada uno representa un **no terminal** de la gramática.

#### `S → T mas T`
```java
private void S() {
    T();
    while (token == Token.mas) {
        emparejar(Token.mas);
        T();
    }
}
```
Reconoce expresiones con sumas (`a + b + c`).

#### `T → F por F`
```java
private void T() {
    F();
    while (token == Token.por) {
        emparejar(Token.por);
        F();
    }
}
```
Reconoce multiplicaciones (`a * b * c`).

#### `F → num | id | lparen S rparen`
```java
private void F() {
    switch (token) {
        case num -> emparejar(Token.num);
        case id -> emparejar(Token.id);
        case lparen -> {
            emparejar(Token.lparen);
            S();
            emparejar(Token.rparen);
        }
        default -> errorSintaxis("num, id o lparen");
    }
}
```
Reconoce factores: números, identificadores o subexpresiones entre paréntesis.

---

## 5. Ejemplo de ejecución

Entrada simulada:
```java
Token[] entrada = { Token.num, Token.mas, Token.id, Token.por, Token.num, Token.eof };
```

Salida esperada:
```
Emparejado: num
Emparejado: mas
Emparejado: id
Emparejado: por
Emparejado: num
Análisis sintáctico completado correctamente
```

---

##  6. Manejo de errores

El método `errorSintaxis()` se activa cuando el token encontrado **no coincide** con el esperado:

```java
private void errorSintaxis(String esperado) {
    String msg = String.format(
        "Error de sintaxis: se esperaba %s, se encontró %s (posición %d).",
        esperado, token, lexico.getColumn()
    );
    throw new RuntimeException(msg);
}
```

Ejemplo:
```
Entrada: mas num eof
Salida: Error de sintaxis: se esperaba num, id o lparen, se encontró mas (posición 1)
```

---

## 7. Ejemplo de uso y pruebas de ejecución
Para ejecutar el codigo se tienen que usar los siguientes comandos
```bash
javac Parser.java
java Parser
```
A continuación se presenta una evidencia con diferentes pruebas en este caso una en donde si empareja los tokens y otra en la que se produce un error de sintaxis

<img width="680" height="334" alt="image" src="https://github.com/user-attachments/assets/eaea6cf1-e4a2-49ef-8e4f-63f7074c4721" />

---

## 8. Conclusión

Este proyecto demuestra cómo funciona la base de un **analizador sintáctico descendente recursivo**:
- El diseño parte de una **gramática formal**.  
- Cada **no terminal** se implementa como un método recursivo.  
- El parser usa el método **emparejar()** para validar y avanzar entre tokens.  
- La estructura modular (léxico + parser) facilita la extensión futura del analizador.

