package com.gestionusuarios.view;

import java.util.Scanner;

public class ConsolaVista {
    private Scanner scanner = new Scanner(System.in);

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

    public String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    public int leerEntero() {
        int valor = scanner.nextInt();
        scanner.nextLine(); // limpiar buffer
        return valor;
    }

    public int leerEntero(String mensaje) {
        System.out.print(mensaje);
        return leerEntero();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
