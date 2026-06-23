package com.plataforma.cursos;

import org.junit.jupiter.api.*;

import com.plataforma.exception.CursoLlenoException;
import com.plataforma.exception.EstudianteNoEncontradoException;
import com.plataforma.model.Curso;
import com.plataforma.model.Estudiante;
import com.plataforma.model.Inscripcion;
import com.plataforma.service.CursoService;
import com.plataforma.service.InscripcionService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

// Clase para realizar las pruebas de Inscripcion Service
public class InscripcionServiceTest {
    // Metodo para probar la inscripcion de un estudiante en un curso disponible
    @Test
    public void inscribirEstudiante() throws CursoLlenoException {
        // Crear la instancia de CursoService
        CursoService cursoService = new CursoService();
        // Crear un curso
        Curso curso = new Curso("C001", "Java", 5);
        // Agregar el curso a la lista
        cursoService.agregarCurso(curso);

        // Instancia para crear inscripciones
        InscripcionService inscripcionService = new InscripcionService();

        // Obtener la cantidad inicial de inscripciones
        int cantidadInicialInscripciones = inscripcionService.listarInscripciones().size();
        // Se crea un estudiante de la clase Estudiante
        Estudiante est = new Estudiante("E001", "Juan Romero", "jr01@gmail.com");
        // Se realiza la inscripcion del estudiante en el curso creado
        inscripcionService.inscribirEstudiante(curso, est);
        // Verifica que la cantidad de inscripciones aumentó en una unidad
        assertEquals(

                cantidadInicialInscripciones + 1,
                inscripcionService.listarInscripciones().size());

    }

    // Metodo para probar un curso lleno --> se define una capacidad y se intenta
    // superarla
    // No deberia permitir mas estudiantes a los definidos en la capacidad
    @Test
    public void pruebaCursoLleno() throws CursoLlenoException {
        // Se usa CursoService para crear cursos
        CursoService cursoService = new CursoService();
        // Crear un curso con capacidad limitada de 2
        Curso curso = new Curso("C001", "Java", 2);
        // Agregar el curso a la lista
        cursoService.agregarCurso(curso);
        // Instancia para crear inscripciones
        InscripcionService inscripcionService = new InscripcionService();
        // Se crean 3 estudiantes
        Estudiante est1 = new Estudiante("E001", "Juan Romero", "jr01@gmail.com");
        Estudiante est2 = new Estudiante("E002", "Guillermo Buitrago", "gb01@gmail.com");
        Estudiante est3 = new Estudiante("E003", "Gloria Valencia", "gv01@gmail.com");
        // Se realiza la inscripcion del estudiante en el curso creado
        inscripcionService.inscribirEstudiante(curso, est1);
        inscripcionService.inscribirEstudiante(curso, est2);
        // inscripcionService.inscribirEstudiante(curso, est3);

        // Validar la excepcion de curso lleno
        assertThrows(
                CursoLlenoException.class,
                () -> inscripcionService.inscribirEstudiante(curso, est3));

    }

    // Metodo para probar la busqueda de inscripciones por estudiante
    @Test
    // Se usan las excepciones para curso lleno y estudiante no encontrado
    public void buscarInscripcionesPorEstudianteConInscripciones()
            throws CursoLlenoException, EstudianteNoEncontradoException {
        // Crear un curso
        Curso curso = new Curso("C001", "Python", 3);
        // Usar el servicio de inscripciones
        InscripcionService inscripcionService = new InscripcionService();
        // Crear un estudiante
        Estudiante est1 = new Estudiante("E001", "Simon Bolivar", "sb01@gmail.com");
        // Inscribir un estudiante
        inscripcionService.inscribirEstudiante(curso, est1);
        // Devolver una lista con una inscripcion
        List<Inscripcion> resultado = inscripcionService.BuscarInscripcionesPorEstudiante(est1);
        // Validar que la lista no este vacia
        assertFalse(resultado.isEmpty());

    }

    // Metodo para buscar estudiante sin inscripciones
    @Test
    public void buscarEstudianteSinInscripciones() {
        // Crear un estudiante
        Estudiante est1 = new Estudiante("E001", "Juan Perdomo", "jp01@gmail.com");
        // Crear el servicio de inscripciones
        InscripcionService inscripcionService = new InscripcionService();
        // Verifica si se lanza una excepcion EstudianteNoEncontradoException
        assertThrows(
                EstudianteNoEncontradoException.class,
                () -> inscripcionService.BuscarInscripcionesPorEstudiante(est1));

    }

    // Metodo para probar la lista de las inscripciones

    @Test
    public void listarTodasLasInscripciones() throws CursoLlenoException {
        // Crear un curso
        Curso curso = new Curso("C001", "PHP", 5);
        // Crear 5 estdudiantes
        Estudiante est1 = new Estudiante("E001", "Juana", "juana@gmail.com");
        Estudiante est2 = new Estudiante("E002", "Gregoria", "gregoria@gmail.com");
        Estudiante est3 = new Estudiante("E003", "Victoria", "victoria@gmail.com");
        Estudiante est4 = new Estudiante("E004", "Manuella", "manuella@gmail.com");
        Estudiante est5 = new Estudiante("E005", "Ximena", "ximena@gmail.com");
        // Crear el servicio de inscripciones
        InscripcionService inscripcionService = new InscripcionService();
        // Inscribir los 5 estudiantes
        inscripcionService.inscribirEstudiante(curso, est1);
        inscripcionService.inscribirEstudiante(curso, est2);
        inscripcionService.inscribirEstudiante(curso, est3);
        inscripcionService.inscribirEstudiante(curso, est4);
        inscripcionService.inscribirEstudiante(curso, est5);
        // Definir una cantidad de inscripciones
        int cantidadEsperadaInscripciones = 5;
        // Verificar que la cantidad de inscripciones registradas
        // coincide con la cantidad esperada
        assertEquals(

                cantidadEsperadaInscripciones,
                inscripcionService.listarInscripciones().size());

    }

}
