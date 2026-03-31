public class Vehiculo {
    private String marca;
    private String modelo;
    private int anio;

    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void mostrarInformacion() {
        System.out.println("La marca es: " + marca + ", El modelo es: " + modelo + ", El año es: " + anio);
    }

    public void mover() {
        System.out.println("El vehiculo se esta moviendo");
    }

}
