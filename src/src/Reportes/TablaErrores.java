package src.Reportes;

import java.util.ArrayList;
import java.util.List;

public class TablaErrores {

    public static List<ErrorL> listaErrores = new ArrayList<>();

    public static void agregar(String tipo, String descripcion, int linea, int columna){

        listaErrores.add(
            new ErrorL(tipo, descripcion, linea, columna)
        );

    }

    public static void imprimir(){

        if(listaErrores.isEmpty()){
            System.out.println("No se encontraron errores.");
            return;
        }

        for(ErrorL e : listaErrores){

            System.out.println(
                "Tipo: " + e.tipo +
                " | Descripción: " + e.descripcion +
                " | Línea: " + e.linea +
                " | Columna: " + e.columna
            );

        }

    }

}
