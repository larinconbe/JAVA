package com.arreglos.service;

import com.arreglos.exceptions.AsientoInvalidoException;
import com.arreglos.exceptions.AsientoOcupadoException;
import com.arreglos.model.Asiento;
import com.arreglos.model.EstadoAsiento;

public class Teatro {
    private final int FILAS = 10;
    private final int COLUMNAS = 6;
    private Asiento[][] asientos;

    // Metodo Public teatro
    public Teatro() {
        asientos = new Asiento[FILAS][COLUMNAS];
        inicializarAsientos();
    }

    // Metodo para inicializar los asientos ---> Objetos de tipo asiento
    private void inicializarAsientos() {
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                asientos[i][j] = new Asiento();
            }
        }
    }

    // Metodo para obtener el estado de los asientos
    public EstadoAsiento[][] obtenerEstadoAsiento() {
        EstadoAsiento[][] estadoAsientos = new EstadoAsiento[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                estadoAsientos[i][j] = asientos[i][j].Getestado();
            }
        }
        return estadoAsientos;
    }

    // Metodo para reservar asiento --> Valida que el asiento se encuentre en el
    // rango
    // Actualiza el estado a reservado, de lo contrario muestra si el asiento ya
    // esta reservado
    public boolean reservarAsiento(int fila, int columna) throws AsientoInvalidoException, AsientoOcupadoException {
        if (fila < 0 || fila >= FILAS || columna < 0 || columna >= COLUMNAS) {
            throw new AsientoInvalidoException("Fila o columna fuera de rango");
        }
        if (asientos[fila][columna].isLibre()) {
            asientos[fila][columna].setEstado(EstadoAsiento.RESERVADO);
            return true;
        } else {
            throw new AsientoOcupadoException("El asiento ya esta reservado");
        }
    }

}
