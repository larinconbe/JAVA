package com.gestionusuarios.model;

// Clase usuario, representa los usuarios del sistema
public class Usuario {
    // Atributos para la clase usuario
    private String id;
    private String nombreCompleto;
    private String userName;
    private String password;
    private Rol rol;
    // Atributo array o arreglo de acciones que van a formar
    // el listado de acciones
    private Accion[] historial;
    // Contador para identificar cuantas acciones se ha nrealizado
    private int contadorAcciones;
    // Numero de acciones que puede tener un usuario
    private static final int MAX_ACCIONES = 100;

    // Metodo constructor para inicializar los atributos 
    // Crea el historial vacio
    public Usuario(String id, String nombreCompleto, String userName, String password, Rol rol) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.userName = userName;
        this.password = password;
        this.rol = rol;
        this.historial = new Accion[MAX_ACCIONES];
        this.contadorAcciones = 0;

    }

    // Metodos get
    public String getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getUserName() {
        return userName;
    }

    public Rol getRol() {
        return rol;
    }

    // metodo para validar la contraseña

    public boolean validarPassword(String password) {
        return this.password.equals(password);
    }

    // Metodo para actualizar el nombre del usuario
    // Registra la accion

    public void actualizarNombre(String nuevoNombre) {
        this.nombreCompleto = nuevoNombre;
        registrarAccion("Registro su nombre");
    }

    // Metodo para actualizar la contraseña
    // Valida la contraseña antes de actualizar
    // Registra la accion
    public boolean actualizarPassword(String actual, String nueva) {
        if (this.password.equals(actual)) {
            this.password = nueva;
            registrarAccion("Actualizo su contraseña");
            return true;
        }
        return false;
    }

    // Metodo para registrar una accion en el historial
    // Crea una nueva accion y la guarda en el array

    public void registrarAccion(String descripcion) {
        if (contadorAcciones < MAX_ACCIONES) {
            historial[contadorAcciones++] = new Accion(descripcion);
        }
    }

    // Metodo para obtener el historial de acciones

    public Accion[] obtenerHistorial() {
        return historial;
    }

    public int getContadorAcciones() {
        return contadorAcciones;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", nombreCompleto='" + nombreCompleto + '\'' +
                ", username='" + userName + '\'' +
                ", rol=" + rol +
                '}';
    }
}
