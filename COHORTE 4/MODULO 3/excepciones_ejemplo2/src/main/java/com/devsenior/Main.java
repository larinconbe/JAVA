package com.devsenior;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws DivisionInvalidException {
        //ejemplo1();
        ejemplo2();

    }
    // Metodo ejemplo 1

    /**
     * Solicita al usuario un numerador y un denominador para realizar una división.
     * El proceso se repetirá hasta que los datos sean válidos y la operación se
     * complete sin errores.
     * 
     * Maneja:
     * - ArithmeticException: si el denominador es cero.
     * - InputMismatchException: si se ingresa un valor no numérico.
     */
    public static void ejemplo1() {
        // Se crea el objeto scanner para almacenar los valores ingresados por consola
        Scanner sc = new Scanner(System.in);
        // Exito controla si la operación fue exitosa para salir del bucle.
        boolean exito = false;
        // El bloque se ejecuta hasta que exito sea true
        do {
            // Se crea el try catch para capturar el error
            try {
                // Leer el numerador
                System.out.println("Ingrese el numerador");
                int numerador = sc.nextInt();
                // Leer el denominador
                System.out.println("Ingrese el denominador");
                int denominador = sc.nextInt();
                // Almacenar el resultado de la division en la variable resultado
                int resultado = numerador / denominador;
                System.out.println("El resultado de la division es: " + resultado);
                // Exito es igual a true si las variables son correctas y se genera la division
                exito = true;
                // De lo contrario se captura la excepcion en el cath de tipo
                // ArithmeticException
            } catch (ArithmeticException e) {
                // Imprime no es posible dividir entre cero
                System.out.println("No es posible dividir por cero" + e.getMessage());
                // Limpia el bufer
                sc.nextLine();
                // Captura el error y genera la excepcion si el valor ingresado no es un numero
                // entero
            } catch (InputMismatchException e) {
                // Imprime que solo es posible ingresar numeros
                System.out.println("Solo es posible ingresar numeros");
                // Limpia el bufer
                sc.nextLine();

            }
            // Se repite el ciclo si exito es false y vuelve a pedir los valores por consola
        } while (exito == false);
        // Cierra el scanner
        sc.close();
    }

    // Metodo ejemplo 2
    public static void ejemplo2() {

        // Se crea objeto de la clase scaner para pedir datos por consola
        Scanner scanner = new Scanner(System.in);
        // Solicita el numerador
        System.out.println("Ingrese un numerador:");
        // Almacena el numerador
        int numerador = scanner.nextInt();
        // Solicita el denominador
        System.out.println("Ingrese un denominador:");
        // Almacena el denominador
        int denominador = scanner.nextInt();
        // Valida el denominador, no puede ser cero
        if (denominador == 0) {
            // Lanza la excepecion
            // En vez de hacer el try-catch, se lanza una excepción personalizada si el
            // denominador es cero.
            throw new DivisionInvalidException("El denominador no puede ser cero.");
        }
        
        // Almacena el resultado
        int resultado = numerador / denominador; // excepción si denominador es cero
        // Imprime el resultado si el denominador es diferente de cero
        System.out.println("El resultado de la división es: " + resultado);
        scanner.close();
    }
}
