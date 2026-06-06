package com.ejerciciolog;

// Sentencia de importacion ---> utilizar las clases que pertenecen al paquete
import org.apache.logging.log4j.*;

// Clase emppleado
public class Empleado {

    // Crear la variable logger para la clase empleado para registrar mensajes en
    // los archivos o consola

    private static final Logger logger = LogManager.getLogger(Empleado.class);
    // Atributos de la clase empleado
    private String nombre;
    private int edad;
    private double salario;

    // Cobstructor
    public Empleado(String nombre, int edad, double salario) {
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
        // Validar si la edad es menor que 18
        if (edad < 18) {
            // Registra un mensaje de nivel WARN (advertencia).
            logger.warn("El empleado " + nombre + "Es menor de edad.");
        }
    }

    // Metodo para aumentar salario
    public void aumentarSalario(double cantidad) {
        // Valida que la cantidad a aumentar sea mayor que cero
        if (cantidad < 0) {

            // Registra un mensaje de nivel WARN (advertencia).
            logger.warn("No se puede incrementar el salario" + salario);
        }
        // Aumenta el valor del salario
        this.salario += cantidad;
    }
    // Metodo toString que devuelve a cadena de texto un objeto, en este caso la
    // informacion del empleado

    @Override
    public String toString() {
        return "Empleado {" +
                "nombre = '" + nombre + '\'' +
                ", edad = " + edad +
                ", salario = " + salario +
                '}';

    }
}
