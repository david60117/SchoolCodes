import java.util.Scanner;

public class Cola {
    int MAX; 
    int frente;
    int final_; 
    String[] COLA;

public Cola() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero máximo de elementos en la Cola: ");
        
        MAX = sc.nextInt(); 
        COLA = new String[MAX]; 
        
        frente = -1;
        final_ = -1;
    }

public void encolar() {
        if (final_ == MAX - 1) { 
            System.out.println("COLA LLENA!!! No se puede insertar.");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Elemento a Insertar: ");
            String valor = sc.nextLine();
            
            if (frente == -1) {
                frente = 0;
            }
            
            final_++;
            COLA[final_] = valor;
            System.out.println("Elemento insertado.");
        }
    }

public String desencolar() {
        if (frente == -1 || frente > final_) {
            System.out.println("La cola está vacía. No se puede eliminar.");
            return null;
        } else {
            String Aux = COLA[frente];
            System.out.println("Se eliminó: " + Aux);
            
            frente++;
            
            if (frente > final_) {
                System.out.println("La cola ha quedado vacía.");
                frente = -1;
                final_ = -1;
            }
            return Aux;
        }
    }

public void vaciar() {
        frente = -1;
        final_ = -1;
        System.out.println("Se han eliminado correctamente todos los elementos de la COLA.");
    }

public void mostrar() {
        if (frente == -1 || frente > final_) {
            System.out.println("La cola está vacía.");
        } else {
            System.out.println("ELEMENTOS EN LA COLA");
            for (int i = frente; i <= final_; i++) {
                System.out.println(COLA[i]);
            }
        }
    }

public static void main(String[] args) {
        Cola operacion = new Cola();
        int op = 0;
        Scanner opc = new Scanner(System.in);
        
        do {
            System.out.println("\n========== M E N U (COLAS) =========");
            System.out.println("1.- Insertar elemento (Encolar)");
            System.out.println("2.- Eliminar elemento (Desencolar)");
            System.out.println("3.- Vaciar toda la cola");
            System.out.println("4.- Mostrar Cola");
            System.out.println("5.- Salir");
            System.out.print("OPCIÓN: ");
                
            op = opc.nextInt();

            switch (op) {
                case 1:
                    operacion.encolar();
                    break;
                case 2:
                    operacion.desencolar();
                    break;
                case 3:
                    operacion.vaciar();
                    break;
                case 4:
                    operacion.mostrar();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (op != 5);
    }
}

