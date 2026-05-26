package com.dev;

import java.util.HashMap;
import java.util.Map;

// Clase inventario
public class Inventario {
    // Lista de productos
    private Map<String, Producto> productos = new HashMap<>();

    // Metodo para agregar productos
    public void agregarProducto(Producto producto) {
        productos.put(producto.getNombre(), producto);
    }

    // Metodo procesar producto con la excepcion
    // Busca producto por nombre, verifica si existe, reduce la cantidad del
    // producto
    public void procesarProducto(String nombre, int cantidad) throws ProductoNoEncontradoException {
        Producto producto = productos.get(nombre);

        // Si el producto no existe devuelve null y lanza la excepcion

        if (producto == null) {
            throw new ProductoNoEncontradoException("Producto no encontrado: " + nombre);
        }
        // Utiliza el metodo reducir cantidad
        producto.reducirCantidad(cantidad);
    }

}
