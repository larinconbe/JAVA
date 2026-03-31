import java.util.Scanner;

public class Estudiante {
    // Variables de clase (alcance global dentro de la clase)
    static String estudianteActualNombre = "N/A";
    static double nota1 = 0;
    static double nota2 = 0;
    static double nota3 = 0;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = leerEntero(scanner);

            switch (opcion) {
                case 1:
                    registrarEstudiante(scanner);
                    break;
                case 2:
                    mostrarInfoEstudiante();
                    break;
                case 3:
                    double promedio = calcularPromedioEstudiante();
                    if (!estudianteActualNombre.equals("N/A")) {
                        System.out.printf("Promedio: %.2f%n", promedio);
                    } else {
                        System.out.println("No se ha registrado ningún estudiante.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    // Método para mostrar el menú
    public static void mostrarMenu() {
        System.out.println("\n--- Sistema de Registro de Estudiantes ---");
        System.out.println("1. Registrar datos de un estudiante");
        System.out.println("2. Mostrar datos del estudiante actual");
        System.out.println("3. Calcular promedio de notas del estudiante actual");
        System.out.println("0. Salir");
        System.out.print("Ingrese su opción: ");
    }

    // Método para registrar datos del estudiante
    public static void registrarEstudiante(Scanner scanner) {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombre = scanner.nextLine();
        while (!validarNombre(nombre)) {
            System.out.println("Nombre inválido. Intente nuevamente.");
            System.out.print("Ingrese el nombre del estudiante: ");
            nombre = scanner.nextLine();
        }
        estudianteActualNombre = nombre;

        nota1 = leerNotaValida(scanner, "Ingrese la primera nota: ");
        nota2 = leerNotaValida(scanner, "Ingrese la segunda nota: ");
        nota3 = leerNotaValida(scanner, "Ingrese la tercera nota: ");

        System.out.println("Estudiante registrado con éxito.");
    }

    // Método para mostrar información del estudiante actual
    public static void mostrarInfoEstudiante() {
        if (estudianteActualNombre.equals("N/A")) {
            System.out.println("No se ha registrado ningún estudiante.");
        } else {
            System.out.println("\n--- Información del Estudiante ---");
            System.out.println("Nombre: " + estudianteActualNombre);
            System.out.println("Nota 1: " + nota1);
            System.out.println("Nota 2: " + nota2);
            System.out.println("Nota 3: " + nota3);
        }
    }

    // Método para calcular el promedio
    public static double calcularPromedioEstudiante() {
        if (estudianteActualNombre.equals("N/A")) {
            return 0;
        }
        return (nota1 + nota2 + nota3) / 3.0;
    }

    // Método para validar una nota individual
    public static boolean validarNota(double nota) {
        return nota >= 0 && nota <= 10;
    }

    // Método para validar el nombre
    public static boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    // Método auxiliar para leer una nota válida
    public static double leerNotaValida(Scanner scanner, String mensaje) {
        double nota;
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextDouble()) {
                nota = scanner.nextDouble();
                if (validarNota(nota)) {
                    scanner.nextLine(); // Limpiar buffer
                    return nota;
                } else {
                    System.out.println("Nota inválida. Debe estar entre 0 y 10.");
                }
            } else {
                System.out.println("Entrada no válida. Ingrese un número.");
                scanner.next(); // Limpiar entrada inválida
            }
        }
    }

    // Método auxiliar para leer opción entera del menú
    public static int leerEntero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Entrada no válida. Ingrese un número entero.");
            scanner.next(); // Limpiar entrada inválida
            System.out.print("Ingrese su opción: ");
        }
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        return numero;
    }
}
