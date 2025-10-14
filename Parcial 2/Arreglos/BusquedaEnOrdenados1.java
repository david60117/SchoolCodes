import java.util.Scanner;

public class BusquedaEnOrdenados1 {

    int n;
    int[] arreglo;
    Scanner sc = new Scanner (System.in);
    int valorbuscado = 0;

    public BusquedaEnOrdenados1() {
        sc = new Scanner(System.in);
        System.out.print("Número deseado de elementos que contenga el arreglo: ");
        n = sc.nextInt();
        arreglo = new int[n];
    }

    public void almacenar() {
        System.out.println("--- Ingrese los elementos del arreglo ---");
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Elemento [" + i + "]: ");
                if (sc.hasNextInt()) {
                    arreglo[i] = sc.nextInt();
                    break;
                } else {
                    System.out.println("Mensaje: Entrada inválida. Ingrese un entero.");
                    sc.next();
                }
            }
        }
    }

    public void mostrarasc() {
        if (arreglo.length == 0) {
            System.out.println("El arreglo está vacío.");
            return;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }

    public void buscar() {
        ordenarAsc();
        if (arreglo.length == 0) {
            System.out.println("El arreglo está vacío.");
            return;
        }

        int valorBuscado;
        while (true) {
            System.out.print("Ingrese el valor a buscar: ");
            if (sc.hasNextInt()) {
                valorBuscado = sc.nextInt();
                break;
            } else {
                System.out.println("Mensaje: Entrada inválida. Por favor, ingrese un número entero.");
                sc.next();
            }
        }

        int i = 0;
        while ((i < n) && (valorBuscado != arreglo[i])) {
            i++;
        }

        if (i == n) {
            System.out.println("El valor " + valorBuscado + " no está en el arreglo.");
            
            int posicion;
            do {
                
                posicion = 1;
                if (posicion < 0 || posicion > n) {
                    System.out.println("Posición fuera de rango. Inténtelo de nuevo.");
                }
            } while (posicion < 0 || posicion > n);

            int[] nuevoArreglo = new int[n + 1];

            for (int j = 0; j < posicion; j++) {
                nuevoArreglo[j] = arreglo[j];
            }

            nuevoArreglo[posicion] = valorBuscado;

            for (int j = posicion; j < n; j++) {
                nuevoArreglo[j + 1] = arreglo[j];
            }

            arreglo = nuevoArreglo;
            n++;

            System.out.println("Valor insertado correctamente");
            System.out.print("Nuevo arreglo: ");
            ordenarAsc();
            mostrarasc();
    
            

        } else {
            System.out.println("El valor " + valorBuscado + " está en la posición " + i);
        }
    }

    public void buscar2() {
        ordenarAsc();
        if (arreglo.length == 0) {
            System.out.println("El arreglo está vacío.");
            return;
        }

        int valorBuscado;
        while (true) {
            
                valorBuscado = 2;
                break;
            
        }

        int i = 0;
        while ((i < n) && (valorBuscado != arreglo[i])) {
            i++;
        }

        if (i == n) {
            System.out.println("El valor " + valorBuscado + " no está en el arreglo.");
            
            int posicion;
            do {
                
                posicion = 1;
                if (posicion < 0 || posicion > n) {
                    System.out.println("Posición fuera de rango. Inténtelo de nuevo.");
                }
            } while (posicion < 0 || posicion > n);

            int[] nuevoArreglo = new int[n + 1];

            for (int j = 0; j < posicion; j++) {
                nuevoArreglo[j] = arreglo[j];
            }

            nuevoArreglo[posicion] = valorBuscado;

            for (int j = posicion; j < n; j++) {
                nuevoArreglo[j + 1] = arreglo[j];
            }

            arreglo = nuevoArreglo;
            n++;

            System.out.println("Valor insertado correctamente");
            System.out.print("Nuevo arreglo: ");
            ordenarAsc();
            mostrarasc();

            

        } else {
            System.out.println("El valor " + valorBuscado + " está en la posición " + i);
        }
    }

    public void ordenarAsc() {
        if (arreglo.length == 0) {
            System.out.println("El arreglo está vacío.");
            return;
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arreglo[j] > arreglo[j + 1]) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
        }
        System.out.println("Arreglo ordenado en forma creciente.");
    }

    public static void main(String[] args) {
        BusquedaEnOrdenados1 operacion = new BusquedaEnOrdenados1();
        int op = 0;
        Scanner sc = operacion.sc;
        
        System.out.println("\nOperaciones de arreglos");

        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Almacenar elementos");
            System.out.println("2. Mostrar arreglo");
            System.out.println("3. Buscar elemento (e insertar si no se encuentra)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                op = sc.nextInt();
            } else {
                System.out.println("Opción inválida. Intente de nuevo.");
                op = -1;
                sc.next();
            }

            switch (op) {
                case 1:
                    operacion.almacenar();
                    break;
                case 2:
                    operacion.ordenarAsc();
                    operacion.mostrarasc();
                    break;
                case 3:
                    operacion.buscar();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    if (op != -1) {
                       System.out.println("Opción inválida. Intente de nuevo.");
                    }
            }
        } while (op != 0);
        
        sc.close();
    }
}