public class Polimorfismo {
    public static void main(String[] args) throws Exception {
        
        Figura miFigura1 = new Figura();
        Figura miFigura2 = new Circulo();
        Figura miFigura3 = new Cuadrado();

        miFigura1.dibujar();
        miFigura2.dibujar();
        miFigura3.dibujar();
    }

}
