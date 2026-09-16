package com.devsenior.gestorlibros.services;

import java.util.List;

import com.devsenior.gestorlibros.model.Libro;

// Interface con los metodos a implementar desde el servicio
public interface LibroService {
    List<Libro> findAll();

    Libro findById(String id);

    Libro create(Libro info);

    Libro update(String id, Libro info);

    void delete(String id);
}
