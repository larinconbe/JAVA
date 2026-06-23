package com.plataforma.cursos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.plataforma.exception.CursoNoEncontradoException;
import com.plataforma.model.Curso;
import com.plataforma.service.CursoService;

// Clase para pruebas de CursoService
public class CursoServiceTest {
    // Metodo para probar agregar un curso
    @Test
    public void agrgarCursoCorrectamente() {
        // Instancia de CursoService
        CursoService cursoService = new CursoService();
        // Verificar la cantidad inicial en cero
        int cantidadInicial = cursoService.listarCursos().size();
        // Crear un nuevo curso
        Curso curso = new Curso(
                "C001",
                "Java Básico",
                2);
        // Agregar un curso con el metodo agregarCurso --> Parametro curso
        cursoService.agregarCurso(curso);
        // Comparar con assertEquals valor inicial con los cursos agregados a la lista
        assertEquals(
                cantidadInicial + 1,
                cursoService.listarCursos().size());

    }

    // Metodo para probar la busqueda de un curso existente por el codigo
    @Test
    public void buscarCursoCorrectamente() throws CursoNoEncontradoException {

        // Crear servicio
        CursoService cursoService = new CursoService();

        // Crear y agregar curso
        Curso curso = new Curso("C001", "Java Básico", 2);
        cursoService.agregarCurso(curso);

        // Buscar curso
        Curso cursoEncontrado = cursoService.buscarCursoPorCodigo("C001");

        // Verificar que no sea null
        assertNotNull(cursoEncontrado);

    }

    // Metodo para buscar un curso que no esxiste
    @Test
    public void buscarCursoInexistente() {
        // Crear la instancia cursoService
        CursoService cursoService = new CursoService();
        // Validar la excepcion al buscar un curso no creado
        assertThrows(
                CursoNoEncontradoException.class,
                () -> cursoService.buscarCursoPorCodigo("C999"));
    }

    @Test
    public void listarCursos() {
        // Crerar la instancia cursoService

        CursoService cursoService = new CursoService();

        int cantidadEsperada = 2;
        // Crear varios cursos
        Curso curso = new Curso("C001", "Java Básico", 2);
        Curso curso2 = new Curso("C002", "Java Medio", 3);
        // Agregar los cursos
        cursoService.agregarCurso(curso);
        cursoService.agregarCurso(curso2);
        // Listar los cursos
        cursoService.listarCursos();
        // Comprobar el tamaño de la lista de los cursos
        cursoService.listarCursos().size();
        // Comparar la cantidad con el tamaño de la lista
        assertEquals(

                cantidadEsperada,
                cursoService.listarCursos().size());

    }

}
