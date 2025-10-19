
enum Token {
    id, num, mas, por, lparen, rparen, eof
}

interface Lexico {
    Token getNextToken();  // Devuelve el siguiente token
    int getLine();
    int getColumn();
}


class LexicoPrueba implements Lexico {
    private final Token[] tokens;
    private int index = 0;

    public LexicoPrueba(Token[] tokens) {
        this.tokens = tokens;
    }

    @Override
    public Token getNextToken() {
        if (index < tokens.length) {
            return tokens[index++];
        }
        return Token.eof;
    }

    @Override
    public int getLine() { return 1; }  // simplificado
    @Override
    public int getColumn() { return index; }
}


public class Parser {
    private final Lexico lexico;
    private Token token; // token actual

    public Parser(Lexico lexico) {
        this.lexico = lexico;
    }


    public void parse() {
        token = lexico.getNextToken();
        S(); // símbolo inicial
        if (token != Token.eof) {
            errorSintaxis("eof");
        } else {
            System.out.println("Analisis sintactico completado correctamente");
        }
    }


    private void emparejar(Token tokEsperado) {
        if (token == tokEsperado) {
            System.out.println("Emparejado: " + tokEsperado);
            token = lexico.getNextToken();
        } else {
            errorSintaxis(tokEsperado.name());
        }
    }

    // Gramatica:
    // S → T mas T 
    private void S() {
        T();
        while (token == Token.mas) {
            emparejar(Token.mas);
            T();
        }
    }

    // T → F por F 
    private void T() {
        F();
        while (token == Token.por) {
            emparejar(Token.por);
            F();
        }
    }

    // F → num | id | lparen S rparen
    private void F() {
        switch (token) {
            case num : {
            	emparejar(Token.num);
     		break;
            	}
            case id : {
            	emparejar(Token.id);
	        break;
            }
            case lparen : {
                emparejar(Token.lparen);
                S();
                emparejar(Token.rparen);
                break;
            }
            default : {
            	errorSintaxis("num, id o lparen");
            	break;
            }
        }
    }

    private void errorSintaxis(String esperado) {
        String msg = String.format(
            "Error de sintaxis: se esperaba %s, se encontró %s (posición %d).",
            esperado, token, lexico.getColumn()
        );
        throw new RuntimeException(msg);
    }

    public static void main(String[] args) {

		// ENTRADA DEL PROGRAMA (MODIFICAR SEGUN LO QUE DESEA EMPAREJAR)
        Token[] entrada = {
            Token.num, Token.mas, Token.eof
        };

        // Inicializa el lexico con esos tokens
        Lexico lexico = new LexicoPrueba(entrada);

        // Crea el parser
        Parser parser = new Parser(lexico);

        // Ejecutamos el analisis
        try {
            parser.parse();
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
