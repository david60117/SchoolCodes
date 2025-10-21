import java.util.Scanner;

public class Computers {
    int x;
    int y;
    int [][] matriz;
    Scanner sc = new Scanner(System.in);

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
                
                System.out.printf("%-5i", matriz[f][c]);
            }
            System.out.printf("(%d)%n", sumaFilas[f]);
        }

        for (int c = 0; c < y; c++) {
            String sumaFormateada = "(" + sumaColumnas[c] + ")";
            System.out.printf("%-5s", sumaFormateada);
        }
        System.out.println();
    }
        

    public static void main(String[] args) {
        Computers seleccion = new Computers();
        System.out.println("SISTEMA DE PAGO DE CHOFERES");
        int op = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Registro de matriz");
            System.out.println("2. Reporte");
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
                case 2 ->seleccion.sumaFilasColumnas();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 0);
    }
}
