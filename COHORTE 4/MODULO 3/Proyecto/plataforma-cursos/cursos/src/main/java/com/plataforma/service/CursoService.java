package com.plataforma.service;

import java.util.ArrayList;
import java.util.List;

//import java.util.logging.LogManager;

import org.apache.logging.log4j.*;

import com.plataforma.exception.CursoNoEncontradoException;
import com.plataforma.model.Curso;

public class CursoService {
    private static Logger logger = LogManager.getLogger(CursoService.class);

    private List<Curso> cursos;

    public CursoService() {
        this.cursos = new ArrayList<>();
    }

    // Agregar un curso

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
        logger.info("Curso agregado: " + curso.getNombre());
    }

    // Listar todos los cursos

    public List<Curso> listarCursos() {
        return cursos;
    }

    // Burcar curso por codigo

    public Curso buscarCursoPorCodigo(String codigo) throws CursoNoEncontradoException {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo))
                return curso;
        }

        logger.info("Curso no encontrado con el codigo: " + codigo);
        throw new CursoNoEncontradoException("Curso no encontrado: " + codigo);

    }

}
