import java.util.Scanner;

public class Computers {
    int vendedores;
    int zonas;
    int [][] ventas;
    String [] nombres;
    double precio;
    Scanner sc = new Scanner(System.in);
    boolean MatrizExistente=false;

    public Computers(){
        System.out.print("Cuantos vendedores tiene en el sistema: ");
        vendedores=sc.nextInt();
        System.out.print("Número de Zonas: ");
        zonas=sc.nextInt();
        System.out.print("Precio de la computadora: ");
        precio=sc.nextDouble();
        ventas = new int [vendedores][zonas];
        nombres = new String[vendedores];
        sc.nextLine();
    }

    public void registro(){
        for (int i = 0; i < vendedores; i++) {
            System.out.print("Ingrese el nombre del chofer " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();
            System.out.println("\nIngrese las ventas de " + nombres[i]);

            for (int j = 0; j < zonas; j++) {
                System.out.print("Zona " + j + ": ");
                ventas[i][j] = sc.nextInt(); 
            }
            sc.nextLine();
        }
        MatrizExistente = true;
    }

    public void mostrar() {
        System.out.println("\nMatriz Original");
        System.out.println();
        for (int f = 0; f < vendedores; f++) {
            System.out.printf("%-10s",nombres[f]);
            for (int c = 0; c < zonas; c++) {
                System.out.printf("%-5d", ventas[f][c]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public void VentaMaxMin(){
        mostrar();
        int[] sumaVen = new int[vendedores];

        for (int f = 0; f < vendedores; f++) {
            for (int c = 0; c < zonas; c++) {
                sumaVen[f] += ventas[f][c];
            }
        }

        int mayor = sumaVen[0];
        int menor = sumaVen[0];
        int posMayor=0;
        int posMenor=0;

        for (int f=0; f < vendedores; f++){
            if (sumaVen[f] > mayor) {
                    mayor = sumaVen[f];
                    posMayor = f;
                }
                if (sumaVen[f] < menor) {
                    menor = sumaVen[f];
                    posMenor = f;
                }
        }

        System.out.println("El vendedor con mayor ventas fue " + nombres[posMayor]);
        System.out.println("Computadoras vendidas: "+mayor);
        System.out.printf("Monto total: $%.2f%n",(mayor*precio));
        System.out.println();
        System.out.println("El vendedor con menor ventas fue " + nombres[posMenor]);
        System.out.println("Computadoras vendidas: "+menor);
        System.out.printf("Monto total: $%.2f%n",(menor*precio));
    }

    public void cantidadComp(){
        mostrar();
        double sumaTotal=0;
        for (int f = 0; f < vendedores; f++) {
            for (int c = 0; c < zonas; c++) {
                sumaTotal += ventas[f][c];
            }
        }
        System.out.println("La cantidad total de computadoras vendidas fue: "+sumaTotal);
    }

    public void ZonaMax(){
        mostrar();
        int[] sumaZon = new int[zonas];

        for (int j = 0; j < zonas; j++) {
            for (int i = 0; i < vendedores; i++) {
                sumaZon[j] += ventas[i][j];
            }
        }

        int mayor = -1;
        int zonMayor=-1;

        for (int j=0; j < zonas; j++){
            if (sumaZon[j] > mayor) {
                mayor = sumaZon[j];
                zonMayor = j;
            } 
        }
        System.out.println("La zona que más computadoras vendió fue la Zona " + (zonMayor + 1) + " (con " + mayor + " computadoras).");
    }

    public static void main(String[] args) {
        Computers seleccion = new Computers();
        int op = 0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n========= MENÚ PRINCIPAL =========");
            System.out.println("1.  Registro");
            System.out.println("2.  Estadísticas (Venta max y min)");
            System.out.println("3.  Cantidad total de computadoras vendidas");
            System.out.println("4.  Zona con más venta");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                op = sc.nextInt();
            } else {
                op = -1;
                sc.next(); 
            }
            
            switch (op) {
                case 1 ->seleccion.registro();
                case 2 -> {
                    if (seleccion.MatrizExistente) {
                        seleccion.VentaMaxMin();
                    } else {
                        System.out.println("Error: Debe registrar la matriz primero (Opción 1).");
                    }
                }
                case 3 -> {
                    if (seleccion.MatrizExistente) {
                        seleccion.cantidadComp();
                    } else {
                        System.out.println("Error: Debe registrar la matriz primero (Opción 1).");
                    }
                }
                case 4 -> {
                    if (seleccion.MatrizExistente) {
                        seleccion.ZonaMax();
                    } else {
                        System.out.println("Error: Debe registrar las ventas primero (Opción 1).");
                    }
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 0);
        sc.close();
    }
}



