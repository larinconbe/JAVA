package com.devsenior.gestorlibros.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devsenior.gestorlibros.model.Libro;

// Clase servicio con las funciones
@Service
// indica a Spring que esta clase es un componente de servicio
// que puede ser administrado por el contenedor de Spring
// Implementa los metodos de la interface LibroService
public class MemoriaLibroService implements LibroService {
    // Lista de libros de tipo array - almacena los libros
    private List<Libro> libros = new ArrayList<>();

    @Override
    // Metodo que retorna la lista de todos los libros
    public List<Libro> findAll() {
        return libros;
    }

    @Override
    // Metodo que retorna un libro por id o codigo unico
    // Se utiliza Stream para recorrer la lista y buscar un
    // libro cuyo ISBN coincida con el identificador recibido.
    public Libro findById(String id) {
        // for (Libro libro : libros) {
        // if (libro.getIsbn().equals(id)) {
        // return libro;
        // }
        // }
        // return null;
        return libros.stream()
                .filter(b -> b.getIsbn().equalsIgnoreCase(id))
                .peek(System.out::println)
                .findFirst()
                .orElse(null);
    }

    @Override
    // Metodo para crear un libro
    public Libro create(Libro info) {
        // Valida que no exista un libro ocn el mismo isbn que se intenta crear
        if (findById(info.getIsbn()) != null) {
            return null;
        }
        // Crea el libro - lo agrega a la lista
        libros.add(info);
        return info;
    }

    @Override
    // Metodo para modificar un libro por id
    public Libro update(String id, Libro info) {
        // Buscar el libro por id
        var libro = findById(id);
        // Si no es null actualiza los datos
        if (libro != null) {
            // libro.setIsbn(info.getIsbn());
            libro.setTitulo(info.getTitulo());
            libro.setAutor(info.getAutor());
        }
        // Retorna el libro
        return libro;
    }

    @Override
    // Se utiliza un Stream para conservar únicamente
    // los libros cuyo ISBN sea diferente al recibido.

    public void delete(String id) {
        // var libro = findById(id);
        // libros.remove(libro);
        libros = libros.stream()
                .filter(b -> !b.getIsbn().equalsIgnoreCase(id))
                .toList();

    }
}
