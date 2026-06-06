package com.devsenior;

public class Main {
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        int resultado = calc.sumar(5, 10);

        System.out.println("La suma es: " +resultado );
    }
}