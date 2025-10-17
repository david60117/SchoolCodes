import java.util.Scanner;

public class MatrizStrng {
    int x;
    int y;
    boolean fistTime=true;
    String [][] arreglo;
    Scanner sc = new Scanner(System.in);

    public MatrizStrng(){
        System.out.print("Numeró deseado de filas que contenga la matriz: ");
        x=sc.nextInt();
        System.out.print("Número deseado de columnas que contenga la matriz: ");
        y=sc.nextInt();
        sc.nextLine();
        arreglo = new String [x][y];
    }

   public void almacenar() {
        if (x == 0 || y == 0) {
            System.out.println("Elimino la matriz anterior, defina las nuevas dimensiones...");
            System.out.print("Número deseado de filas que contenga la matriz: ");
            x = sc.nextInt();
            System.out.print("Número deseado de columnas que contenga la matriz: ");
            y = sc.nextInt();
            sc.nextLine();
            arreglo = new String[x][y];
            fistTime = true;
        }

        if (!fistTime) {
            boolean vacios = false;
            for (int f = 0; f < x; f++) {
                for (int c = 0; c < y; c++) {
                    if (arreglo[f][c] == null) {
                        vacios = true;
                        break;
                    }
                }
                if (vacios) break;
            }

            if (vacios) {
                System.out.println("Se detectaron espacios vacíos en la matriz.");
                System.out.println("¿Qué desea hacer?");
                System.out.println("1. Rellenar los espacios vacíos.");
                System.out.println("2. Reescribir toda la matriz.");
                System.out.print("Seleccione una opción: ");
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        for (int f = 0; f < x; f++) {
                            for (int c = 0; c < y; c++) {
                                if (arreglo[f][c] == null) {
                                    System.out.print("Elemento [" + f + "][" + c + "]: ");
                                    arreglo[f][c] = sc.nextLine();
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
        }

        for (int f = 0; f < x; f++) {
            for (int c = 0; c < y; c++) {
                System.out.print("Elemento [" + f + "][" + c + "]: ");
                arreglo[f][c] = sc.nextLine();
            }
        }

        fistTime = false;
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
                if (arreglo[f][c] == null)
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
        String valor;
        System.out.print("Ingrese el valor a buscar: ");
        valor = sc.nextLine(); 
            
        boolean encontrado=false;
        int fila=0;
        int columna=0;
        for (int f = 0; f < x; f++) {
            for(int c = 0; c < y; c++){
                if (arreglo[f][c] != null && arreglo[f][c].equals(valor)) {
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
        String valor;
        System.out.print("Ingrese el valor a modificar: ");
        valor = sc.nextLine(); 
            
        boolean encontrado=false;
        int fila=0;
        int columna=0;
        for (int f = 0; f < x; f++) {
            for(int c = 0; c < y; c++){
                if (arreglo[f][c] != null && arreglo[f][c].equals(valor)) {
                    encontrado=true;
                    fila=f;
                    columna=c;
                    break;
                }
            }
        }

        if (encontrado){
            System.out.print("Valor a modificar del elemento [" + fila + "]["+ columna +"]: ");
            arreglo[fila][columna] = sc.nextLine();
        } else {
            System.out.println("Es valor "+ valor + " no esta en el arreglo");
        }
    }

    public void eliminarelemento(){
        if (x == 0 || y == 0) {
            System.out.println("La matriz está vacía.");
            return;
        }
        String valor;
        System.out.print("Ingrese el valor a modificar: ");
        valor = sc.nextLine(); 
            
        boolean encontrado=false;
        int fila=0;
        int columna=0;
        for (int f = 0; f < x; f++) {
            for(int c = 0; c < y; c++){
                if (arreglo[f][c] != null && arreglo[f][c].equals(valor)) {
                    encontrado=true;
                    fila=f;
                    columna=c;
                    break;
                }
            }
        }
        if (encontrado){
            System.out.println("Elemento eliminado");
            arreglo[fila][columna] = null;
        } else {
            System.out.println("Es valor "+ valor + " no esta en el arreglo");
        }
    }

    public void eliminarConjunto() {
        arreglo = new String[0][0];
        x=0;
        y=0;
        System.out.println("Todos los elementos fueron eliminados.");
    }
    

    public static void main(String[] args) {
        MatrizStrng operacion = new MatrizStrng();
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
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                op = sc.nextInt();
                sc.nextLine();
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
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 0);
    }



}
