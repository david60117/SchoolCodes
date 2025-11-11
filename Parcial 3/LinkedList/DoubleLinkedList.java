import java.util.LinkedList;
import java.util.Scanner;

public class DoubleLinkedList {
    
    Scanner sc = new Scanner(System.in);
    LinkedList<Integer> lista = new LinkedList<>();

    public DoubleLinkedList(){
        System.out.println("Operaciones de LinkedList");
    }


    public void mostrarAdelante() {
        System.out.println("Contenido de la lista:");
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            for (int num : lista) {
                System.out.print(num + " <-> ");
            }
            System.out.println("null");
        }
    }

    public void mostrarAtras(){
        System.out.println("Contenido de la lista (Atrás):");
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            System.out.print("null");
            for (int i = lista.size() - 1; i >= 0; i--) {
                System.out.print(" <-> " + lista.get(i));
            }
            System.out.println();
        }
    }

    public void buscar() {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía, no se puede buscar.");
            return;
        }

        System.out.print("Ingresa el número a buscar: ");
        int valorBuscar = sc.nextInt();

        int posicion = lista.indexOf(valorBuscar);

        if (posicion != -1) {
            System.out.println("Elemento " + valorBuscar + " encontrado en la posición: " + posicion);
        } else {
            System.out.println("Elemento " + valorBuscar + " no se encuentra en la lista.");
        }
    }

    public void eliminarCualquiera (){
        System.out.print("Ingresa el número a eliminar: ");
        int eliminar = sc.nextInt();
        if (lista.remove((Integer) eliminar)) {
        System.out.println("Elemento eliminado correctamente.");
        mostrarAdelante();
        } else {
        System.out.println("Elemento no encontrado en la lista.");
        }
    }

    public void eliminarPrimero(){
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía, no se puede buscar.");
            return;
        }
        lista.removeFirst();
        mostrarAdelante();
    }

    public void eliminarUltimo(){
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía, no se puede buscar.");
            return;
        }
        lista.removeLast();
        mostrarAdelante();
    }

    public void insertarInicio(){
        System.out.print("Valor a insertar: ");
        int valor = sc.nextInt();
        lista.addFirst(valor);
        mostrarAdelante();
    }

    public void insertarFinal(){
        System.out.print("Valor a insertar: ");
        int valor = sc.nextInt();
        lista.addLast(valor);
        mostrarAdelante();
    }

    public void insertarCualquiera(){
        System.out.print("Posicion en la que desea agregar el valor: ");
        int pos = sc.nextInt();

        if (pos < 0 || pos > lista.size()) {
            System.out.println("Error: Posición no válida.");
            System.out.println("La lista tiene " + lista.size() + " elementos. Las posiciones válidas son de 0 a " + lista.size());
            return; 
        }
        System.out.print("Valor a insertar: ");
        int valor = sc.nextInt();
        lista.add(pos, valor);
    }

    public void modificar(){
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía, no se puede modificar.");
            return;
        }

        System.out.print("Ingresa el número que quieres modificar: ");
        int valorBuscar = sc.nextInt();

        int posicion = lista.indexOf(valorBuscar);

        if (posicion != -1) {
            System.out.print("Elemento encontrado. Ingresa el nuevo número: ");
            int nuevoValor = sc.nextInt();
            
            lista.set(posicion, nuevoValor);
            System.out.println("Elemento modificado correctamente.");
            mostrarAdelante();
    
        } else {
            System.out.println("Elemento " + valorBuscar + " no se encuentra en la lista.");
        }
    }

    public static void main(String[] args) {
        DoubleLinkedList operacion = new DoubleLinkedList();
        int op;
        Scanner sc = new Scanner(System.in);
        System.out.println("Operaciones de arreglos");

        do {
            System.out.println("\n=== MENÚ LISTA ENLAZADA ===");
            System.out.println("1. Insertar al inicio");
            System.out.println("2. Insertar al final");
            System.out.println("3. Insertar en cualquier lugar");
            System.out.println("4. Eliminar primer nodo");
            System.out.println("5. Eliminar ultimo nodo");
            System.out.println("6. Eliminar nodo cualquiera");
            System.out.println("7. Buscar elemento");
            System.out.println("8. Mostrar lista hacia adelante");
            System.out.println("9. Mostrar lista hacia átras");
            System.out.println("10. Modificar");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            if (sc.hasNextInt()) {
                op = sc.nextInt();
            } else {
                op = -1;
                sc.next(); 
            }
            
            switch (op) {
                case 1 -> operacion.insertarInicio();
                case 2 -> operacion.insertarFinal();
                case 3 -> operacion.insertarCualquiera();
                case 4 -> operacion.eliminarPrimero();
                case 5 -> operacion.eliminarUltimo();
                case 6 -> operacion.eliminarCualquiera();
                case 7 -> operacion.buscar();
                case 8 -> operacion.mostrarAdelante();
                case 9 -> operacion.mostrarAtras();
                case 10 -> operacion.modificar();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 0);
    }
}
