import java.util.Scanner;

public class RegistroCalificaciones {

    int n;
    int m;
    double[][] calificaciones;
    
    static Scanner sc = new Scanner(System.in);
    
    boolean datosIngresados = false;
    
    double[] promediosEstudiantes;
    double[] promediosExamenes;


    public RegistroCalificaciones() {
        System.out.println("CREACIÓN DEL REGISTRO DE CALIFICACIONES");
        
        while (true) {
            System.out.print("Ingrese el número de estudiantes (N): ");
            if (sc.hasNextInt()) {
                n = sc.nextInt();
                if (n > 0) {
                    break;
                } else {
                    System.out.println("Error: El número debe ser positivo.");
                }
            } else {
                System.out.println("Entrada inválida. Ingrese un número entero.");
                sc.next();
            }
        }

        while (true) {
            System.out.print("Ingrese el número de exámenes (M): ");
            if (sc.hasNextInt()) {
                m = sc.nextInt();
                if (m > 0) {
                    break;
                } else {
                    System.out.println("Error: El número debe ser positivo.");
                }
            } else {
                System.out.println("Entrada inválida. Ingrese un número entero.");
                sc.next();
            }
        }
        
        calificaciones = new double[n][m];
    }

    public void ingresarDatos() {
        System.out.println("\nIngrese las calificaciones (0 a 10)");

        for (int i = 0; i < n; i++) {
            System.out.println("Estudiante " + (i + 1) + ":");
            for (int j = 0; j < m; j++) {
                while (true) {
                    System.out.print("  Examen " + (j + 1) + ": ");
                    if (sc.hasNextDouble()) {
                        double calif = sc.nextDouble();
                        if (calif >= 0 && calif <= 10) {
                            calificaciones[i][j] = calif;
                            break; 
                        } else {
                            System.out.println("  Error: La calificación debe estar entre 0 y 10.");
                        }
                    } else {
                        System.out.println("  Error: Entrada no válida. Ingrese un número.");
                        sc.next();
                    }
                }
            }
        }
        
        calcularPromediosEstudiantes(); 
        calcularPromediosExamenes();   
        
        datosIngresados = true;
    }

    private void calcularPromediosEstudiantes() {
        promediosEstudiantes = new double[n]; 
        for (int i = 0; i < n; i++) {
            double suma = 0;
            for (int j = 0; j < m; j++) {
                suma += calificaciones[i][j];
            }
            promediosEstudiantes[i] = suma / m;
        }
    }

    private void calcularPromediosExamenes() {
        promediosExamenes = new double[m]; 
        for (int j = 0; j < m; j++) { 
            double suma = 0;
            for (int i = 0; i < n; i++) { 
                suma += calificaciones[i][j];
            }
            promediosExamenes[j] = suma / n; 
        }
    }

    public void mostrarPromedioPorEstudiante() {
        System.out.println("\nPromedio por Estudiante");
        for (int i = 0; i < promediosEstudiantes.length; i++) {
            System.out.printf("Estudiante %d: %.2f%n", (i + 1), promediosEstudiantes[i]);
        }
    }

    public void mostrarEstudiantesConMejorPromedio() {
        System.out.println("\nEstudiante(s) con el MEJOR Promedio");
        
        double promedioMasAlto = -1.0;
        for (int i = 0; i < promediosEstudiantes.length; i++) {
            if (promediosEstudiantes[i] > promedioMasAlto) {
                promedioMasAlto = promediosEstudiantes[i];
            }
        }
        
        if (promedioMasAlto == -1.0) {
            System.out.println("No hay datos de estudiantes para comparar.");
            return;
        }

        int contador = 0;
        for (int i = 0; i < promediosEstudiantes.length; i++) {
            if (promediosEstudiantes[i] == promedioMasAlto) {
                contador++;
            }
        }

        String[] mejoresEstudiantes = new String[contador];
        int j = 0;

        for (int i = 0; i < promediosEstudiantes.length; i++) {
            if (promediosEstudiantes[i] == promedioMasAlto) {
                mejoresEstudiantes[j] = String.format("Estudiante %d (Promedio: %.2f)", (i + 1), promediosEstudiantes[i]);
                j++;
            }
        }

        System.out.printf("El mejor promedio obtenido fue: %.2f%n", promedioMasAlto);
        System.out.println("Estudiantes que lo obtuvieron:");
        
        for (int i = 0; i < mejoresEstudiantes.length; i++) {
            System.out.println(mejoresEstudiantes[i]);
        }
    }
    
    public void mostrarAlumnosDestacados() {
        System.out.println("\nAlumnos Destacados (Promedio 9.0 a 10.0)");
        
        int contador = 0;
        for (int i = 0; i < promediosEstudiantes.length; i++) {
            if (promediosEstudiantes[i] >= 9.0 && promediosEstudiantes[i] <= 10.0) {
                contador++;
            }
        }

        if (contador == 0) {
            System.out.println("Ningún estudiante tuvo un promedio en este rango.");
            return; 
        }

        String[] mejoresEstudiantes = new String[contador];
        int j = 0; 

        for (int i = 0; i < promediosEstudiantes.length; i++) {
            if (promediosEstudiantes[i] >= 9.0 && promediosEstudiantes[i] <= 10.0) {
                mejoresEstudiantes[j] = String.format("Estudiante %d (Promedio: %.2f)", (i + 1), promediosEstudiantes[i]);
                j++;
            }
        }

        for (int i = 0; i < mejoresEstudiantes.length; i++) {
            System.out.println(mejoresEstudiantes[i]);
        }
    }

    public void mostrarEstudiantesBajos() {
        System.out.println("\nEstudiantes con Promedio Inferior a 7.0");

        int contador = 0;
        for (int i = 0; i < promediosEstudiantes.length; i++) {
            if (promediosEstudiantes[i] < 7.0) {
                contador++;
            }
        }
        
        if (contador == 0) {
            System.out.println("Ningún estudiante tuvo un promedio inferior a 7.0.");
            return; 
        }
        
        String[] estudiantesBajos = new String[contador];
        int j = 0; 

        for (int i = 0; i < promediosEstudiantes.length; i++) {
            if (promediosEstudiantes[i] < 7.0) {
                estudiantesBajos[j] = String.format("Estudiante %d (Promedio: %.2f)", (i + 1), promediosEstudiantes[i]);
                j++;
            }
        }

        for (int i = 0; i < estudiantesBajos.length; i++) {
            System.out.println(estudiantesBajos[i]);
        }
    }

    public void mostrarPromediosExamenes() {
        double maxPromedio = -1.0;
        int maxAlum = -1;
        double minPromedio = 11.0; 
        int minAlum = -1;

        System.out.println("\nPromedios por Examen");
         for (int j = 0; j < promediosExamenes.length; j++) {
            System.out.printf("Promedio Examen %d: %.2f%n", (j + 1), promediosExamenes[j]);

            if (promediosExamenes[j] > maxPromedio) {
                maxPromedio = promediosExamenes[j];
                maxAlum = j;
            }
            if (promediosExamenes[j] < minPromedio) {
                minPromedio = promediosExamenes[j];
                minAlum = j;
            }
        }
        
        System.out.println("\nResumen:");
        System.out.printf("El examen con el promedio MÁS ALTO fue el Examen %d (Promedio: %.2f)%n", (maxAlum + 1), maxPromedio);
        System.out.printf("El examen con el promedio MÁS BAJO fue el Examen %d (Promedio: %.2f)%n", (minAlum + 1), minPromedio);
    }

    public static void main(String[] args) {
        
        RegistroCalificaciones registro = new RegistroCalificaciones();
        
        int op = 0;

        do {
            System.out.println("\nMENÚ DE CALIFICACIONES");
            System.out.println("1. Rellenar calificaciones"); 
            System.out.println("2. Mostrar promedio por estudiante");
            System.out.println("3. Mostrar estudiante(s) con el MEJOR promedio");
            System.out.println("4. Mostrar alumnos destacados (promedio 9-10)");
            System.out.println("5. Mostrar estudiantes con promedio < 7.0");
            System.out.println("6. Mostrar examen con promedio más alto y más bajo");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            if (RegistroCalificaciones.sc.hasNextInt()) {
                op = RegistroCalificaciones.sc.nextInt();
            } else {
                op = -1; 
                RegistroCalificaciones.sc.next(); 
            }
            
            switch (op) {
                case 1:
                    registro.ingresarDatos(); 
                    break;
                case 2:
                    if (registro.datosIngresados) {
                        registro.mostrarPromedioPorEstudiante();
                    } else {
                        System.out.println("Error: Debe rellenar las calificaciones primero (Opción 1).");
                    }
                    break;
                case 3:
                    if (registro.datosIngresados) {
                        registro.mostrarEstudiantesConMejorPromedio();
                    } else {
                        System.out.println("Error: Debe rellenar las calificaciones primero (Opción 1).");
                    }
                    break;
                case 4:
                    if (registro.datosIngresados) {
                        registro.mostrarAlumnosDestacados();
                    } else {
                        System.out.println("Error: Debe rellenar las calificaciones primero (Opción 1).");
                    }
                    break;
                case 5:
                    if (registro.datosIngresados) {
                        registro.mostrarEstudiantesBajos();
                    } else {
                        System.out.println("Error: Debe rellenar las calificaciones primero (Opción 1).");
                    }
                    break;
                case 6:
                    if (registro.datosIngresados) {
                        registro.mostrarPromediosExamenes();
                    } else {
                        System.out.println("Error: Debe rellenar las calificaciones primero (Opción 1).");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (op != 0);
        
    }
}