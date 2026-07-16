package com.devsenior.model;

import java.util.Objects;

// Clase jugador
public class Jugador {
    // Atributos del jugador
    private String nickname;
    private int nivel;
    private int puntos;

    // Constructor para el jugador
    public Jugador(String nickname, int nivel, int puntos) {
        this.nickname = nickname;
        this.nivel = nivel;
        this.puntos = puntos;
    }

    // Encapsulamiento --> get y set
    public String getNickname() {
        return nickname;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    // Validar si dos objetos Jugador deben considerarse iguales
    @Override // Sobreescritura de metodo
    public boolean equals(Object o) { // Metodo publico, recibe cualquier objeto, retorna true / false
        if (this == o) // Comparacion de referencias al objeto en memoria
            return true; // Devuelve true si las variables apuntan al mismo objeto en memoria
        if (o == null || getClass() != o.getClass()) // Valida si el objeto es null y retorna false si lo es y si son de
                                                     // diferentes clases
            return false;
        Jugador jugador = (Jugador) o; // Conversion de tipo casting, si no es null y es un objeto jugador para el
                                       // acceso a los atributos
        return Objects.equals(nickname, jugador.nickname); // Dos objetos Jugador son iguales si tienen el mismo valor
                                                           // en el atributo nickname
    }

    @Override // Sobreescritura del metodo hashCode de la clade object
    public int hashCode() { // Metodo publico debe devolver un numero entero
        return Objects.hash(nickname); // Calcula un hash basándose en el atributo nickname
    }

    // Metodo toString --> Convierte objetos a cadenas de texto
    @Override
    public String toString() {
        return "Jugador{" +
                "nickname='" + nickname +
                ", nivel=" + nivel +
                ", puntos=" + puntos +
                '}';
    }

}
