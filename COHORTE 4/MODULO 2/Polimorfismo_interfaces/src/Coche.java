public class Coche extends Vehiculo implements Arrancable {
    private int numeroPuertas;

    public Coche(String marca, String modelo, int anio, int numeroPuertas) {
        super(marca, modelo, anio);
        this.numeroPuertas = numeroPuertas;
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    @Override
    public void mover() {
        System.out.println("El coche se mueve por la carretera.");
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Número de puertas: " + numeroPuertas);
    }

    public void arrancar() {
        System.out.println(
                "Este tipo de vehiculo arranca presionando el pedal del embrague, ubicando el cambio en \n 1, soltando lentamente el pedal y acelerando");

    }

}
