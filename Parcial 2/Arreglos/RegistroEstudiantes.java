import java.util.Scanner;

public class RegistroEstudiantes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] estudiantes = new String[5];

        System.out.println("=== REGISTRO DE ESTUDIANTES ===");

        for (int i = 0; i < estudiantes.length; i++) {
            System.out.print("Ingresa el nombre del estudiante " + (i + 1) + ": ");
            estudiantes[i] = sc.nextLine().trim();
        }

        System.out.println("\nLista de estudiantes:");
        for (String nombre : estudiantes) {
            int longitud = nombre.length();
            if (nombre.equals(nombre.toLowerCase())) {
                System.out.println("- " + nombre + " (" + longitud + " caracteres) → " + nombre.toUpperCase());
            } else if (nombre.equals(nombre.toUpperCase())) {
                System.out.println("- " + nombre + " (" + longitud + " caracteres) → " + nombre.toLowerCase());
            } 
        }

        System.out.print("\nIngresa el nombre a buscar: ");
        String buscado = sc.nextLine().trim();
        boolean encontrado = false;

        for (String nombre : estudiantes) {
            if (nombre.equalsIgnoreCase(buscado)) {
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            System.out.println("El estudiante " + buscado + " está en la lista.");
        } else {
            System.out.println("El estudiante " + buscado + " no fue encontrado.");
        }

        sc.close();
    }
}
