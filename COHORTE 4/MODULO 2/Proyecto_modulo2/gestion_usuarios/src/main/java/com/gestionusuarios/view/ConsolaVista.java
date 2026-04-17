package com.gestionusuarios.view;

import java.util.Scanner;

/**
 * Muestra el menú principal en consola.
 */

public class ConsolaVista {
    // Permite leer datos ingresados por teclado
    private Scanner scanner = new Scanner(System.in);

    // Metodo para imprimir el menu en consola con las opciones que se van
    // a brindar al usuario
    public void mostrarMenuPrincipal() {
        System.out.println("\n===== SISTEMA DE USUARIOS =====");
        System.out.println("1. Login");
        System.out.println("2. Crear usuario");
        System.out.println("3. Actualizar usuario");
        System.out.println("4. Eliminar usuario");
        System.out.println("5. Ver historial");
        System.out.println("0. Salir");
        System.out.print("Seleccione: ");
    }

    // Muestra un mensaje y lee el texto ingresado por el usuario
    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    // Metodo para leer un numero entero
    public int leerEntero() {
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        return valor;
    }

    // Metodo para leer un entero con mensaje
    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return leerEntero();
    }

    // Metodo para imprimir un mensaje
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
