package Symbols;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TablaConjuntos {

    private final Map<String, Set<String>> tabla;

    public TablaConjuntos(){
        tabla = new HashMap<>();
    }

    public void agregar(String nombre, Set<String> elementos){
        tabla.put(nombre, elementos);
    }

    public Set<String> obtener(String nombre){
        return tabla.get(nombre);
    }

    public boolean existe(String nombre){
        return tabla.containsKey(nombre);
    }

    public void imprimir(){

        for(Map.Entry<String, Set<String>> entry : tabla.entrySet()){

            System.out.println(
                "Conjunto: " + entry.getKey() +
                " Elementos: " + entry.getValue()
            );

        }

    }

}