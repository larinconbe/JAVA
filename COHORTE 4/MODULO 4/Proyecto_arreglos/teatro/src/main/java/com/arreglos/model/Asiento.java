package com.arreglos.model;

public class Asiento {

    private EstadoAsiento estado;

    public Asiento() {
        this.estado = EstadoAsiento.LIBRE;
    }

    public EstadoAsiento Getestado() {
        return estado;
    }

    public void setEstado(EstadoAsiento estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Asiento{" +
                "Estado = " + estado +
                '}';
    }

    public boolean isLibre() {
        return this.estado == EstadoAsiento.LIBRE;
    }
}
