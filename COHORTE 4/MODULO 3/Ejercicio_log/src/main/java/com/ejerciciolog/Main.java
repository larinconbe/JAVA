package com.ejerciciolog;

import org.apache.logging.log4j.*;

public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

        logger.info("Iniciando la aplicacion");

        // Crear empleados y gerentes

        Empleado emp1 = new Empleado("Juan", 22, 1500000);
        Gerente gen1 = new Gerente("Cristian", 31, 1800000, "Compras");

        logger.info("Informacion del empleado " + emp1);
        logger.info("Informacion del gerente: " + gen1);

        emp1.aumentarSalario(500000);
        gen1.aumentarSalario(600000);

        logger.info("Despues de aumentar salario:");

        logger.info("Informacion del empleado " + emp1);
        logger.info("Informacion del gerente: " + gen1);

        Empleado emp2 = new Empleado("Carlos", 29, 1400000);

        logger.info("Informacion del nuevo empleado: " + emp2);
        emp2.aumentarSalario(1600000);

        logger.info("Nuevo salario del empleado 2: " + emp2);

        Empleado emp3 = new Empleado("Joaquin", 36, 2000000);

        logger.info("Informacion de los empleados " + emp1 + emp2 + emp3);

    }
}