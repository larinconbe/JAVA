package com.devsenior.luisrincon.model;

public class Libro {
    private String nombre;
    private String editorial;
    private Integer anio;
    private Copia[] copias;
    private Autor autor;
    private TipoLibro tipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Copia[] getCopias() {
        return copias;
    }

    public void setCopias(Copia[] copias) {
        this.copias = copias;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public TipoLibro getTipo() {
        return tipo;
    }

    public void setTipo(TipoLibro tipo) {
        this.tipo = tipo;
    }

}
