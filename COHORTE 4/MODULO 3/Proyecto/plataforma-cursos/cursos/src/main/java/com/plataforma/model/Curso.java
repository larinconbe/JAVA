package com.plataforma.model;

import java.util.ArrayList;
import java.util.List;

// Clase curso
public class Curso {
    // Atributos
    private String codigo;
    private String nombre;
    private int capacidad;
    // Lista de estudiantes
    private List<Estudiante> estudiantesInscritos;

    // Constructor
    public Curso(String codigo, String nombre, int capacidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estudiantesInscritos = new ArrayList<>();
    }

    // Get y set --> Obeter y modificar
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public List<Estudiante> getEstudiantesInscritos() {
        return estudiantesInscritos;
    }

    public void setestudiantesInscritos(List<Estudiante> estudiantesInscritos) {
        this.estudiantesInscritos = estudiantesInscritos;
    }

    // Valida si el curso aun tiene cupos
    public boolean estaLleno() {
        return estudiantesInscritos.size() >= capacidad;
    }

    // Agregar estudiantes
    public void agregarEstudiante(Estudiante estudiante) {
        // Valida si el curso no esta lleno
        if (!estaLleno()) {
            // Agrega estudiante
            estudiantesInscritos.add(estudiante);
        }

    }

    // Metodo toString para generar cadena de texto de los objetos de la clase
    @Override
    public String toString() {
        return "Curso [codigo=" + codigo + ", nombre=" + nombre +
                ", capacidad=" + capacidad +
                ", estudiantesInscritos="
                + estudiantesInscritos + "]";
    }

}
