public class Motocicleta extends Vehiculo implements Arrancable {
    private int cilindrada;

    public Motocicleta(String marca, String modelo, int anio, int cilindrada) {
        super(marca, modelo, anio);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public void mover() {
        System.out.println("La motocicleta acelera.");
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Cilindrada: " + cilindrada + " cc");
    }

    public void arrancar() {
        System.out.println("Este tipo de vehiculo arranca con el embrague presionado, acelerando despacio");
    }
}
