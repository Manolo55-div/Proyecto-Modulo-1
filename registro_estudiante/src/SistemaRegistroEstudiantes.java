import java.util.Scanner;

public class SistemaRegistroEstudiantes {

    // Variables de alcance de clase
    static String estudianteNombre = "N/A";
    static double nota1 = -1;
    static double nota2 = -1;
    static double nota3 = -1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    registrarEstudiante(scanner);
                    break;
                case 2:
                    mostrarInfoEstudiante();
                    break;
                case 3:
                    double promedio = calcularPromedioEstudiante();
                    if (!estudianteNombre.equals("N/A")) {
                        System.out.printf("El promedio de %s es: %.2f%n", estudianteNombre, promedio);
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del sistema. ¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
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

    // Método para registrar los datos del estudiante
    public static void registrarEstudiante(Scanner scanner) {
        System.out.print("Ingrese el nombre del estudiante: ");
        String nombreInput = scanner.nextLine();

        while (!validarNombre(nombreInput)) {
            System.out.print("Nombre no válido. Intente de nuevo: ");
            nombreInput = scanner.nextLine();
        }

        estudianteNombre = nombreInput;

        nota1 = pedirNota(scanner, "Ingrese la primera nota: ");
        nota2 = pedirNota(scanner, "Ingrese la segunda nota: ");
        nota3 = pedirNota(scanner, "Ingrese la tercera nota: ");

        System.out.println("Datos registrados con éxito.");
    }

    // Método para pedir y validar una nota
    public static double pedirNota(Scanner scanner, String mensaje) {
        double nota;
        do {
            System.out.print(mensaje);
            while (!scanner.hasNextDouble()) {
                System.out.print("Entrada inválida. Ingrese un número: ");
                scanner.next(); // Descartar entrada inválida
            }
            nota = scanner.nextDouble();
        } while (!validarNota(nota));
        return nota;
    }

    // Método para mostrar la información del estudiante
    public static void mostrarInfoEstudiante() {
        if (estudianteNombre.equals("N/A")) {
            System.out.println("No se ha registrado ningún estudiante aún.");
        } else {
            System.out.println("\n--- Información del Estudiante ---");
            System.out.println("Nombre: " + estudianteNombre);
            System.out.println("Nota 1: " + nota1);
            System.out.println("Nota 2: " + nota2);
            System.out.println("Nota 3: " + nota3);
        }
    }

    // Método para calcular el promedio
    public static double calcularPromedioEstudiante() {
        if (estudianteNombre.equals("N/A")) {
            System.out.println("No hay estudiante registrado.");
            return 0.0;
        }
        return (nota1 + nota2 + nota3) / 3;
    }

    // Método para validar una nota
    public static boolean validarNota(double nota) {
        if (nota >= 0 && nota <= 100) {
            return true;
        } else {
            System.out.println("La nota debe estar entre 0 y 100.");
            return false;
        }
    }

    // Método para validar el nombre
    public static boolean validarNombre(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }
}