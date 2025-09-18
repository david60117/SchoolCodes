import java.util.Scanner;

public class EjercicioValor {

    public static void intercambiar(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("Dentro del método -> a: " + a + ", b: " + b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rep;

        do {
            System.out.print("Ingresa el valor de x: ");
            int x = sc.nextInt();

            System.out.print("Ingresa el valor de y: ");
            int y = sc.nextInt();

            System.out.println("Antes del método -> x: " + x + ", y: " + y);
            intercambiar(x, y);
            System.out.println("Después del método -> x: " + x + ", y: " + y);

            System.out.print("¿Quieres repetir? (si/no): ");
            rep = sc.next();
        } while (rep.equalsIgnoreCase("si"));

        sc.close();
    }
}
