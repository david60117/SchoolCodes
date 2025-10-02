import java.util.Scanner;

public class EstadisticasCalificaciones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántas calificaciones deseas ingresar? ");
        int n = sc.nextInt();

        double[] calificaciones = new double[n];
        double suma = 0;
        double max, min;

        for (int i = 0; i < n; i++) {
            System.out.print("Ingresa la calificación " + (i + 1) + ": ");
            calificaciones[i] = sc.nextDouble();
            suma += calificaciones[i];
        }

        max = calificaciones[0];
        min = calificaciones[0];

        int reprobatorias = 0;
        String listaReprobatorias = "";
        for (int i = 0; i < n; i++) {
            if (calificaciones[i] > max) {
                max = calificaciones[i];
            }
            if (calificaciones[i] < min) {
                min = calificaciones[i];
            }
            if (calificaciones[i] < 7) {
                reprobatorias++;
                listaReprobatorias += calificaciones[i] + " ";
            }
        }

        double promedio = suma / n;

        System.out.println("CALIFICACIONES: ");
        for (double c : calificaciones) {
            System.out.print(c + " ");
        }
        System.out.println("\nPromedio: " + promedio);
        System.out.println("Calificación máxima: " + max);
        System.out.println("Calificación mínima: " + min);

        if (reprobatorias > 0) {
            System.out.println("Hay " + reprobatorias + " calificación(es) reprobatoria(s).");
            System.out.println("Las calificaciones reprobatorias son: " + listaReprobatorias);
        } else {
            System.out.println("No hay calificaciones reprobatorias.");
        }

        sc.close();
    }
}
