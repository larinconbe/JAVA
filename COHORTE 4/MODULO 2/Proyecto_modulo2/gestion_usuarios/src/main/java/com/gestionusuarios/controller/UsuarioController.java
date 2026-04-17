package com.gestionusuarios.controller;

import com.gestionusuarios.model.Rol;
import com.gestionusuarios.model.Usuario;
import com.gestionusuarios.service.UsuarioService;
import com.gestionusuarios.view.ConsolaVista;

// Clase que conecta la vista con el servicio

public class UsuarioController {

    private UsuarioService servicio;
    private ConsolaVista vista;

    private Usuario usuarioActual;

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

    public void iniciar() {
        int opcion;

        do {
            vista.mostrarMenuPrincipal();
            opcion = vista.leerEntero();

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

    // Login

    private void login(){
        String username = vista.leerTexto("Username: ");
        String password = vista.leerTexto("Password: ");

        usuarioActual = servicio.login(username, password);

        if (usuarioActual != null){
            vista.mostrarMensaje("Inicio exitoso" + usuarioActual.getNombreCompleto());

        } else {
            vista.mostrarMensaje("Credenciales incorrectas");
        }
    }

    // Crear usuario

    private void crearUsuario() {

        if (usuarioActual == null) {
            vista.mostrarMensaje("Debe iniciar sesion");
            return;
        }

        String id = vista.leerTexto("ID: ");
        String nombre = vista.leerTexto("Nombre: ");
        String username = vista.leerTexto("Username: ");
        String password = vista.leerTexto("Password: ");

        int rolOpcion = vista.leerEntero("Rol (1=ADMIN, 2=ESTANDAR): ");
        Rol rol = (rolOpcion == 1) ? Rol.ADMINISTRADOR : Rol.ESTANDAR;

        Usuario nuevo = new Usuario(id, nombre, username, password, rol);

        boolean creado = servicio.crearUsuario(usuarioActual, nuevo);

        vista.mostrarMensaje(creado ? "Usuario creado" : "No tiene permisos o datos inválidos");
    }

    // Actualizar usuario

    private void actualizarUsuario() {

        if (usuarioActual == null) {
            vista.mostrarMensaje("Debe iniciar sesión");
            return;
        }

        String id = vista.leerTexto("ID del usuario a actualizar: ");
        String nuevoNombre = vista.leerTexto("Nuevo nombre: ");

        boolean actualizado = servicio.actualizarUsuario(usuarioActual, id, nuevoNombre);

        vista.mostrarMensaje(actualizado ? "Actualizado" : "No tiene permisos");
    }

    // Eliminar usuario

    private void eliminarUsuario() {

        if (usuarioActual == null) {
            vista.mostrarMensaje("Debe iniciar sesión");
            return;
        }

        String id = vista.leerTexto("ID del usuario a eliminar: ");

        boolean eliminado = servicio.eliminarUsuario(usuarioActual, id);

        vista.mostrarMensaje(eliminado ? "Eliminado" : "No tiene permisos");
    }

    // Ver historial

    private void verHistorial() {

        if (usuarioActual == null) {
            vista.mostrarMensaje("Debe iniciar sesión");
            return;
        }

        for (int i = 0; i < usuarioActual.getContadorAcciones(); i++) {
            System.out.println(usuarioActual.obtenerHistorial()[i]);
        }
    }
}
