package src.Reportes;

import java.util.ArrayList;
import java.util.List;

public class TablaTokens {

    public static List<Token> listaTokens = new ArrayList<>();

    public static void agregar(String tipo, String lexema, int linea, int columna){
        listaTokens.add(new Token(tipo, lexema, linea, columna));
    }

    public static void imprimir(){

        for(Token t : listaTokens){
            System.out.println(
                    "Tipo: " + t.tipo +
                    " Lexema: " + t.lexema +
                    " Linea: " + t.linea +
                    " Columna: " + t.columna
            );
        }

    }

}
