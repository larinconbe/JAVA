package com.devsenior.gestorlibros.model;

// Clase libro con los atributos
public class Libro {
    private String isbn;
    private String titulo;
    private String autor;

    // Constructor vacio
    public Libro() {

    }

    // Constructor que inicializa los atributos para crear objetos de la clase libro
    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
    }

    // Getters - Setters para acceso a los atributos desde otras clase
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

}
