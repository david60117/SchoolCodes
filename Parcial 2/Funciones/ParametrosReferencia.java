import java.util.Scanner;

class Caja {
    int valor;
}

public class ParametrosReferencia {

    public static void duplicar(Caja c) {
        c.valor = c.valor * 2; // modificamos atributo del objeto
        System.out.println("Dentro del método: " + c.valor);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcion;

        do {
            Caja miCaja = new Caja();
            System.out.print("Ingresa un valor para la caja: ");
            miCaja.valor = sc.nextInt();

            System.out.println("Antes de llamar al método: " + miCaja.valor);
            duplicar(miCaja);
            System.out.println("Después de llamar al método: " + miCaja.valor);

            System.out.print("¿Quieres repetir? (si/no): ");
            opcion = sc.next();
        } while (opcion.equalsIgnoreCase("si"));

        sc.close();
    }
}
