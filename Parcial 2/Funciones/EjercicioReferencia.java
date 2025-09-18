import java.util.Scanner;

class Persona {
    String nombre;
    int edad;

    Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
}

public class EjercicioReferencia {

    public static void cumplirAnios(Persona p) {
        p.edad += 1;
        System.out.println("Dentro del método -> " + p.nombre + " tiene ahora " + p.edad + " años");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rep;

        do {
            System.out.print("Ingresa el nombre de la persona: ");
            String nombre = sc.nextLine();

            System.out.print("Ingresa la edad de " + nombre + ": ");
            int edad = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            Persona persona1 = new Persona(nombre, edad);

            System.out.println("Antes del método -> " + persona1.nombre + " tiene " + persona1.edad + " años");
            cumplirAnios(persona1);
            System.out.println("Después del método -> " + persona1.nombre + " tiene " + persona1.edad + " años");

            System.out.print("¿Quieres repetir? (si/no): ");
            rep = sc.nextLine();
        } while (rep.equalsIgnoreCase("si"));

        sc.close();
    }
}
