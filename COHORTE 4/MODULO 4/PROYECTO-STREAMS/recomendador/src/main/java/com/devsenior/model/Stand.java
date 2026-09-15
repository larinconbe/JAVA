package com.devsenior.model;

// Clase stand con el atributo nombre
public class Stand {

    private String nombre;

    // Constructor
    public Stand(String nombre) {
        this.nombre = nombre;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Stand{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

}
