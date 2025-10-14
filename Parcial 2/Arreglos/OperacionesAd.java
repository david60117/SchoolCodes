import java.util.Scanner;

public class OperacionesAd {
    
    int n;
    int[] arreglo;

    public OperacionesAd(){
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
        System.out.println("Recorrido ascendente:");
        for (int i = 0; i < n; i++) {
            System.out.print(arreglo[i] + " ");
        }
        System.out.println();
    }
    

    public void mostrardes (){
        if (arreglo.length == 0) {
            System.out.println("El arreglo está vacío.");
            return;
        }
        System.out.println("Recorrido descendente:");
        for (int i = n - 1; i >= 0; i--) {
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
        } else {
            System.out.println("El valor " + valor + " esta en la posición "+ i);
        }
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
            System.out.print("Ingrese el valor a modificar: ");
            if (sc.hasNextInt()){
                valor = sc.nextInt();
                break;
            } else {
                System.out.println("Mensaje: Entrada inválida. Por favor, ingrese un número entero.");
                sc.next();            
            }
        }
        while ((i<n)&&(valor!= arreglo[i])){
            i++;
        }
        if (i==n){
            System.out.println("Es valor "+ valor + " no esta en el arreglo");
        } else{
            System.out.println("Ingrese nuevo valor: ");
            int y = sc.nextInt();
            arreglo[i]= y;
        }
    }

    public void eliminar (){
        Scanner sc = new Scanner (System.in);
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

        while ((i<n)&&(valor!= arreglo[i])){
            i++;
        }
        if (i==n){
            System.out.println("El valor "+valor+" no se encuentra en el arreglo");
        } else {
            for (int k=i;k<n-1;k++) {
                arreglo[k] = arreglo[k+1];
            }
        }
        int nuevoLength = n - 1;
        int[] nuevoArreglo = new int[nuevoLength];
            
            
        for (int k = 0; k < nuevoLength; k++) {
            nuevoArreglo[k] = arreglo[k];
        }
            
        arreglo = nuevoArreglo; 
        n=nuevoLength;
            
        System.out.println("El valor " + valor + " ha sido eliminado. Nuevo tamaño: " + arreglo.length);

    }

    public void eliminarConjunto() {
        arreglo = new int[0];
        System.out.println("Todos los elementos fueron eliminados.");
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
        System.out.println("Arreglo ordenado en forma ascendente.");
    }

    public void ordenarDesc() {
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


    public static void main(String[] args) {
        OperacionesAd operacion = new OperacionesAd();
        int op=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Operaciones de arreglos");

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
                op = sc.nextInt();
            } else {
                op = -1;
                sc.next(); 
            }
            
            switch (op) {
                case 1 -> operacion.almacenar();
                case 2 -> operacion.mostrarasc();
                case 3 -> operacion.mostrardes();
                case 4 -> operacion.buscar();
                case 5 -> operacion.modificar();
                case 6 -> operacion.eliminar();
                case 7 -> operacion.eliminarConjunto();
                case 8 -> operacion.ordenarAsc();
                case 9 -> operacion.ordenarDesc();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 0);
    }
}
