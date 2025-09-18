import java.util.Scanner;

public class Ejemplo3 {
    public static void duplicar(int numero) {
        numero = numero * 2;
        System.out.println("Número dentro del método: " + numero);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rep;

        do {
            System.out.print("Ingrese un número: ");
            int numero = sc.nextInt();

            duplicar(numero);

            System.out.println("Número fuera del método: " + numero);

            System.out.print("¿Desea ingresar otro número? (Si/No): ");
            sc.nextLine();
            rep = sc.nextLine();
        } while (rep.equalsIgnoreCase("Si"));

        sc.close();
    }
}
