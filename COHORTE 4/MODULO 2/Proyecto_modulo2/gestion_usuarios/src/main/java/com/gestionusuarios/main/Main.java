package com.gestionusuarios.main;

import com.gestionusuarios.controller.UsuarioController;

public class Main {
    public static void main(String[] args) {
        UsuarioController controller = new UsuarioController();
        controller.iniciar();
    }
}