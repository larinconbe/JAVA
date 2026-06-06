package com.ejerciciolog;

// Clase gerente que hereda los atributos y metodos de la clase empleado
public class Gerente extends Empleado {
    // Se agrega el atributo departamento
    private String departamento;

    // Constructor de la clase gerente para inicializar las variables
    public Gerente(String nombre, int edad, double salario, String departamento) {
        // Se utiliza la palabra super para inicializar los atributos de la clase
        // empleado en la clase gerente
        super(nombre, edad, salario);
        this.departamento = departamento;
    }

    // Método toString para mostrar como cadena de texto los datos del objeto
    @Override
    public String toString() {
        return "Gerente { " +
                "departamento = '" + departamento + '\'' +
                "} " + super.toString();
    }

}
