public class EmpresaApp {
    public static void main(String[] args) throws Exception {
        

        var empleado1 = new Empleado("Juan", "01", "Contabilidad");
        var empleado2= new Empleado("Gloria", "02", "Ventas");
        var empleado3 = new Empleado("Juana", "03", 413.3, "Logistica");
        var empleado4 = new Empleado ("Sandra", "04", 450, "Almacen");

        empleado1.mostrarInformacion();
        empleado2.mostrarInformacion();
        empleado3.mostrarInformacion();
        empleado4.mostrarInformacion();

        empleado1.setDepartamento("Seguridad de la informacion");
        empleado3.setSalarioMensual(550);

        empleado1.mostrarInformacion();
        empleado3.mostrarInformacion();

        var salarioanualempleado3 = empleado3.calcularSalarioAnual();
        System.out.println("El salario anual del empleado 3 es: " + salarioanualempleado3);

        //empleado4.nombreCompleto = "Nuevo nombre";


    }
}
