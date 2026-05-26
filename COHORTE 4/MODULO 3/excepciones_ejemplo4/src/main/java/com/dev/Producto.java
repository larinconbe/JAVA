package com.dev;
// Clase producto
public class Producto {
    // Atributos

    private String Nombre;
    private int CantidadDisponible;
    // Constructo

    public Producto(String Nombre, int CantidadDisponible) {
        this.Nombre = Nombre;
        this.CantidadDisponible = CantidadDisponible;
    }
    // Get y Set
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getCantidadDisponible() {
        return CantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        CantidadDisponible = cantidadDisponible;
    }
    // Metodo para reducir la cantidad
    public void reducirCantidad (int cantidad){
        if (this.CantidadDisponible < cantidad){
            throw new StockInsuficienteException("Stock insuficiente para el producto"+ Nombre);
        }
        this.CantidadDisponible -= cantidad;
    }

}
