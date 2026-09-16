package com.devsenior.gestorlibros.controller;

import java.util.List;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsenior.gestorlibros.model.Libro;
import com.devsenior.gestorlibros.services.LibroService;

// Clase controlador,  recibe las solicitudes HTTP realizadas por el cliente y las dirige 
// al servicio correspondiente.
@RestController
// Ruta principal de la API
@RequestMapping("/api/libros")
public class LibroController { // Servicio restfull
    // @Autowired
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    // Obtiene la lista de todos los libros
    @GetMapping // GET /api/libros
    public List<Libro> getAll() {
        return libroService.findAll();
    }

    // Obtiene libros por la variable isbn - Usa el metodo findById de la capa
    // service libroService
    @GetMapping("/{isbn}") // GET /api/libros/123456
    public Libro getByIsbn(@PathVariable String isbn) {
        return libroService.findById(isbn);
    }

    // Crea libros usando el metodo create de libroService, usa el parametro objeto
    // libro de la clase Libro
    @PostMapping // POST /api/libros -> body
    public Libro newLibro(@RequestBody Libro libro) {
        return libroService.create(libro);
    }

    // Modifica los datos de un libro en base al isbn, usa el isbn y el objeto libro
    // el cual va a actualizar
    @PutMapping("/{isbn}") // POST /api/libros/123456 -> body
    public Libro updateLibro(@PathVariable String isbn, @RequestBody Libro libro) {
        return libroService.update(isbn, libro);
    }

    // Elimina libros usanado la variable isbn
    @DeleteMapping("/{isbn}")
    public void deleteLibro(@PathVariable String isbn) {
        libroService.delete(isbn);
    }
}
