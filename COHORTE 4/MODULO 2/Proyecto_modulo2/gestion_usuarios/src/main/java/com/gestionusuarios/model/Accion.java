package com.gestionusuarios.model;

// Clase accion con los atributos
public class Accion {
    private String descripcion;
    private long timestamp;

    // Constructor
    public Accion(String descripcion) {
        this.descripcion = descripcion;
        this.timestamp = System.currentTimeMillis();
    }

    // Metodos get
    public String getDescripcion() {
        return descripcion;
    }

    public long getTimestamp() {
        return timestamp;

    }

    // Metodo toString
    @Override
    public String toString() {
        return "Accion{" +
                "descripcion ='" + descripcion + '\'' +
                ", timestamp = " + timestamp +
                '}';
    }

}
