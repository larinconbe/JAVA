package com.plataforma;

import org.apache.logging.log4j.*;

import com.plataforma.exception.CursoLlenoException;
import com.plataforma.model.Curso;
import com.plataforma.model.Estudiante;
import com.plataforma.service.CursoService;
import com.plataforma.service.InscripcionService;

public class Main {
    // Objeto loger para usar las funciones de la clase Logger
    private static Logger logger = LogManager.getLogger(InscripcionService.class);

    public static void main(String[] args) {

        CursoService cursoService = new CursoService();
        InscripcionService inscripcionService = new InscripcionService();

        // Crear cursos
        Curso javaBasico = new Curso("C001", "Java Basico", 2);
        Curso pythonIntermedio = new Curso("C002", "Python Intermedio", 4);

        //cursoService.buscarCursoPorCodigo("C001");

        cursoService.agregarCurso(javaBasico);
        cursoService.agregarCurso(pythonIntermedio);

        // crear estudiantes
        Estudiante estudiante1 = new Estudiante("E001", "Ana Pérez", "ana@gmail.com");
        Estudiante estudiante2 = new Estudiante("E002", "Luis Gómez", "luis@devsenior.com");
        Estudiante estudiante3 = new Estudiante("E003", "Marta Ruiz", "marta@dev.com");

        // inscripciones con manejo de excepciones
        try {
            inscripcionService.inscribirEstudiante(javaBasico, estudiante1);
            inscripcionService.inscribirEstudiante(javaBasico, estudiante2);
            inscripcionService.inscribirEstudiante(pythonIntermedio, estudiante3);
            inscripcionService.inscribirEstudiante(javaBasico, estudiante3); // Debería fallar por cupo lleno
        } catch (CursoLlenoException e) {
            logger.error("Error de inscripcion: " + e.getMessage());
        }

        // Mostrar cursos y estudiantes inscritos
        System.out.println("--- Cursos Disponibles ---");
        for (Curso curso : cursoService.listarCursos()) {
            System.out.println(curso);
            System.out.println("Estudiantes Inscritos:");
            for (Estudiante est : curso.getEstudiantesInscritos()) {
                System.out.println(" - " + est);
            }
        }

        // Buscar curso por codigo

        //cursoService.buscarCursoPorCodigo("C001");
    }

}
