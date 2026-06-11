package com.devsenior;

// Clase calculadora
public class Calculadora {
    // Metodo para sumar 2 numeros enteros, retorna la suma de los enteros
    public int sumar(int a, int b) {
        return a + b;
    }

    // Metodo para restar 2 numeros enteros, retorna la resta de los enteros
    public int restar(int a, int b) {
        return a - b;
    }

    // Metodo para multiplicar 2 numeros enteros, retorna la multiplicacion de los
    // enteros
    public int multiplicar(int a, int b) {
        return a * b;
    }

    // Metodo para dividir 2 numeros enteros, retorna la division de los enteros
    public int dividir(int a, int b) {
        // Valida si el denominador es cero, muestra una excepcion de tipo argumento
        // ilegal
        if (b == 0) {
            throw new IllegalArgumentException("No es posible dividir por cero");
        }
        // Si el denominador no es cero, retorna la division

        return a / b;
    }

}
