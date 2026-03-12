package src.Reportes;

public class Token {

    public String tipo;
    public String lexema;
    public int linea;
    public int columna;

    public Token(String tipo, String lexema, int linea, int columna){
        this.tipo = tipo;
        this.lexema = lexema;
        this.linea = linea;
        this.columna = columna;
    }

}
