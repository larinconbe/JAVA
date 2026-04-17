package com.gestionusuarios.controller;

import com.gestionusuarios.model.Rol;
import com.gestionusuarios.model.Usuario;
import com.gestionusuarios.service.UsuarioService;
import com.gestionusuarios.view.ConsolaVista;

/**
 * Controlador principal del sistema.
 * Gestiona la interacción entre la vista y la lógica de negocio.
 */

// Clase que conecta la vista con el servicio

public class UsuarioController {
    // Capa logica
    private UsuarioService servicio;
    // Interfaz con el usuario
    private ConsolaVista vista;
    // El usuario que ha iniciado sesion
    private Usuario usuarioActual;

    // Metodo constructor
    // Crea el servicio, crea la vista, inicializa el usuario
    public UsuarioController() {
        servicio = new UsuarioService();
        vista = new ConsolaVista();
        inicializarAdmin();
    }

    // Crear un usuario admin pordefecto

    private void inicializarAdmin() {
        Usuario admin = new Usuario("101", "Administrador",
                "Admin", "123", Rol.ADMINISTRADOR);
        servicio.crearUsuario(admin, admin);
    }

    /**
     * Inicia el sistema mostrando el menú principal.
     */

    // Metodo iniciar -> Muestra el menu
    public void iniciar() {
        int opcion;

        do {
            // Muestra las opciones en pantalla
            vista.mostrarMenuPrincipal();
            // Leee la opcion que el usuario ingresa
            opcion = vista.leerEntero();
            // Se presentan las opciones mediante switch
            switch (opcion) {
                case 1 -> login();
                case 2 -> crearUsuario();
                case 3 -> actualizarUsuario();
                case 4 -> eliminarUsuario();
                case 5 -> verHistorial();
                case 0 -> vista.mostrarMensaje("Saliendo...");
                default -> vista.mostrarMensaje("Opción inválida");
            }
        } while (opcion != 0);
    }

    /**
     * Gestiona el proceso de inicio de sesión.
     */

    // Login -> Proceso de inicio de sesion

    private void login() {
        // Pide los datos del usuario
        String username = vista.leerTexto("Username: ");
        String password = vista.leerTexto("Password: ");
        // LLama el metodo login del servicio
        usuarioActual = servicio.login(username, password);
        // Valida el usuario actual y carga el nombre de usuario
        if (usuarioActual != null) {
            vista.mostrarMensaje("Inicio exitoso" + usuarioActual.getNombreCompleto());
            // En caso de que el usuario sea incorrecto
        } else {
            vista.mostrarMensaje("Credenciales incorrectas");
        }
    }

    // Crear usuario

    private void crearUsuario() {
        // Verifica la sesion
        if (usuarioActual == null) {
            vista.mostrarMensaje("Debe iniciar sesion");
            return;
        }
        // Solicita los datos del usuario
        String id = vista.leerTexto("ID: ");
        String nombre = vista.leerTexto("Nombre: ");
        String username = vista.leerTexto("Username: ");
        String password = vista.leerTexto("Password: ");
        // Operador ternario -> Usuario selecciona el rol del usuario nuevo
        int rolOpcion = vista.leerEntero("Rol (1=ADMIN, 2=ESTANDAR): ");
        Rol rol = (rolOpcion == 1) ? Rol.ADMINISTRADOR : Rol.ESTANDAR;
        // Se crea el usuario en memoria
        Usuario nuevo = new Usuario(id, nombre, username, password, rol);
        // Se llama al servicio para crear el usuario
        boolean creado = servicio.crearUsuario(usuarioActual, nuevo);
        // Operador ternario para mostrar si el usuario fue creado o si los permisos no
        // son validos
        vista.mostrarMensaje(creado ? "Usuario creado" : "No tiene permisos o datos inválidos");
    }

    // Actualizar usuario

    private void actualizarUsuario() {
        // Verifica la sesion
        if (usuarioActual == null) {
            vista.mostrarMensaje("Debe iniciar sesión");
            return;
        }
        // Solicita id del usuario a actualizar
        String id = vista.leerTexto("ID del usuario a actualizar: ");
        // Captura el nuevo nombre
        String nuevoNombre = vista.leerTexto("Nuevo nombre: ");
        // Llama el servicio actualizar el usuario
        boolean actualizado = servicio.actualizarUsuario(usuarioActual, id, nuevoNombre);
        // Operdor ternario que muestra si el usuario fue actualizado o si no son
        // validos los permisos
        vista.mostrarMensaje(actualizado ? "Actualizado" : "No tiene permisos");
    }

    // Eliminar usuario

    private void eliminarUsuario() {
        // Valida la sesion
        if (usuarioActual == null) {
            vista.mostrarMensaje("Debe iniciar sesión");
            return;
        }
        // Solicita el id del usuario a eliminar
        String id = vista.leerTexto("ID del usuario a eliminar: ");
        // Usa el servicio eliminarUsuario
        boolean eliminado = servicio.eliminarUsuario(usuarioActual, id);
        // Operador ternario que muestra si el si el usuario fue eliminado o si los
        // permisos no son validos
        vista.mostrarMensaje(eliminado ? "Eliminado" : "No tiene permisos");
    }

    // Ver historial

    private void verHistorial() {
        // Valida la sesion
        if (usuarioActual == null) {
            vista.mostrarMensaje("Debe iniciar sesión");
            return;
        }
        // Recorre las acciones registradas, retorna la cantidad de acciones,
        // accede a las acciones y las imprime.
        for (int i = 0; i < usuarioActual.getContadorAcciones(); i++) {
            System.out.println(usuarioActual.obtenerHistorial()[i]);
        }
    }
}
