import java.util.Scanner;

public class Matriz11 {
    int x;
    int y;
    int [][] arreglo;
    Scanner sc = new Scanner(System.in);

    public Matriz11(){
        System.out.print("Numeró deseado de filas que contenga la matriz: ");
        x=sc.nextInt();
        System.out.print("Número deseado de columnas que contenga la matriz: ");
        y=sc.nextInt();
        arreglo = new int [x][y];
    }

   public void almacenar() {
        if (x == 0 || y == 0) {
            System.out.println("Elimino la matriz anterior, defina las nuevas dimensiones...");
            System.out.print("Número deseado de filas que contenga la matriz: ");
            x = sc.nextInt();
            System.out.print("Número deseado de columnas que contenga la matriz: ");
            y = sc.nextInt();
            arreglo = new int[x][y];
        }

        boolean Vacios = false;
        for (int f = 0; f < x; f++) {
            for (int c = 0; c < y; c++) {
                if (arreglo[f][c] == Integer.MIN_VALUE) {
                    Vacios = true;
                    break;
                }
            }
            if (Vacios) break;
        }

        if (Vacios) {
            System.out.println("Se detectaron espacios vacíos en la matriz.");
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Rellenar los espacios vacíos.");
            System.out.println("2. Reescribir toda la matriz.");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    for (int f = 0; f < x; f++) {
                        for (int c = 0; c < y; c++) {
                            if (arreglo[f][c] == Integer.MIN_VALUE) {
                                while (true) {
                                    System.out.print("Elemento [" + f + "][" + c + "]: ");
                                    if (sc.hasNextInt()) {
                                        arreglo[f][c] = sc.nextInt();
                                        break;
                                    } else {
                                        System.out.println("Mensaje: Entrada inválida. Ingrese un entero.");
                                        sc.next();
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("Espacios vacíos rellenados correctamente.");
                    return;
                case 2:
                    System.out.println("Reescribiendo toda la matriz...");
                    break;
                default:
                    System.out.println("Opción inválida. Se procederá a reescribir toda la matriz.");
                    break;
            }
        }            

        for (int f = 0; f < x; f++) {
            for(int c = 0; c < y; c++){
                while (true) {
                    System.out.print("Elemento [" + f + "]["+ c +"]: ");
                    if (sc.hasNextInt()) {
                        arreglo[f][c] = sc.nextInt();
                        break; 
                    } else {
                        System.out.println("Mensaje: Entrada inválida para el elemento. Ingrese un entero.");
                                sc.next(); 
                    }
                }
            }
        }
    } 

    public void mostrar() {
        if (x == 0 || y == 0) {
            System.out.println("La matriz está vacía.");
            return;
        }
        System.out.println("Recorrido ascendente:");
        for (int f = 0; f < x; f++) {
            System.out.println();
            for(int c = 0; c < y; c++){
                if (arreglo[f][c] == Integer.MIN_VALUE)
                    System.out.print("  ");
                else
                    System.out.print(arreglo[f][c] + " ");
            }
        }
        System.out.println();
    }

    public void buscar(){
        if (x == 0 || y == 0) {
            System.out.println("La matriz está vacía.");
            return;
        }
        int valor;
        while (true) {
            System.out.print("Ingrese el valor a modificar: ");

            if (sc.hasNextInt()) {
                valor = sc.nextInt(); 
                break;                
            } else {
                System.out.println("Mensaje: Entrada inválida. Por favor, ingrese un número entero.");
                sc.next();            
            }
        }
        boolean encontrado=false;
        
        int fila=0;
        int columna=0;
        for (int f = 0; f < x; f++) {
            for(int c = 0; c < y; c++){
                if (valor==arreglo[f][c]) {
                    encontrado=true;
                    fila=f;
                    columna=c;
                    break;
                }
            }
        }
        if (encontrado){
            System.out.println("El valor " + valor + " esta en la posición ["+fila+"]["+columna+"]" );
        } else {
            System.out.println("Es valor "+ valor + " no esta en el arreglo");
        }
    }

    public void modificar(){
        if (x == 0 || y == 0) {
            System.out.println("La matriz está vacía.");
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
        boolean encontrado=false;
        
        int fila=0;
        int columna=0;
        for (int f = 0; f < x; f++) {
            for(int c = 0; c < y; c++){
                if (valor==arreglo[f][c]) {
                    encontrado=true;
                    fila=f;
                    columna=c;
                    break;
                }
            }
        }
        if (encontrado){
            while (true) {
                System.out.print("Valor a modificar del elemento [" + fila + "]["+ columna +"]: ");
                if (sc.hasNextInt()) {
                    arreglo[fila][columna] = sc.nextInt();
                    break; 
                } else {
                    System.out.println("Mensaje: Entrada inválida para el elemento. Ingrese un entero.");
                    sc.next(); 
                }
            }
        } else {
            System.out.println("Es valor "+ valor + " no esta en el arreglo");
        }
    }

    public void eliminarelemento(){
        if (x == 0 || y == 0) {
            System.out.println("La matriz está vacía.");
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
        boolean encontrado=false;
        
        int fila=0;
        int columna=0;
        for (int f = 0; f < x; f++) {
            for(int c = 0; c < y; c++){
                if (valor==arreglo[f][c]) {
                    encontrado=true;
                    fila=f;
                    columna=c;
                    break;
                }
            }
        }
        if (encontrado){
            System.out.println("Elemento eliminado");
            arreglo[fila][columna] = Integer.MIN_VALUE;
        } else {
            System.out.println("Es valor "+ valor + " no esta en el arreglo");
        }
    }

    public void eliminarConjunto() {
        arreglo = new int[0][0];
        x=0;
        y=0;
        System.out.println("Todos los elementos fueron eliminados.");
    }
    
    public void ordenarAsc() {
        if (x == 0 || y == 0) {
            System.out.println("La matriz está vacía. No se puede ordenar.");
            return;
        }

        int totalElementos = x * y;
        int[] arregloPlano = new int[totalElementos];
        int indice = 0;

        for (int f = 0; f < x; f++) {
            for (int c = 0; c < y; c++) {
                arregloPlano[indice] = arreglo[f][c];
                indice++;
            }
        }

        for (int i = 0; i < totalElementos - 1; i++) {
            for (int j = i + 1; j < totalElementos; j++) {
                if (arregloPlano[i] > arregloPlano[j]) {
                    int temp = arregloPlano[i];
                    arregloPlano[i] = arregloPlano[j];
                    arregloPlano[j] = temp;
                }
            }
        }

        indice = 0; 
        for (int f = 0; f < x; f++) {
            for (int c = 0; c < y; c++) {
                arreglo[f][c] = arregloPlano[indice];
                indice++;
            }
        }
        System.out.println("La matriz ha sido ordenada en forma ascendente.");
    }

    public static void main(String[] args) {
        Matriz11 operacion = new Matriz11();
        int op=0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Operaciones de arreglos");

        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Almacenar elementos");
            System.out.println("2. Mostrar matriz");
            System.out.println("3. Buscar");
            System.out.println("4. Modificar");
            System.out.println("5. Eliminar elemento");
            System.out.println("6. Eliminar matriz");
            System.out.println("7. Ordenar");
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
                case 2 -> operacion.mostrar();
                case 3 -> operacion.buscar();
                case 4 -> operacion.modificar();
                case 5 -> operacion.eliminarelemento();
                case 6 -> operacion.eliminarConjunto();
                case 7 -> operacion.ordenarAsc();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 0);
    }



}
