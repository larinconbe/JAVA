package com.devsenior.luisrincon.model;

import java.time.LocalDate;

public class Prestamo {
    private LocalDate fechaPrestamo;
    private Lector lector;
    private Copia copia;

    public Prestamo(Lector lector, Copia copia) {
        this.lector = lector;
        this.copia = copia;
        fechaPrestamo = LocalDate.now();
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }

    public Copia getCopia() {
        return copia;
    }

    public void setCopia(Copia copia) {
        this.copia = copia;
    }
}
