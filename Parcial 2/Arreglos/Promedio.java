import java.util.Scanner;

public class Promedio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántas calificaciones deseas ingresar? ");
        int n = sc.nextInt();

        int[] calificaciones = new int[n];
        int suma = 0;


        for (int i = 0; i < n; i++) {
            System.out.print("Ingresa la calificación " + (i+1)  + ": ");
            calificaciones[i] = sc.nextInt();
            suma += calificaciones[i]; 
        }


        System.out.println("CALIFICACIONES: ");
        for (int c : calificaciones) {
            System.out.print(c + " | ");
        }


        float promedio = (float) suma / n;


        System.out.println("Total de calificaciones: " + n);
        System.out.println("El promedio de las calificaciones es " + promedio);

        sc.close();
    }
}