package com.devsenior;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {

        CuentaBancaria cuenta = new CuentaBancaria(100);
        try {
            cuenta.Retirar(20);
        } catch (SaldoInsuficienteExcept e) {
            // TODO Auto-generated catch block
        }

        // Llamo los metodos creados
        ejemplo1();
        ejemplo2();
        ejemplo3();
        ejemplo4();
    }

    // Ejemplo 1
    private static void ejemplo1() {
        try {
            int a = 12;
            int b = 0;
            System.out.println(a / b);
            System.out.println("El resultado es: " + a / b);
            System.out.println("Fin del programa");
        } catch (ArithmeticException e) {
            System.out.println("No es posible dividir por cero");
        }
    }

    private static void ejemplo2() {
        try {
            String texto = "ABC";
            int numero = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            System.out.println("Error en el formato del numero");
        }
    }

    private static void ejemplo3() {
        try {
            int[] arreglo = { 1, 2, 3 };
            System.out.println(arreglo[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No es posible leer la posicion del array");
        }
    }

    private static void ejemplo4() {
        try {
            FileReader archivo = new FileReader("Archivo.txt");
        } catch (FileNotFoundException e) {
            System.out.println("No es posible leer el archivo");

        }
    }
}