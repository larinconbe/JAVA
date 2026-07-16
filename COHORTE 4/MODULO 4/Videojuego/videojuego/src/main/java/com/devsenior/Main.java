package com.devsenior;

import java.util.Scanner;

import com.devsenior.controller.JuegoService;
import com.devsenior.model.Jugador;

public class Main {
    public static void main(String[] args) {
        // Instancia el servicio de JuegoService para usarlo
        JuegoService service = new JuegoService();
        // Objeto Scanner sc para capturar valores de las lineas
        Scanner sc = new Scanner(System.in);
        // Variable opcion para capturar la opcion digitada por el usuario en el menu
        int opcion;
        // Do while para el menu
        do {
            System.out.println("\n==== MENÚ JUEGO ====");
            System.out.println("1. Conectar jugador");
            System.out.println("2. Desconectar jugador");
            System.out.println("3. Mostrar jugadores conectados");
            System.out.println("4. Agregar jugador a sala de espera");
            System.out.println("5. Sacar jugador de sala de espera");
            System.out.println("6. Mostrar sala de espera");
            System.out.println("7. Actualizar ranking");
            System.out.println("8. Mostrar ranking");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            // Captura la opcion digitada
            opcion = sc.nextInt();
            sc.nextLine();
            // Opciones seleccionadas --> Parametro opcion de tipo int para realizar la
            // accion seleccionada
            switch (opcion) {
                case 1:
                    System.out.print("Nickname: ");
                    String nick = sc.nextLine();
                    System.out.print("Nivel: ");
                    int nivel = sc.nextInt();
                    System.out.print("Puntos: ");
                    int puntos = sc.nextInt();
                    Jugador j = new Jugador(nick, nivel, puntos);
                    if (service.conectarJugador(j))
                        System.out.println("Jugador conectado.");
                    else
                        System.out.println("Ya estaba conectado.");
                    break;
                case 2:
                    System.out.print("Nickname: ");
                    nick = sc.nextLine();
                    Jugador j2 = new Jugador(nick, 0, 0);
                    if (service.desconectarJugador(j2))
                        System.out.println("Jugador desconectado.");
                    else
                        System.out.println("Jugador no encontrado.");
                    break;
                case 3:
                    service.mostrarJugadoresConectados();
                    break;
                case 4:
                    System.out.print("Nickname: ");
                    nick = sc.nextLine();
                    service.agregarASala(new Jugador(nick, 0, 0));
                    break;
                case 5:
                    service.sacarDeSala();
                    break;
                case 6:
                    service.mostrarSala();
                    break;
                case 7:
                    service.actualizarRanking();
                    System.out.println("Ranking actualizado.");
                    break;
                case 8:
                    service.mostrarRanking();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);

        sc.close();
    }
}
