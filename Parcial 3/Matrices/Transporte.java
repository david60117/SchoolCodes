
import java.util.Scanner;

public class Transporte{
    Scanner sc = new Scanner(System.in);
    int choferes = 2;
    int dias = 7;

    String[] nombres;
    String[] descanso;
    double[] sueldohr;
    double[][] hrs;
    double[] totalhrs;
    double[] sueldosemanal;
    String [] nombresDias;
    double totalempresa=0;

    public Transporte(){
        nombres = new String[choferes];
        descanso = new String[choferes];
        sueldohr = new double[choferes];
        hrs = new double[choferes][dias];
        totalhrs = new double[choferes];
        sueldosemanal = new double[choferes];
        nombresDias = new String[]{"Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"};
    }

    public void registro(){
        for (int i = 0; i < choferes; i++) {
            System.out.print("Ingrese el nombre del chofer " + (i + 1) + ": ");
            nombres[i] = sc.nextLine();

            System.out.print("Ingrese el sueldo por hora de " + nombres[i] + ": ");
            sueldohr[i] = sc.nextDouble();
            sc.nextLine();

            System.out.print("Ingrese el día de descanso de " + nombres[i] + " (Lunes a Domingo): ");
            descanso[i] = sc.nextLine();

            for (int j = 0; j < dias; j++) {
                if (nombresDias[j].equalsIgnoreCase(descanso[i])) {
                    hrs[i][j] = 0;
                } else {
                    System.out.print("Ingrese las horas trabajadas por " + nombres[i] + " el día " + nombresDias[j] + ": ");
                    hrs[i][j] = sc.nextDouble();
                    sc.nextLine(); 
                }
            }
        }
    }

    public void reporte(){
        totalempresa = 0;

        for (int i = 0; i < choferes; i++) {
            totalhrs[i] = 0;
            for (int j = 0; j < dias; j++) {
                totalhrs[i] += hrs[i][j];
            }
            sueldosemanal[i] = totalhrs[i] * sueldohr[i];
            totalempresa += sueldosemanal[i];
        }

        double maxLunes = 0;
        String choferMasLunes = "";
        for (int i = 0; i < choferes; i++) {
            if (hrs[i][0] > maxLunes) {
                maxLunes = hrs[i][0];
                choferMasLunes = nombres[i];
            }
        }

        System.out.println("\nREPORTE SEMANAL DE CHOFERES\n"); //
        System.out.printf("%-15s %-10s %-10s %-15s %-10s\n", "Nombre", "Sueldo/Hr", "Horas Totales", "Día Descanso", "Sueldo");

        for (int i = 0; i < choferes; i++) {
            System.out.printf("%-15s %-10.2f %-10.2f %-15s %-10.2f\n",
                    nombres[i], sueldohr[i], totalhrs[i], descanso[i], sueldosemanal[i]);
        }

        System.out.println("\nTotal a pagar por la empresa: $" + totalempresa);
        System.out.println("Chofer que más trabajó el lunes: " + choferMasLunes + " (" + maxLunes + " horas)");

    }

    public static void main(String[] args) {
        Transporte seleccion = new Transporte();
        System.out.println("SISTEMA DE PAGO DE CHOFERES");
        int op=0;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\nMENÚ PRINCIPAL");
            System.out.println("1. Registro de los datos");
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
                case 1 ->seleccion.registro();
                case 2 ->seleccion.reporte();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 0);
    }
    
}