package com.devsenior.model;

import java.util.ArrayList;
import java.util.List;

public class Satelite {

    private String id;
    private Estado estado; // Atributo de tipo enum de la clase ESTADO
    private List<Double> mediciones; // Lista para agregar las mediciones, se declara con la interfaz

    // Constructor, al crear un objetto satelite se genera con una lista de
    // mediciones

    public Satelite(String id, Estado estado) {
        this.id = id;
        this.estado = estado;
        mediciones = new ArrayList<>(); // Instanciar la implementacion ArrayList
    }

    // getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Double> getMediciones() {
        return mediciones;
    }

    // Agregar medicion
    public void agregarMedicion(double medicion) {
        this.mediciones.add(medicion);
    }

    /*
     * public List<Double> obtenerMediciones(){
     * return this.mediciones;
     * }
     */

    @Override
    public String toString() {
        return "Satelite{" +
                "id='" + id + '\'' +
                ", estado=" + estado +
                ", mediciones=" + mediciones +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;// apuntando a la misma referencia en memoria ram
        if (obj == null || getClass() != obj.getClass())
            return false;// cuando es null o no son de la misma clase
        Satelite satelite = (Satelite) obj;
        return this.id.equals(satelite.id);// si sus id son iguales entonces son iguales
    }

}
