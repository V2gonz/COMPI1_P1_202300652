package src.Reportes;

public class ErrorL {

    public String tipo;
    public String descripcion;
    public int linea;
    public int columna;

    public ErrorL(String tipo, String descripcion, int linea, int columna){
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.linea = linea;
        this.columna = columna;
    }

}
