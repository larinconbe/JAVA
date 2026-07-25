package com.devsenior;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        // Cómo imprimir de forma descendente los puntajes en el formato: nombre -
        // puntaje?
        TreeMap<Integer, String> puntajes = new TreeMap<>();
        puntajes.put(1, "Juan");
        puntajes.put(15, "Ana");
        puntajes.put(20, "Luis");
        puntajes.put(35, "Maria");
        puntajes.put(400, "Carlos");

        System.out.println(puntajes.size());
        // descendingMap()
        // Devuelve una vista del TreeMap ordenada de mayor a menor:
        // entrySet() Convierte el mapa en un conjunto de pares clave-valor:

        for (Map.Entry<Integer, String> entry : puntajes.descendingMap().entrySet()) {
            System.out.println(entry.getValue() + " - " + entry.getKey());
        }

    }
}