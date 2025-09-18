import java.util.Scanner;

public class ParametrosValor {

    public static void duplicar(int numero) {
        numero = numero * 2;
        System.out.println("Dentro del método: " + numero);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rep;

        do {
            System.out.print("Ingresa un valor para x: ");
            int x = sc.nextInt();

            System.out.println("Antes de llamar al método: " + x);
            duplicar(x);
            System.out.println("Después de llamar al método: " + x);

            System.out.print("¿Quieres repetir? (si/no): ");
            rep = sc.next();
        } while (rep.equalsIgnoreCase("si"));

        sc.close();
    }
}
