import java.util.Scanner;

public class AnalisisVentas {

    // Asumimos un precio constante para calcular el monto total de la venta
    final static double PRECIO_COMPUTADORA = 12500.50;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // --- 1. CONFIGURACIÓN INICIAL ---
        System.out.print("Ingrese la cantidad de vendedores (n): ");
        int n_vendedores = scanner.nextInt();

        System.out.print("Ingrese la cantidad de zonas (m): ");
        int m_zonas = scanner.nextInt();

        // Creamos el arreglo bidimensional
        int[][] ventas = new int[n_vendedores][m_zonas];

        // --- 2. LLENADO DE DATOS ---
        System.out.println("\n--- Ingrese las ventas ---");
        for (int i = 0; i < n_vendedores; i++) { // 'i' representa al vendedor
            for (int j = 0; j < m_zonas; j++) { // 'j' representa la zona
                System.out.print("Ventas del Vendedor " + i + " en Zona " + j + ": ");
                ventas[i][j] = scanner.nextInt();
            }
        }

        // --- 3. PROCESAMIENTO Y CÁLCULO ---

        // Para el total por zona
        int[] totalPorZona = new int[m_zonas];

        // Para el vendedor que menos vendió
        int minVentasVendedor = Integer.MAX_VALUE; // Inicializamos con el valor más alto posible
        int idVendedorMenos = -1;

        // Para el vendedor que más vendió
        int maxVentasVendedor = -1; // Inicializamos con un valor bajo
        int idVendedorMas = -1;

        // Para el total general
        int totalGeneralComputadoras = 0;

        // Recorremos el arreglo para hacer todos los cálculos
        for (int i = 0; i < n_vendedores; i++) { // 'i' es el vendedor (fila)
            
            int sumaVendedorActual = 0; // Acumulador para las ventas de este vendedor

            for (int j = 0; j < m_zonas; j++) { // 'j' es la zona (columna)
                
                int ventaActual = ventas[i][j];

                // Acumulamos el total para este vendedor
                sumaVendedorActual += ventaActual;

                // Acumulamos el total para esta zona
                totalPorZona[j] += ventaActual;

                // Acumulamos el total general
                totalGeneralComputadoras += ventaActual;
            }

            // Al terminar de sumar las zonas del vendedor 'i', comparamos
            
            // ¿Es el nuevo máximo vendedor?
            if (sumaVendedorActual > maxVentasVendedor) {
                maxVentasVendedor = sumaVendedorActual;
                idVendedorMas = i;
            }

            // ¿Es el nuevo mínimo vendedor?
            if (sumaVendedorActual < minVentasVendedor) {
                minVentasVendedor = sumaVendedorActual;
                idVendedorMenos = i;
            }
        }

        // Ahora, encontramos la zona que más vendió (procesando el arreglo totalPorZona)
        int maxVentasZona = -1;
        int idZonaMas = -1;

        for (int j = 0; j < m_zonas; j++) {
            if (totalPorZona[j] > maxVentasZona) {
                maxVentasZona = totalPorZona[j];
                idZonaMas = j;
            }
        }

        // --- 4. MOSTRAR RESULTADOS ---
        System.out.println("\n--- RESULTADOS DEL ANÁLISIS ---");

        // · La zona que más computadoras vendió.
        System.out.println("Zona que más vendió: Zona " + idZonaMas + " (con " + maxVentasZona + " computadoras)");
        System.out.println("---------------------------------");

        // · El vendedor que menos computadoras vendió.
        double montoVentaMenos = minVentasVendedor * PRECIO_COMPUTADORA;
        System.out.println("Vendedor que menos vendió: Vendedor " + idVendedorMenos);
        System.out.println("  - Cantidad: " + minVentasVendedor + " computadoras.");
        System.out.println(String.format("  - Monto de venta: $%.2f", montoVentaMenos));
        System.out.println("---------------------------------");

        // · El vendedor que más computadoras vendió.
        double montoVentaMas = maxVentasVendedor * PRECIO_COMPUTADORA;
        System.out.println("Vendedor que más vendió: Vendedor " + idVendedorMas);
        System.out.println("  - Cantidad: " + maxVentasVendedor + " computadoras.");
        System.out.println(String.format("  - Monto de venta: $%.2f", montoVentaMas));
        System.out.println("---------------------------------");

        // · La cantidad de computadoras vendidas por todos.
        System.out.println("Total de computadoras vendidas: " + totalGeneralComputadoras);
        
        scanner.close();
    }
}