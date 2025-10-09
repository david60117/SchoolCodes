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

    // Método original: eliminar el primer elemento (FIFO)
    public String desencolar() {
        if (frente == -1 || frente > final_) {
            System.out.println("La cola está vacía. No se puede eliminar.");
            return null;
        } else {
            String Aux = COLA[frente];
            System.out.println("Se eliminó: " + Aux);

            // Recorrer todos los elementos hacia adelante
            for (int i = frente; i < final_; i++) {
                COLA[i] = COLA[i + 1];
            }

            final_--; // ahora hay un espacio libre al final

            if (final_ < frente) {
                frente = -1;
                final_ = -1;
                System.out.println("La cola ha quedado vacía.");
            }

            return Aux;
        }
    }

    // 🔹 Nuevo método: eliminar un elemento específico
    public void eliminarEspecifico() {
        if (frente == -1 || frente > final_) {
            System.out.println("La cola está vacía. No se puede eliminar.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Elemento a eliminar: ");
        String valor = sc.nextLine();

        int pos = -1;

        // Buscar la posición del elemento
        for (int i = frente; i <= final_; i++) {
            if (COLA[i].equals(valor)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("El elemento \"" + valor + "\" no se encuentra en la cola.");
            return;
        }

        // Recorrer los elementos hacia adelante
        for (int i = pos; i < final_; i++) {
            COLA[i] = COLA[i + 1];
        }

        final_--; // reducir tamaño lógico de la cola

        if (final_ < frente) {
            frente = -1;
            final_ = -1;
            System.out.println("La cola ha quedado vacía.");
        } else {
            System.out.println("Elemento \"" + valor + "\" eliminado correctamente.");
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
            System.out.println("ELEMENTOS EN LA COLA:");
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
            System.out.println("2.- Eliminar primer elemento (Desencolar)");
            System.out.println("3.- Eliminar elemento específico");
            System.out.println("4.- Vaciar toda la cola");
            System.out.println("5.- Mostrar Cola");
            System.out.println("6.- Salir");
            System.out.print("OPCIÓN: ");

            if (opc.hasNextInt()) {
                op = opc.nextInt();
            } else {
                System.out.println("Debes ingresar un número válido.");
                opc.next(); 
                op = 0;
            }

            switch (op) {
                case 1 -> operacion.encolar();
                case 2 -> operacion.desencolar();
                case 3 -> operacion.eliminarEspecifico();
                case 4 -> operacion.vaciar();
                case 5 -> operacion.mostrar();
                case 6 -> System.out.println("Saliendo...");
                default -> System.out.println("Opción no válida.");
            }
        } while (op != 6);
    }
}