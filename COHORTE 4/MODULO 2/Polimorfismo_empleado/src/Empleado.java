public class Empleado {
    private String nombreCompleto;
    private String idEmpleado;
    private double salarioMensual;
    private String departamento;

    // Constructor 1: con salarioMensual por defecto (0.0)
    public Empleado(String nombreCompleto, String idEmpleado, String departamento) {
        this.nombreCompleto = nombreCompleto;
        this.idEmpleado = idEmpleado;
        this.departamento = departamento;
        this.salarioMensual = 0.0; // valor por defecto
    }

    // Constructor 2: inicializa todos los atributos
    public Empleado(String nombreCompleto, String idEmpleado, double salarioMensual, String departamento) {
        this.nombreCompleto = nombreCompleto;
        this.idEmpleado = idEmpleado;
        this.salarioMensual = salarioMensual;
        this.departamento = departamento;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
    // Valida que el salario mensual no sea cero o negativo
    public void setSalarioMensual(double salarioMensual) {
        if (salarioMensual >= 0) {
            this.salarioMensual = salarioMensual;
        } else {
            System.out.println("El salario no es valido");
        }
    }

    // Método para mostrar toda la información del empleado usando getters
    public void mostrarInformacion() {
        System.out.println("Información del Empleado:");
        System.out.println("Nombre completo: " + getNombreCompleto());
        System.out.println("ID del empleado: " + getIdEmpleado());
        System.out.println("Departamento: " + getDepartamento());
        System.out.println("Salario mensual: $" + getSalarioMensual());
    }

    // Método para calcular y retornar el salario anual
    public double calcularSalarioAnual() {
        return getSalarioMensual() * 12;
    }

    

}
