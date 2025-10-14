import java.util.Scanner;

public class BusquedaEnOrdenados {
    
    int n;
    int[] arreglo;

    public BusquedaEnOrdenados(){
        Scanner sc =new Scanner(System.in);
        System.out.print("Numeró deseado de elementos que contenga el arreglo: ");
        n=sc.nextInt();
        arreglo = new int [n];
    }

    public void almacenar() {
        for (int i = 0; i < n; i++) {
            while (true) {
                Scanner sc = new Scanner(System.in);
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
    

    public void buscar(){
        Scanner sc = new Scanner(System.in);
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
                n++;
                System.out.println("Mensaje: Entrada inválida. Por favor, ingrese un número entero.");
                sc.next();            
            }
        }
        int i = 0;
        while ((i<n)&&(valor!= arreglo[i])){
            i++;
        }
        if (i==n){
            System.out.println("Es valor "+ valor + " no esta en el arreglo");
            modificar();
        } else {
            System.out.println("El valor " + valor + " esta en la posición "+ i);
        }
    }


    public void ordenarAsc() {
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
        System.out.println("Arreglo ordenado en forma creciente.");
    }

    public void modificar(){
        Scanner sc = new Scanner(System.in);
        if (arreglo.length == 0) {
            System.out.println("El arreglo está vacío.");
            return;
        }
        int i=0;
        int valor;
        while (true){
            System.out.print("Ingrese la posición dende se insetara: ");
            if (sc.hasNextInt()){
                valor = sc.nextInt();
                break;
            } else {
                System.out.println("Mensaje: Entrada inválida. Por favor, ingrese un número entero.");
                sc.next();            
            }
        }
        while ((i<n)&&(valor!= i)){
            i++;
        }
        if (i==n){
            System.out.println("Es valor "+ valor + " no esta en el arreglo");
        } else{
            int y = sc.nextInt();
            for (int k=i;k<n-1;k++) {
                arreglo[k] = arreglo[k+1];
            }
            arreglo[i]= y;
        }
    }


    public static void main(String[] args) {
        BusquedaEnOrdenados1 operacion = new BusquedaEnOrdenados1();
        int op=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Operaciones de arreglos");

        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Guardar/Almacenar elementos");
            System.out.println("2. Recorrer arreglo");
            System.out.println("3. Buscar elemento");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                op = sc.nextInt();
            } else {
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
                default:   
                    System.out.println("Opción inválida");
            }
        } while (op != 0);
    }
}
