import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class FirstLinkedList {
    
    Scanner sc = new Scanner(System.in);
    LinkedList<Integer> lista = new LinkedList<>();

    public FirstLinkedList(){
        System.out.println("Operaciones de LinkedList");
    }

    public void agregar() {
        System.out.print("Ingresa un número para agregar: ");
        int valor = sc.nextInt();
        lista.add(valor);
        System.out.println("Elemento agregado correctamente.");
        mostrar();
    }

    public void mostrar() {
        System.out.println("Contenido de la lista:");
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía.");
        } else {
            for (int num : lista) {
                System.out.print(num + " -> ");
            }
            System.out.println("null");
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
            mostrar();
            
        } else {
            System.out.println("Elemento " + valorBuscar + " no se encuentra en la lista.");
        }
    }

    public void eliminar (){
        System.out.print("Ingresa el número a eliminar: ");
        int eliminar = sc.nextInt();
        if (lista.remove((Integer) eliminar)) {
        System.out.println("Elemento eliminado correctamente.");
        } else {
        System.out.println("Elemento no encontrado en la lista.");
        }
    }

    public void ordenarAsc() {
        if (lista.isEmpty()) {
            System.out.println("La lista está vacía, no se puede ordenar.");
            return;
        }
        
        Collections.sort(lista);
        System.out.println("Lista ordenada ascendentemente.");
        mostrar();
    }

    public void insertar(){
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

    public void insertarInicio(){
        int pos = 0;

        System.out.print("Valor a insertar: ");
        int valor = sc.nextInt();
        lista.add(pos, valor);
    }

    public static void main(String[] args) {
        FirstLinkedList operacion = new FirstLinkedList();
        int op=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Operaciones de arreglos");

        do {
            System.out.println("\n=== MENÚ LISTA ENLAZADA ===");
            System.out.println("1. Insertar elemento");
            System.out.println("2. Eliminar elemento");
            System.out.println("3. Modificar");
            System.out.println("4. Mostrar lista");
            System.out.println("5. Buscar");
            System.out.println("6. Orden ascendente");
            System.out.println("7. Insertar en cualquier posición");
            System.out.println("8. Insertar al inicio");
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
                case 1 -> operacion.agregar();
                case 2 -> operacion.eliminar();
                case 3 -> operacion.modificar();
                case 4 -> operacion.mostrar();
                case 5 -> operacion.buscar();
                case 6 -> operacion.ordenarAsc();
                case 7 -> operacion.insertar();
                case 8 -> operacion.insertarInicio();
                case 10 -> operacion.modificar();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 0);
    }
}
