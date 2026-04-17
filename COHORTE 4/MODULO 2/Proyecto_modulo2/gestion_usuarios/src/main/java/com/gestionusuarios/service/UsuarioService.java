package com.gestionusuarios.service;

import com.gestionusuarios.model.Usuario;
import com.gestionusuarios.model.Rol;

// Clase que gestiona los usuarios del sistema
// Gestiona los permisos segun los roles

public class UsuarioService {
    private Usuario[] usuarios;
    private int contadorUsuarios;

    private static int MAX_USUARIOS = 50;

    public UsuarioService() {
        usuarios = new Usuario[MAX_USUARIOS];
        contadorUsuarios = 0;
    }

    // Metodo para crear usuarios

    public boolean crearUsuario(Usuario solicitante, Usuario nuevo){
        if(solicitante.getRol() != Rol.ADMINISTRADOR){
            return false;
        }
        if (contadorUsuarios >= MAX_USUARIOS){
            return false;
        }
        if (buscarPorId(nuevo.getId()) != null || buscarPorUserName(nuevo.getUserName()) != null){
            return false;
        }
        usuarios[contadorUsuarios ++ ] = nuevo;
        solicitante.registrarAccion("Creo un usuario" +nuevo.getUserName());
        return true;

    }

    // Metodo para buscar usuario por nombre de usuario

    public Usuario buscarPorUserName(String username) {
        for (int i = 0; i < contadorUsuarios; i++) {
            if (usuarios[i].getUserName().equals(username)) {
                return usuarios[i];
            }
        }
        return null;
    }

    // Metodo para buscar usuario por ID

    public Usuario buscarPorId(String id) {
        for (int i = 0; i < contadorUsuarios; i++) {
            if (usuarios[i].getId().equals(id)) {
                return usuarios[i];
            }
        }
        return null;
    }

    // Metodo para actualizar usuario

    public boolean actualizarUsuario(Usuario solicitante, String id, String nuevoNombre) {
        Usuario usuario = buscarPorId(id);
        if (usuario == null)
            return false;

        if (solicitante.getRol() == Rol.ADMINISTRADOR ||
                solicitante.getId().equals(id)) {
            usuario.actualizarNombre(nuevoNombre);
            solicitante.registrarAccion("Actualizo usuario" + usuario.getUserName());
            return true;
        }

        return false;
    }

    // Metodo para eliminar usuario

    public boolean eliminarUsuario(Usuario solicitante, String id) {
        if (solicitante.getRol() != Rol.ADMINISTRADOR) {
            return false;
        }
        for (int i = 0; i < contadorUsuarios; i++) {
            if (usuarios[i].getId().equals(id)) {
                solicitante.registrarAccion("Elimino usuario" + usuarios[i].getUserName());

                // Mover elementos

                for (int j = 0; j < contadorUsuarios - 1; j++) {
                    usuarios[j] = usuarios[j + 1];

                }

                usuarios[--contadorUsuarios] = null;
                return true;
            }

        }

        return false;
    }

    // Metodo login

    public Usuario login(String username, String password) {

        Usuario usuario = buscarPorUserName(username);

        if (usuario != null && usuario.validarPassword(password)) {
            usuario.registrarAccion("Inicio sesion");
            return usuario;
        }

        return null;
    }
}