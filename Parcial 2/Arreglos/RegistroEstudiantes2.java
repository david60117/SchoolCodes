import java.util.Scanner;

public class RegistroEstudiantes2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuántos estudiantes desea registrar");
        int n = sc.nextInt();
        sc.nextLine();

        String[] nombres = new String[n];
        int[] edades = new int[n];
        double[] promedios = new double[n];

        System.out.println("=== REGISTRO DE ESTUDIANTES ===");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("\nEstudiante " + (i + 1) + ":");
            System.out.print("Nombre: ");
            nombres[i] = sc.nextLine();
            System.out.print("Edad: ");
            edades[i] = sc.nextInt();
            System.out.print("Promedio: ");
            promedios[i] = sc.nextDouble();
            sc.nextLine(); 
        }

        System.out.println("\n=== LISTA DE ESTUDIANTES ===");
        System.out.printf("%-20s %-10s %-10s\n", "Nombre", "Edad", "Promedio");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < nombres.length; i++) {
            System.out.printf("%-20s %-10d %-10.2f\n", nombres[i], edades[i], promedios[i]);
        }

        sc.close();
    }
}
