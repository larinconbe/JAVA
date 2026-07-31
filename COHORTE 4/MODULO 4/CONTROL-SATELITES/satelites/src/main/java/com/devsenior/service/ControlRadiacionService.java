package com.devsenior.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.devsenior.excepciones.SateliteNoEncontradoException;
import com.devsenior.model.Estado;
import com.devsenior.model.Satelite;

public class ControlRadiacionService {
    private Map<String, Satelite> satelites;

    // Constructor - Inicializa el Map
    public ControlRadiacionService() {
        satelites = new HashMap<>();
    }

    // Registrar un satelite

    public void registrarSatelite(Satelite satelite) {
        satelites.put(satelite.getId(), satelite);
    }

    // Consultar estado de satelite

    public Estado consultarEstado(String id) throws SateliteNoEncontradoException {
        Satelite satelite = satelites.get(id); // Busca el satelite
        if (satelite != null) {
            return satelite.getEstado(); // Retorna el estado si encuentra el satelite
        }
        throw new SateliteNoEncontradoException("Satelite no encontrado");
    }

    // Agregar nuevas mediciones para un satelite especifico

    public boolean registrarMedicion(String id, double medicion) throws SateliteNoEncontradoException {
        Satelite satelite = satelites.get(id); // Buscar en el map
        if (satelite != null) {
            satelite.agregarMedicion(medicion); // Si encuentra el satelite, usa el metodo agregarMedicion
            return true;
        }
        throw new SateliteNoEncontradoException("Satelite no encontrado");

    }
    // Consultar el historial de mediciones de los stelites

    public List<Double> consultarMedicionesDeSatelite(String id) throws SateliteNoEncontradoException {
        Satelite satelite = satelites.get(id); // Buscar en el map
        if (satelite != null) {
            return satelite.getMediciones();
        }
        throw new SateliteNoEncontradoException("Satelite no encontrado");

    }

    // Cambiar estado de un satelite

    public void cambiarEstado(String id, Estado nuevoEstado) throws SateliteNoEncontradoException {
        buscarSatelite(id).setEstado(nuevoEstado); // Usa el metodo de buscar el satelite por el id y actualiza el
                                                   // estado
    }

    // Metodo para buscar satelite
    private Satelite buscarSatelite(String id) throws SateliteNoEncontradoException {
        Satelite satelite = satelites.get(id); // Busca el satelite por id en el HASHMAP
        if (satelite != null) {
            return satelite; // Si es diferente de null retorna el satelite
        }
        // Si no encuentra el satelite lanza la excepcion
        throw new SateliteNoEncontradoException("Satélite no encontrado");
    }

}
