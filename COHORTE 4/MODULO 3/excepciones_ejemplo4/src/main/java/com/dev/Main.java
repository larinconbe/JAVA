package com.dev;

public class Main {
    public static void main(String[] args) {
        // Se crea un inventario de la clase inventario
        Inventario inventario = new Inventario();
        // Se agregan productos al inventario
        inventario.agregarProducto(new Producto("Laptop", 10));
        inventario.agregarProducto(new Producto("Samrtphone", 20));
        inventario.agregarProducto(new Producto("Teclado", 8));
        inventario.agregarProducto(new Producto("Monitor", 25));
        // Se utiliza el metodo de procesar producto con la respectiva excepcion
        try {
            inventario.procesarProducto("Laptop", 10);
            inventario.procesarProducto("Samrtphone", 20);
            inventario.procesarProducto("Teclado", 8);
            inventario.procesarProducto("Monitor", 25);
            inventario.procesarProducto("Tablet", 25);
        } catch (ProductoNoEncontradoException | StockInsuficienteException e) {
            System.out.println(e.getMessage());
        }

    }
}