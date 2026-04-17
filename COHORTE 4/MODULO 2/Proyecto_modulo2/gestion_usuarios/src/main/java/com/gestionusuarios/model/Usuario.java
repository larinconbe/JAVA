package com.gestionusuarios.model;

/**
 * Representa un usuario del sistema con información básica,
 * rol asignado y un historial de acciones realizadas.
 */

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

    // Metodo constructor para inicializar los atributos y crear objetos de la clase
    // Usuario
    // Cerar el arreglo de acciones
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
    // Retorna verdadero o falso
    // Recibe como parametro la contraseña ingresada y almacenada en el objeto
    // con equals compara los textos

    public boolean validarPassword(String password) {
        return this.password.equals(password);
    }

    /**
     * Actualiza el nombre del usuario.
     * 
     * @param nuevoNombre nuevo nombre completo
     */

    // Metodo para actualizar el nombre del usuario
    // Se modifica el valor de nombreCompleto por nuevoNombre
    // Registra la accion en el historial

    public void actualizarNombre(String nuevoNombre) {
        this.nombreCompleto = nuevoNombre;
        registrarAccion("Registro su nombre");
    }

    // Metodo para actualizar la contraseña
    // Valida la contraseña antes de actualizar
    // Modifica el valor de password por nueva y retorna true
    // actual es la contraseña que ingresa el usuario actualmente
    // si esta contraseña coincide con password la actualiza en la variable nueva
    // Registra la accion
    // Si la contraseña no es correcta retorna false

    public boolean actualizarPassword(String actual, String nueva) {
        if (this.password.equals(actual)) {
            this.password = nueva;
            registrarAccion("Actualizo su contraseña");
            return true;
        }
        return false;
    }

    /**
     * Representa una acción realizada por un usuario,
     * incluyendo descripción y marca de tiempo.
     */

    // Metodo para registrar una accion en el historial
    // Crea un objeto accion y lo guarda en el array
    // Aumenta el contador
    // Valida que hay espacio en el arreglo (se creo para 100 acciones)
    // Automaticamente guarda el tiempo

    public void registrarAccion(String descripcion) {
        if (contadorAcciones < MAX_ACCIONES) {
            historial[contadorAcciones++] = new Accion(descripcion);
        }
    }

    // Metodo para obtener el historial de acciones
    // Devuelve el arreglo de acciones del usuario

    public Accion[] obtenerHistorial() {
        return historial;
    }

    // Este metodo retorna el numero de acciones realizadas por el usuario
    // Se usa para recorrer el arreglo de acciones
    public int getContadorAcciones() {
        return contadorAcciones;
    }

    // Este metodo permite visualizar objetos creados de tipo usuario
    // Convierte el objeto en texto, se concatenan los valores del objeto

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
