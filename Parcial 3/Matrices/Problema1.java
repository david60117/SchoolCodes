
import java.util.Scanner;

public class Problema1 {
    Scanner sc = new Scanner(System.in);
    String [] nombres;
    int [][] datos;

    public Problema1(){
        nombres = new String[5];
        datos = new int[5][3];
    }

    public void registro() {
        for (int i = 0; i < 5; i++) {
            System.out.print("Nombre trabajador [" + i + "]: ");
            nombres[i] = sc.nextLine();
        }
    }

    public void hrstrabajo(){
        for (int f = 0; f < 5; f++) {
            for (int i = 0; i < 5; i++) {
                for(int c = 0; c < 1; c++){
                    while (true) {
                        System.out.print(nombres[i]+": ");
                        if (sc.hasNextInt()) {
                            datos[f][c] = sc.nextInt();
                            break; 
                        } else {
                            System.out.println("Mensaje: Entrada inválida para el elemento. Ingrese un entero.");
                                    sc.next(); 
                        }
                    }
                }
            }    
        }
    }


    public static void main(String[] args) {
        Problema1 seleccion = new Problema1();
        int op=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Operaciones de arreglos");

        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Registro de trabajadores");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                op = sc.nextInt();
            } else {
                op = -1;
                sc.next(); 
            }
            
            switch (op) {
                case 1 -> seleccion.registro();
                case 2 -> seleccion.hrstrabajo();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 0);
    }
}
