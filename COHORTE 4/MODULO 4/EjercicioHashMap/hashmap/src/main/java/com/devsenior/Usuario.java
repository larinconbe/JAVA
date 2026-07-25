package com.devsenior;

// Clase usuario
public class Usuario {
    // Atributos
    private String nombre;
    private String password;

    // Constructor
    public Usuario(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    // Metodo para validar password --> Compara el password con el parametro
    // password
    public boolean validarPassword(String password) {
        return this.password.equals(password);
    }

    // Metodos get - set para acceder a los valores y modificar
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Metodo toString para formar cadenas de texto de los objetos
    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
