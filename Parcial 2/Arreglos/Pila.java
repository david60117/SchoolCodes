import java.util.Scanner;

public class Pila {
    int CIMA;
    int TOPE;
    String[] PILA;
    String elemento;

    public Pila() { 
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero máximo de elementos en la Pila:   ");
        
        CIMA = sc.nextInt();
        PILA = new String[CIMA];
        
        TOPE=-1;
    }

    // Insertar un elemento en la pila (push) 
    public void push() { 
   
        if (TOPE == CIMA - 1) { 
            System.out.println("PILA LLENA!!!. No se puede insertar " ); 
        } else { 
            Scanner sc = new Scanner(System.in);
            System.out.println("Elemento a Insertar");
            
            String valor = sc.nextLine(); 
             TOPE++;
             PILA[TOPE]=valor;
            //System.out.print(" | " + PILA[TOPE] +"  | "); 
        }
    }

    // Eliminar un elemento de la pila (pop) 
    public String pop() { 
        if (TOPE == -1) { 
            System.out.println("La pila está vacía. No se puede eliminar."); 
            return null; // Valor de error 
        } else { 
            String elimina = PILA[TOPE];
            System.out.println("Se eliminó: " + elimina); 
            TOPE--;
            return elimina;
        } 
    }

    // Eliminar todo la pila

    public void vaciar (){
        TOPE=-1;
        System.out.println("Se han eliominado correctamente todos los eementos de la PILA");

    }

    // Mostrar los elementos de la pila
    public void mostrar() { 
        System.out.println(TOPE); 
        if (TOPE == -1) { 
            System.out.println("La pila está vacía."); 
        } else { 
            System.out.println("=== ELEMENTOS EN LA PILA ===");
            for (int i = TOPE; i >= 0; i--) { 
                System.out.println(PILA[i]);
            }
        } 
    }   

    public void popCualquiera() {
        if (TOPE == -1) {
            System.out.println("La pila está vacía. No se puede eliminar.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Elemento a eliminar: ");
        String valor = sc.nextLine();

        // Buscar el elemento
        int pos = -1;
        for (int i = 0; i <= TOPE; i++) {
            if (PILA[i].equals(valor)) {
                pos = i;
                break;
            }
        }

        if (pos == -1) {
            System.out.println("El elemento \"" + valor + "\" no se encuentra en la pila.");
            return;
        }

        // Desplazar los elementos hacia abajo desde la posición encontrada
        for (int i = pos; i < TOPE; i++) {
            PILA[i] = PILA[i + 1];
        }

        TOPE--; 

        System.out.println("Elemento \"" + valor + "\" eliminado correctamente.");
        }
    
    public static void main(String[] args) {
        Pila operacion = new Pila();
        int op=0;
        Scanner opc = new Scanner(System.in);
        System.out.println("OPERACIONES CON PILAS");
        do{
             System.out.println("========== M E N U =========");
            System.out.println("1.- Insertar elementos en la pila");
            System.out.println("2.- Eliminar elementos de la pila");
            System.out.println("3.- Eliminar cualquier elemento de la pila");
            System.out.println("4.- Eliminar toda la pila");
            System.out.println("5.- Mostrar Pila");
            System.out.println("6.- Salir");
                
            System.out.print("OPCIÓN:    ");
                
            op = opc.nextInt();

            switch (op) {
                 case 1: //Inserta elementos en la pila
                    operacion.push();
                    break;
                case 2: //Elimina elementos en la pila
                    operacion.pop();
                    break;
                case 3: //Elimina cualquie elemento en la pila
                    operacion.popCualquiera();
                    break;
                case 4: //Eliminar todos los elementos de la pila
                    operacion.vaciar();
                    break;
                case 5: //Muestra los elementos en la pila
                    operacion.mostrar();
                    break;
                default:
                    break;
            }  
        }while (op!=6);
    } 
}
  
