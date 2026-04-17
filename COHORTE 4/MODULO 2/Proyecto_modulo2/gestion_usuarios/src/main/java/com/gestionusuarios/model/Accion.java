package com.gestionusuarios.model;

// Clase accion con los atributos
public class Accion {
    private String descripcion;
    private long timestamp;

    // Constructor
    // Inicializa el atributo descripcion de tipo string para los objetos creados de la clase accion
    // el atributo timestamp se crea de manera automatica en el objeto

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
    // Prmite visualizar objetos creado de la clase accion
    @Override
    public String toString() {
        return "Accion{" +
                "descripcion ='" + descripcion + '\'' +
                ", timestamp = " + timestamp +
                '}';
    }

}
