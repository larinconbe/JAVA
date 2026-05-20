package com.devsenior;
// Esta clase define una excepción personalizada en Java.
// Se crea un tipo especial de error que se puede lanzar cuando ocurra una situación 
// inválida, en este caso una división incorrecta.
// Es una excepción no verificada (unchecked)
public class DivisionInvalidException extends RuntimeException{

    // Constructor
    // Esto recibe un mensaje y se lo pasa al constructor del padre (RuntimeException)
    public DivisionInvalidException (String message){
        super(message);
    }
}
