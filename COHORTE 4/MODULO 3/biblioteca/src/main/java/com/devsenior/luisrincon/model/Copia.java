package com.devsenior.luisrincon.model;

public class Copia {
    private Integer identificador;
    private Libro libro;
    private EstadoCopia estado;

    public Copia(Libro libro) {
        this(libro, EstadoCopia.BIBLIOTECA);

    }

    public Copia(Libro libro, EstadoCopia estado) {
        this.libro = libro;
        this.estado = estado;
        this.identificador = 1;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public void setIdentificador(Integer identificador) {
        this.identificador = identificador;
    }

    public Libro getLibro() {
        return libro;
    }

    public EstadoCopia getEstado() {
        return estado;
    }

    public void setEstado(EstadoCopia estado) {
        this.estado = estado;
    }

}
