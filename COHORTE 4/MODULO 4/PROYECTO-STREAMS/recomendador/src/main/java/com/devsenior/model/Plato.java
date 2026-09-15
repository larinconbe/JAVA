package com.devsenior.model;

// Clase plato con los atributos
public class Plato {

    private String nombre;
    private double precio;
    private int calorias;
    private Categoria categoria;
    private Stand stand;

    // Constructor
    public Plato(String nombre, double precio, int calorias, Categoria categoria, Stand stand) {
        this.nombre = nombre;
        this.precio = precio;
        this.calorias = calorias;
        this.categoria = categoria;
        this.stand = stand;

    }

    // Getters - setters
    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    // Metodo toString
    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "Precio: " + precio +
                "Categoria: " + categoria +
                "Calorias: " + calorias +
                "Stand: " + stand;
    }

}
