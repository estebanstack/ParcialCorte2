import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Uso: java Main <archivo.txt>");
            System.exit(1);
        }

        String fileName = args[0];
        try {
            // Leer el archivo de entrada completo
            CharStream input = CharStreams.fromFileName(fileName);

            // Crear lexer y parser de ANTLR4
            CRUDLexer lexer = new CRUDLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            CRUDParser parser = new CRUDParser(tokens);

            // Manejo de errores personalizado
            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                                        int line, int charPositionInLine, String msg, RecognitionException e) {
                    System.err.println("Error de sintaxis en línea " + line + ":" + charPositionInLine + " - " + msg);
                }
            });

            // Parsear el archivo
            ParseTree tree = parser.programa();

            // Crear el visitor y ejecutar las sentencias
            EvalVisitor visitor = new EvalVisitor();
            visitor.visit(tree);

            System.out.println("\n Ejecución completada sin errores.");

        } catch (IOException e) {
            System.err.println("No se pudo leer el archivo: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println(" Error durante la ejecución: " + e.getMessage());
        }
    }
}
