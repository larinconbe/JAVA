package com.ejercicioarreglos;

public class Main {
    public static void main(String[] args) {

        int numeros[] = { 5, 10, 15, 20, 25 };
        int resultado = sumarNumeros(numeros);
        System.out.println(resultado);

        metodo1();
        metodo3();

    }

    public static void metodo1() {
        int id4 = 67;
        int id5 = 89;

        int[] ids = { 25, 30, 35, 40, 45, 50, 55, 60, 65, 70, 75, 80 };

        int numero = ids[6]; // Lectura del arreglo --> 55

        System.out.println(ids.length); // Muestra el tamaño del arreglo
        System.out.println(ids[ids.length - 1]); // Muestra el ultimo elemento del arreglo
        System.out.println(ids[5]); // Muestra la posicion 5 del arreglo, la primer posicion es cero

        ids[5] = 100; // Reemplazar el valor en la posicion 5 del arreglo

        System.out.println(ids[5]); // Imprimir la posicion 5 con el nuevo valor

        // Declarar un array de enteros

        int[] numeross;

        // Inicializacion de un aarray con tamaño definido

        int numeros[] = new int[10]; // Nombre del arreglo - Tipo de arreglo - Tamañño de arreglo

        int numerosx[] = { 1, 2, 3, 4, 5 }; // Inicializar un arreglo con valores definidos

    }

    public static int sumarNumeros(int[] numeros) {
        int suma = 0;

        for (int i = 0; i < numeros.length; i++) {
            suma += numeros[i]; // Lectura del arreglo

        }
        return suma;
    }

    public static void metodo3() {

        double[][] notasEstudiantes = {
                { 4.5, 3.2, 5.0, 4.8 }, // zona sur
                { 3.5, 2.2 }, // zona norte
                { 2.5, 4.2, 3.0, 4.8 }, // zona oriente
                { 4.5, 3.2, 5.0, 4.8, 5.0 }, // zona occidente
                { 3.5, 2.2, 4.0 } // zona centro
        };

        for (int i = 0; i < notasEstudiantes.length; i++) {
            for (int j = 0; j < notasEstudiantes[i].length; j++) {
                System.out.print(notasEstudiantes[i][j] + " ");
            }
            System.out.println();
        }
    }

}