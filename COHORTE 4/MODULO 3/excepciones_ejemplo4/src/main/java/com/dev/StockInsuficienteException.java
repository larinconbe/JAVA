package com.dev;

// Clase que crea una excepcion en el momento de ejecucion, si el saldo es insuficiente
// La excepcion es de tipo unchecked --> se lanza en tiempo de ejecucion
public class StockInsuficienteException extends RuntimeException {
    // Constructor de la clase, usa el mensaje de la clase padre runtimeexcepcion
    public StockInsuficienteException(String message) {
        super(message);
    }

}
