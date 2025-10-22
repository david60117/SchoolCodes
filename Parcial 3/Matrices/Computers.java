import java.util.Scanner;

public class Computers {
    int x;
    int y;
    int [][] matriz;
    Scanner sc = new Scanner(System.in);
    boolean MatrizExistente=false;

    public Computers(){
        x=4;
        y=4;
        matriz = new int [x][y];
    }
    
    public void almacenar() { 

        for (int f = 0; f < x; f++) {
            for(int c = 0; c < y; c++){
                while (true) {
                    System.out.print("Elemento [" + f + "]["+ c +"]: ");
                    if (sc.hasNextInt()) {
                        int num = sc.nextInt();
                        boolean duplicado = false;

                        for (int i = 0; i < x; i++) {
                            for (int j = 0; j < y; j++) {
                            
                                if (i == f && j == c) {
                                    break; 
                                }
                            
                                if (matriz[i][j] == num) {
                                    duplicado = true;
                                    break;
                                }
                            }
                            
                            if (duplicado){
                                break;
                            }
                        }

                        if (duplicado) {
                            System.out.println("Elemento ya se encuentra en la matriz, introduzca otro.");
                        } else {
                            matriz[f][c] = num;
                            break;
                        }

                    } else {
                        System.out.println("Mensaje: Entrada inválida para el elemento. Ingrese un entero.");
                                sc.next(); 
                    }
                }
            }
        }
        MatrizExistente = true;
    }
    public void mostrar() {
        System.out.println("\nMatriz Original");
        for (int f = 0; f < x; f++) {
            for (int c = 0; c < y; c++) {
                System.out.printf("%-5d", matriz[f][c]);
            }
            System.out.println();
        }
    }
    
    public void sumaFilasColumnas() {
        int[] sumaColumnas = new int[y]; 
        int[] sumaFilas = new int[x];

        for (int c = 0; c < y; c++) {
            for (int f = 0; f < x; f++) {
                sumaColumnas[c] += matriz[f][c];
            }
        }

        for (int f = 0; f < x; f++) {
            for (int c = 0; c < y; c++) {
                sumaFilas[f] += matriz[f][c];
            }
        }

        for (int f = 0; f < x; f++) {
            for (int c = 0; c < y; c++) {
                
                System.out.printf("%-5d", matriz[f][c]);
            }
            System.out.printf("(%d)%n", sumaFilas[f]);
        }

        for (int c = 0; c < y; c++) {
            String sumaFormateada = "(" + sumaColumnas[c] + ")";
            System.out.printf("%-5s", sumaFormateada);
        }
        System.out.println();
    }

    public void sumarFila() {
        mostrar();
        System.out.print("Ingrese la fila que desea sumar (0 a " + (x - 1) + "): ");
        int fila;

        while (true) {
            if (sc.hasNextInt()) {
                fila = sc.nextInt();
                if (fila >= 0 && fila < x) {
                    break;
                } else {
                    System.out.print("Fila inválida. Ingrese un número entre 0 y " + (x - 1) + ": ");
                }
            } else {
                System.out.print("Entrada no válida. Ingrese un número: ");
                sc.next();
            }
        }
        int suma = 0;
        for (int c = 0; c < y; c++) {
            suma += matriz[fila][c];
        }
        System.out.println("Suma de la fila " + fila + " es: " + suma);
    }
       
    public void sumarColumna() {
        mostrar();
        System.out.print("Ingrese la columna que desea sumar (0 a " + (y - 1) + "): ");
        int columna;

        while (true) {
            if (sc.hasNextInt()) {
                columna = sc.nextInt();
                if (columna >= 0 && columna < y) {
                    break;
                } else {
                    System.out.print("Columna inválida. Ingrese un número entre 0 y " + (y - 1) + ": ");
                }
            } else {
                System.out.print("Entrada no válida. Ingrese un número: ");
                sc.next();
            }
        }

        int suma = 0;
        for (int f = 0; f < x; f++) {
            suma += matriz[f][columna];
        }
        System.out.println("Suma de la columna " + columna + " es: " + suma);
    }

    public void Pares() {
        mostrar();
        int contador = 0;
        for (int f = 0; f < x; f++) {
            for (int c = 0; c < y; c++) {
                if (matriz[f][c] % 2 == 0) {
                    contador++;
                }
            }
        }
        System.out.println("Hay " + contador + " números pares.");
    }

    public void Impares() {
        mostrar();
        int contador = 0;
        for (int f = 0; f < x; f++) {
            for (int c = 0; c < y; c++) {
                if (matriz[f][c] % 2 != 0) {
                    contador++;
                }
            }
        }
        System.out.println("Hay " + contador + " números impares.");
    }

    public void mayorMenor() {
        mostrar();
        int mayor = matriz[0][0];
        int menor = matriz[0][0];
        int posMayorF = 0, posMayorC = 0;
        int posMenorF = 0, posMenorC = 0;

        for (int f = 0; f < x; f++) {
            for (int c = 0; c < y; c++) {
                if (matriz[f][c] > mayor) {
                    mayor = matriz[f][c];
                    posMayorF = f;
                    posMayorC = c;
                }
                if (matriz[f][c] < menor) {
                    menor = matriz[f][c];
                    posMenorF = f;
                    posMenorC = c;
                }
            }
        }
        
        System.out.println("El número mayor es " + mayor + " y está en la posición [" + posMayorF + "][" + posMayorC + "]");
        System.out.println("El número menor es " + menor + " y está en la posición [" + posMenorF + "][" + posMenorC + "]");
    }

    public void matrizCuadrada(){
        mostrar();
        int [][] MCuadrada = new int [x][y];

        System.out.println("MATRIZ AL CUADRADO");
        for (int f = 0; f < x; f++) {
            for (int c = 0; c < y; c++) {
                MCuadrada[f][c] = matriz[f][c] * matriz[f][c];
                System.out.printf("%-8d", MCuadrada[f][c]);
            }
            System.out.println();
        }
    } 

    public void sumaDiagonalPrincipal() {
        mostrar();
        int suma = 0;
        for (int i = 0; i < x; i++) {
            suma += matriz[i][i];
        }
        System.out.println("Suma de la diagonal principal es: " + suma);
    }

    public void sumaDiagonalInversa() {
        mostrar();
        int suma = 0;
        for (int f = 0; f < x; f++) {
            int c = (y - 1) - f;
            suma += matriz[f][c];
        }
        System.out.println("Suma de la diagonal inversa es: " + suma);
    }   
    
    public void media() {
        mostrar();
        double sumaTotal=0;
        for (int f = 0; f < x; f++) {
            for (int c = 0; c < y; c++) {
                sumaTotal += matriz[f][c];
            }
        }
        double media=0;
        media = sumaTotal/(x*y);
        System.out.printf("Media de todos los valores es: %.2f%n", media);
    }


    public static void main(String[] args) {
        Computers seleccion = new Computers();
        System.out.println("SISTEMA DE PAGO DE CHOFERES");
        int op = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n========= MENÚ PRINCIPAL =========");
            System.out.println("1.  Rellenar la matriz");
            System.out.println("2.  Reporte de sumas filas y columnas");
            System.out.println("3.  Sumar fila específica");
            System.out.println("4.  Sumar columna específica");
            System.out.println("5.  Mostrar mayor y menor");
            System.out.println("6.  Contar números pares");
            System.out.println("7.  Contar números impares");
            System.out.println("8.  Generar matriz al cuadrado");
            System.out.println("9.  Sumar diagonal principal");
            System.out.println("10. Sumar diagonal inversa");
            System.out.println("11. Media de todos los valores");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                op = sc.nextInt();
            } else {
                op = -1;
                sc.next(); 
            }
            
            switch (op) {
                case 1 ->seleccion.almacenar();
                case 2 -> {
                    if (seleccion.MatrizExistente) {
                        seleccion.sumaFilasColumnas();
                    } else {
                        System.out.println("Error: Debe registrar la matriz primero (Opción 1).");
                    }
                }
                case 3 -> {
                    if (seleccion.MatrizExistente) {
                        seleccion.sumarFila();
                    } else {
                        System.out.println("Error: Debe registrar la matriz primero (Opción 1).");
                    }
                }
                case 4 -> {
                    if (seleccion.MatrizExistente) {
                        seleccion.sumarColumna();
                    } else {
                        System.out.println("Error: Debe registrar la matriz primero (Opción 1).");
                    }
                }
                case 5 -> {
                    if (seleccion.MatrizExistente) {
                        seleccion.mayorMenor();
                    } else {
                        System.out.println("Error: Debe registrar la matriz primero (Opción 1).");
                    }
                }
                case 6 -> {
                    if (seleccion.MatrizExistente) {
                        seleccion.Pares();
                    } else {
                        System.out.println("Error: Debe registrar la matriz primero (Opción 1).");
                    }
                }
                case 7 -> {
                    if (seleccion.MatrizExistente) {
                        seleccion.Impares();
                    } else {
                        System.out.println("Error: Debe registrar la matriz primero (Opción 1).");
                    }
                }
                case 8 -> {
                    if (seleccion.MatrizExistente) {
                        seleccion.matrizCuadrada();
                    } else {
                        System.out.println("Error: Debe registrar la matriz primero (Opción 1).");
                    }
                }
                case 9 -> {
                    if (seleccion.MatrizExistente) {
                        seleccion.sumaDiagonalPrincipal();
                    } else {
                        System.out.println("Error: Debe registrar la matriz primero (Opción 1).");
                    }
                }
                case 10 -> {
                    if (seleccion.MatrizExistente) {
                        seleccion.sumaDiagonalInversa();
                    } else {
                        System.out.println("Error: Debe registrar la matriz primero (Opción 1).");
                    }
                }
                case 11 -> {
                    if (seleccion.MatrizExistente) {
                        seleccion.media();
                    } else {
                        System.out.println("Error: Debe registrar la matriz primero (Opción 1).");
                    }
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 0);
        sc.close();
    }
}
