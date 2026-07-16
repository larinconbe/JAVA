package com.devsenior.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

import com.devsenior.model.Jugador;

// Clase servicio, contiene la logica de negocio
public class JuegoService {
    // Atributos --> Colecciones usadas segun la necesidad
    private HashSet<Jugador> jugadoresConectados; // No permite jugadores duplicados y busca rapido
    private ArrayList<Jugador> ranking; // Permite ordenar y acceder por indice
    private LinkedList<Jugador> salaDeEspera; // Funciona muy bien como cola -- Mantiene el orden de inserción. Es
                                              // eficiente para insertar y eliminar elementos.

    // Metodo constructor JuegoService --> Cuando se inicializa un juego se
    // inicializan las 3 colecciones vacias
    public JuegoService() {
        jugadoresConectados = new HashSet<>();
        ranking = new ArrayList<>();
        salaDeEspera = new LinkedList<>();
    }

    // Metodo boolean para conectar jugador
    public boolean conectarJugador(Jugador j) { // Metodo publico, recibe como parametro un objeto jugador, intenta
                                                // conectar un jugador sin permitir duplicados.
        if (jugadoresConectados.add(j)) {
            ranking.add(j);
            return true;
        }
        return false;
    }

    // Metodo boolean para sacar un jugador del sistema --> Parametro Jugador j
    public boolean desconectarJugador(Jugador j) {
        if (jugadoresConectados.remove(j)) { // Remueve el jugador si esta conectado
            ranking.remove(j); // Lo elimina del ranking
            salaDeEspera.remove(j); // Lo elimina de la sala
            return true; // Retorna true
        }
        return false; // De lo contrario retorna false
    }

    // Metodo para mostrar jugadores conectados
    public void mostrarJugadoresConectados() {
        System.out.println("\n=== Jugadores Conectados ==="); // Imprime el texto de jugadores conectados
        for (Jugador j : jugadoresConectados) { // Recorre el hashset de jugadoresconectados y los imprime en consola
            System.out.println(j);
        }
    }

    // Metodo para actualizar el ranking
    public void actualizarRanking() {
        // Ordena el arraylist de mayor a menor
        ranking.sort((a, b) -> Integer.compare(b.getPuntos(), a.getPuntos()));
    }

    // Metodo para mostrar el ranking
    public void mostrarRanking() {
        System.out.println("\n=== Ranking ===");
        // Recorre el ranking, imprime i + 1 para mostrar posiciones
        for (int i = 0; i < ranking.size(); i++) {
            System.out.println((i + 1) + ". " + ranking.get(i));
        }
    }

    // Metodo para agregar jugador a sala
    public void agregarASala(Jugador j) {
        // Verifica los jugadores conectados
        if (jugadoresConectados.contains(j)) {
            // Si esta conectado lo agrega al final de la cola
            salaDeEspera.add(j);
            System.out.println(j.getNickname() + " agregado a la sala de espera.");
            // Si no imprime el jugador debe estar conectado
        } else {
            System.out.println("El jugador debe estar conectado para entrar a la sala.");
        }
    }

    // Metodo para sacar jugador de la sala, saca al primer jugador de la cola
    public void sacarDeSala() {
        // Valida si la sala tiene jugadores
        if (!salaDeEspera.isEmpty()) {
            // Si tiene saca al primero de la cola
            Jugador j = salaDeEspera.removeFirst();
            System.out.println(j.getNickname() + " ha salido de la sala (inicia partida).");
        } else {
            // De lo contrario muestra sala vacia
            System.out.println("La sala está vacía.");
        }
    }

    // Metodo para mostrar la sala
    public void mostrarSala() {
        System.out.println("\n=== Sala de Espera ===");
        // Muestra los jugadores esperando
        for (Jugador j : salaDeEspera) {
            System.out.println(j);
        }
    }

}
