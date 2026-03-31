public class FlotaApp {
    public static void main(String[] args) throws Exception {
        // se crean los objetos de las diferentes clases
        Coche miCoche = new Coche("Toyota", "Corolla", 2025, 4);
        Motocicleta miMoto = new Motocicleta("Yamaha", "M250", 2025, 200);
        Camion miCamion = new Camion("Volvo", "FG5200", 2020, 25000);
        // se usan los metodos a partir de los objetos creados
        miCoche.mover();
        miCoche.mostrarInformacion();

        miMoto.mover();
        miMoto.mostrarInformacion();

        miCamion.mover();
        miCamion.mostrarInformacion();

        // Crea variables usando el tipo de la superclase Vehiculo y asígnales los
        // objetos concretos

        Vehiculo vehiculo1 = miCoche;
        Vehiculo vehiculo2 = miMoto;
        Vehiculo vehiculo3 = miCamion;

        vehiculo1.mover();
        vehiculo1.mostrarInformacion();

        vehiculo2.mover();
        vehiculo2.mostrarInformacion();

        vehiculo3.mover();
        vehiculo3.mostrarInformacion();

        // Crea variables usando el tipo de la interfaz Arrancable y
        // asígnales los objetos que la implementan. Llama al método arrancar().

        Arrancable arrancable1 = miCoche;
        Arrancable arrancable2 = miMoto;

        arrancable1.arrancar();
        arrancable2.arrancar();

    }
}
