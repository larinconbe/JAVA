package com.dev;

// Clase que crea la excepcion para el producto no encontrado
// Hereda de la clase Excepcion, es una clase que obliga a manejar la 
// excepcion por ser checked
public class ProductoNoEncontradoException extends Exception {
    // Constructor, usa el mensaje de la clase padre de tipo String
    public ProductoNoEncontradoException(String message) {
        super(message);
    }

}
