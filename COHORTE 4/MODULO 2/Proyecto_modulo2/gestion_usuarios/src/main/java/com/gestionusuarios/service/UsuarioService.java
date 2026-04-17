package com.gestionusuarios.service;

import com.gestionusuarios.model.Usuario;
import com.gestionusuarios.model.Rol;

/**
 * Crea un nuevo usuario en el sistema si el solicitante tiene permisos.
 *
 * @param solicitante Usuario que realiza la acción
 * @param nuevo       Usuario a crear
 * @return true si se crea correctamente, false en caso contrario
 */

// Clase que gestiona los usuarios del sistema
// Gestiona los permisos segun los roles

// Atributo usuario -> Lista de usuarios de tipo array de tamaño 50
// Se crea el contador de los usuarios

public class UsuarioService {
    private Usuario[] usuarios;
    private int contadorUsuarios;

    private static int MAX_USUARIOS = 50;

    // Metodo constructor -> Crea el array de usuarios e inicializa el contador

    public UsuarioService() {
        usuarios = new Usuario[MAX_USUARIOS];
        contadorUsuarios = 0;
    }

    // Metodo para crear usuarios, se implementan los parametros solicitante y nuevo
    // Si solicitante (usuario que intenta crear el usuario) tiene rol diferente a
    // administrador retorna false
    // Valida cantidad de usuarios -> Si contadorUsuario es mayor o igual a 50
    // retorna false
    // Valida que el id y el username ingresados no esten duplicados, si ya existen
    // retorna false
    // se utiliza el or para que con cualquiera de las 2 condiciones retorne false y
    // no permita crear el usuario
    // Valida que no ingrese id o username vacios o null
    // Guarda el usuario en el array despues de las validaciones, incrementa el
    // contador
    // Regista la accion en el array de historial, almacena la descripcion con el
    // userName
    // Retorna verdadero al almacenar un usuario

    public boolean crearUsuario(Usuario solicitante, Usuario nuevo) {
        if (solicitante.getRol() != Rol.ADMINISTRADOR) {
            return false;
        }
        if (contadorUsuarios >= MAX_USUARIOS) {
            return false;
        }
        if (buscarPorId(nuevo.getId()) != null || buscarPorUserName(nuevo.getUserName()) != null) {
            return false;
        }
        if (nuevo.getId() == null || nuevo.getId().isEmpty() ||
                nuevo.getUserName() == null || nuevo.getUserName().isEmpty()) {
            return false;
        }

        usuarios[contadorUsuarios++] = nuevo;
        solicitante.registrarAccion("Creo un usuario" + nuevo.getUserName());
        return true;

    }

    // Metodo para buscar usuario por nombre de usuario, si encuentra usuario lo
    // retorna,
    // de lo contrario retorna null
    // Usa el parametro username String

    public Usuario buscarPorUserName(String username) {
        // Recorre todos los usuarios guardados
        for (int i = 0; i < contadorUsuarios; i++) {
            // Compara el userName guardado con el que se busca
            if (usuarios[i].getUserName().equals(username)) {
                // Retorna el usuario encontrado
                return usuarios[i];
            }
        }
        // Si no encuentra el usuario retorna null
        return null;
    }

    // Metodo para buscar usuario por ID, si encuentra usuario lo retorna,
    // de lo contrario retorna null
    // Usa el parametro id String
    // Este metodo se usa en el metodo crear usuario para buscar que el id
    // no exista y poderlo crear

    public Usuario buscarPorId(String id) {
        for (int i = 0; i < contadorUsuarios; i++) {
            if (usuarios[i].getId().equals(id)) {
                return usuarios[i];
            }
        }
        // Si no encuentra el id retorna null
        return null;
    }

    // Metodo para actualizar usuario
    // Parametros solicitante, id, nuevoNombre de tipo String
    // Solicitante -> quien intenta realizar la accion
    // id -> Usuario que se pretende modificar
    // nuevoNombre -> Nuevo nombre que se va a asignar

    public boolean actualizarUsuario(Usuario solicitante, String id, String nuevoNombre) {

        // Busca usuario por id en el sistema
        // Si no existe no se puede actualizar y retorna false
        Usuario usuario = buscarPorId(id);
        if (usuario == null)
            return false;
        // Validacion de permisos -> Si el solicitante es administrador
        // compara el id con el id del parametro
        if (solicitante.getRol() == Rol.ADMINISTRADOR ||
                solicitante.getId().equals(id)) {
            // Usa el metodo actualizar nombre y cambia el nombre
            usuario.actualizarNombre(nuevoNombre);
            // Registra la accion con la descripcion y el userName
            solicitante.registrarAccion("Actualizo usuario" + usuario.getUserName());
            // Retorna true si el proceso se realiza de manera correcta
            return true;
        }
        // Retorna false si el usuario no es de rol administrador
        return false;
    }

    // Metodo para eliminar usuario
    // Parametros solicitante, id

    public boolean eliminarUsuario(Usuario solicitante, String id) {
        // Valida el rol del solicitante, sino es administrador retorna false
        if (solicitante.getRol() != Rol.ADMINISTRADOR) {
            return false;
        }
        // Busca el usuario -> Recorre los usuarios existentes
        for (int i = 0; i < contadorUsuarios; i++) {
            // Compara el id de usuario a buscar con el id de los usuarios
            if (usuarios[i].getId().equals(id)) {

                // Registra la ccion en el historial
                solicitante.registrarAccion("Elimino usuario" + usuarios[i].getUserName());

                // Mover elementos
                for (int j = i; j < contadorUsuarios - 1; j++) {
                    usuarios[j] = usuarios[j + 1];

                }
                // Reduce el contador
                usuarios[--contadorUsuarios] = null;

                // Retorna true
                return true;
            }

        }
        // Si el usuario no es de rol administrador retorna false
        return false;
    }

    // Metodo login -> Parametros username y password de tipo String

    public Usuario login(String username, String password) {

        // Busca el usuario por username, usa el metodo buscarPorUserName

        Usuario usuario = buscarPorUserName(username);
        // Verifica que el usuario existe y la contraseña sea correcta

        if (usuario != null && usuario.validarPassword(password)) {
            // Registra la accion
            usuario.registrarAccion("Inicio sesion");
            return usuario;
        }
        // Si los datos no son correctos retorna null -> Login incorrecto

        return null;
    }
}