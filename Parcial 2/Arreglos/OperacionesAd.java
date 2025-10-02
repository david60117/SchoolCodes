import java.util.Scanner;

public class OperacionesAd {
    public static int[] arreglo = new int[0];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Guardar/Almacenar elementos");
            System.out.println("2. Recorrer arreglo (ascendente)");
            System.out.println("3. Recorrer arreglo (descendente)");
            System.out.println("4. Buscar elemento");
            System.out.println("5. Modificar elemento");
            System.out.println("6. Eliminar elemento");
            System.out.println("7. Eliminar todo el conjunto");
            System.out.println("8. Ordenar ascendente (burbuja)");
            System.out.println("9. Ordenar descendente (burbuja)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
            } else {
                opcion = -1;
                sc.next(); 
            }
            
            switch (opcion) {
                case 1 -> almacenar(sc);
                case 2 -> recorrerAsc();
                case 3 -> recorrerDesc();
                case 4 -> buscar(sc);
                case 5 -> modificar(sc);
                case 6 -> eliminarElemento(sc);
                case 7 -> eliminarConjunto();
                case 8 -> ordenarAsc();
                case 9 -> ordenarDesc();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);
    }

    public static void almacenar(Scanner sc) {
        System.out.print("¿Cuántos elementos desea almacenar? ");
        int n = sc.nextInt();
        arreglo = new int[n];
        for (int i = 0; i < n; i++) {
            while (true) {
            System.out.print("Elemento [" + i + "]: ");
            if (sc.hasNextInt()) {
                arreglo[i] = sc.nextInt();
                break; 
            } else {
                System.out.println("Mensaje: Entrada inválida para el elemento. Ingrese un entero.");
                sc.next(); 
            }
        }
        }
    }

    public static void recorrerAsc() {
        if (arreglo.length == 0) {
            System.out.println("El arreglo está vacío.");
            return;
        }
        System.out.println("Recorrido ascendente:");
        for (int i = 0; i < arreglo.length; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    public static void recorrerDesc() {
        if (arreglo.length == 0) {
            System.out.println("El arreglo está vacío.");
            return;
        }
        System.out.println("Recorrido descendente:");
        for (int i = arreglo.length - 1; i >= 0; i--) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    public static void buscar(Scanner sc) {
        if (arreglo.length == 0) {
            System.out.println("El arreglo está vacío.");
            return;
        }
        int valor;
        while (true) {
            System.out.print("Ingrese el valor a buscar: ");

            if (sc.hasNextInt()) {
                valor = sc.nextInt(); 
                break;                
            } else {
                System.out.println("Mensaje: Entrada inválida. Por favor, ingrese un número entero.");
                sc.next();            
            }
        }
        int i = 0;
        int n = arreglo.length;
        while ((i<n)&&(valor!= arreglo[i])){
            i++;
        }
        if (i==n){
            System.out.println("Es valor "+ valor + " no esta en el arreglo");
        } else {
            System.out.println("El valor " + valor + " esta en la posición "+ i);
        }
    }

    public static void modificar(Scanner sc) {
        if (arreglo.length == 0) {
            System.out.println("El arreglo está vacío.");
            return;
        }
        int i=0;
        int valor;
        while (true){
            System.out.print("Ingrese el valor a modificar");
            if (sc.hasNextInt()){
                valor = sc.nextInt();
                break;
            } else {
                System.out.println("Mensaje: Entrada inválida. Por favor, ingrese un número entero.");
                sc.next();            
            }
        }
        while ((i<arreglo.length)&&(valor!= arreglo[i])){
            i++;
        }
        if (i==arreglo.length){
            System.out.println("Es valor "+ valor + " no esta en el arreglo");
        } else{
            System.out.println("Ingrese nuevo valor: ");
            int y = sc.nextInt();
            arreglo[i]= y;
        }
        
    }

    public static void eliminarElemento(Scanner sc) {
        if (arreglo.length == 0) {
            System.out.println("El arreglo está vacío.");
            return;
        }
        int valor;
        int i=0;
        while (true){
            System.out.print("Ingrese el valor a eliminar: ");
            if (sc.hasNextInt()){
                valor = sc.nextInt();
                break;
            } else {
                System.out.println("Mensaje: Entrada inválida. Por favor, ingrese un número entero.");
                sc.next(); 
            }
        }

        while ((i<arreglo.length)&&(valor!= arreglo[i])){
            i++;
        }
        if (i==arreglo.length){
            System.out.println("El valor "+valor+" no se encuentra en el arreglo");
        } else {
            for (int k=i;k<arreglo.length-1;k++) {
                arreglo[k] = arreglo[k + 1];
            }
        }
        int nuevoLength = arreglo.length - 1;
        int[] nuevoArreglo = new int[nuevoLength];
            
            
        for (int k = 0; k < nuevoLength; k++) {
            nuevoArreglo[k] = arreglo[k];
        }
            
        arreglo = nuevoArreglo; 
            
        System.out.println("El valor " + valor + " ha sido eliminado. Nuevo tamaño: " + arreglo.length);


    }

    public static void eliminarConjunto() {
        arreglo = new int[0];
        System.out.println("Todos los elementos fueron eliminados.");
    }

    public static void ordenarAsc() {
        if (arreglo.length == 0) {
            System.out.println("El arreglo está vacío.");
            return;
        }
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
        System.out.println("Arreglo ordenado en forma ascendente.");
    }

    public static void ordenarDesc() {
        if (arreglo.length == 0) {
            System.out.println("El arreglo está vacío.");
            return;
        }
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1 - i; j++) {
                if (arreglo[j] < arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
        System.out.println("Arreglo ordenado en forma descendente.");
    }
}
