package com.plataforma.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.*;

import com.plataforma.exception.CursoLlenoException;
import com.plataforma.exception.EstudianteNoEncontradoException;
import com.plataforma.model.Curso;
import com.plataforma.model.Estudiante;
import com.plataforma.model.Inscripcion;

// Clase servicio de inscripciones
public class InscripcionService {
    // Objeto lloger para usar las funciones de la clase Logger
    private static Logger logger = LogManager.getLogger(InscripcionService.class);
    // Lista de inscripciones
    private List<Inscripcion> inscripciones;

    // Constructor --> Inicializa la lista
    public InscripcionService() {
        this.inscripciones = new ArrayList<>();
    }

    // Metodo para inscribir el estudiante
    public void inscribirEstudiante(Curso curso, Estudiante estudiante) throws CursoLlenoException {
        // Valida que el curso este al limite --> Si esta al limite no permite ingresar
        // mas estudiantes
        if (curso.estaLleno()) {
            // Usa el nivel de error de la clase Logger, usa un parametro String para
            // mostrar un mensaje
            logger.error(
                    "El curso: " + curso.getCodigo() + " Esta lleno," + " el estudiante: " + estudiante.getNombre() +
                            " No se puede matricular");
            // Uso de la excepcion para un curso lleno
            throw new CursoLlenoException("El curso " + curso.getNombre() + " no tiene mas capacidad");

        }
        // De lo contrario, si el curso no esta lleno permite agregar el estudiante
        curso.agregarEstudiante(estudiante);
        Inscripcion inscripcion = new Inscripcion(estudiante, curso);
        inscripciones.add(inscripcion);
        logger.info("El estudiante fue agregado de manera exitosa");

    }

    // Metodo para buscar inscripciones por estudiante
    // El metodo debe devolver una lista de objetos inscripcion
    public List<Inscripcion> BuscarInscripcionesPorEstudiante(Estudiante estudiante)
            throws EstudianteNoEncontradoException {

        // Crear una lista para guardar las inscripciones del estudiante
        List<Inscripcion> inscripcionesEstudiante = new ArrayList<>();
        // Recorre la lista Inscripcion
        for (Inscripcion inscripcion : inscripciones) {

            // Si el estudiante de la inscripcion tiene el mismo id del estudiante buscado
            // entonces guarda la inscripcion en la lista de resultados
            if (inscripcion.getEstudiante().getId().equals(estudiante.getId())) {
                inscripcionesEstudiante.add(inscripcion);
            }
        }
        // Valida si la lista de inscripciones esta vacia
        // Si no hay inscripciones se registra un aviso en los logs
        if (inscripcionesEstudiante.isEmpty()) {
            // Usa el nivel warn de logger para generar el mensaje
            logger.warn("No se encontraron inscripciones para el estudiante con id {}", estudiante.getId());
            // Usa la excepcion de estudiante no encontrado
            throw new EstudianteNoEncontradoException("No se encontraron inscripciones para el estudiante con id: "
                    + estudiante.getId());
            // De lo contrario muestra las inscripciones encontradas para el estudiante
        } else {
            logger.info("Se econtraron {} inscripciones para el estudiante {}",
                    inscripcionesEstudiante.size(), estudiante.getId());
        }
        // Retorna la lista lista de inscripciones encontradas
        return inscripcionesEstudiante;
    }

    // Metodo para listar inscripciones

    public List<Inscripcion> listarInscripciones() {
        return inscripciones;
    }

}
