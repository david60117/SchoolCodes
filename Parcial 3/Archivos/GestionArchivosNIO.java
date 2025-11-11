import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.Scanner;

public class GestionArchivosNIO {

    private Scanner sc;
    private Path ruta;

    public GestionArchivosNIO() {
        this.sc = new Scanner(System.in);
        System.out.println("=== Gestión de Archivos con Java NIO ===");
        System.out.print("Ingresa el nombre del archivo (ej: misDatos.txt): ");
        
        String nombreArchivo = sc.nextLine();
        this.ruta = Paths.get(nombreArchivo);
        
        System.out.println("Archivo a gestionar: " + this.ruta.toAbsolutePath());
    }

    public void crearArchivo() {
        try {
            if (Files.notExists(ruta)) {
                Files.createFile(ruta);
                System.out.println("Archivo creado exitosamente.");
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.err.println("Error al crear el archivo: " + e.getMessage());
        }
    }

    public void leerArchivo() {
        try {
            if (Files.exists(ruta)) {
                String contenido = Files.readString(ruta);
                
                if (contenido.isEmpty()) {
                    System.out.println("El archivo está vacío.");
                } else {
                    System.out.println("\n--- Contenido del Archivo ---");
                    System.out.println(contenido);
                    System.out.println("------------------------------");
                }
            } else {
                System.out.println("El archivo no existe, no se puede leer.");
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
    }

    public void actualizarArchivo() {
        System.out.println("\nModo de actualización:");
        System.out.println("1. Sobrescribir (borra el contenido anterior)");
        System.out.println("2. Añadir al final (append)");
        System.out.print("Elige una opción: ");
        
        int op = sc.nextInt();
        sc.nextLine(); 

        System.out.print("Escribe el contenido a guardar:\n> ");
        String contenido = sc.nextLine();

        try {
            if (op == 1) {
                Files.writeString(ruta, contenido, 
                        StandardOpenOption.CREATE, 
                        StandardOpenOption.TRUNCATE_EXISTING);
                System.out.println("Archivo sobrescrito correctamente.");
                
            } else if (op == 2) {
                if (Files.exists(ruta) && Files.size(ruta) > 0) {
                     contenido = "\n" + contenido;
                }
                
                Files.writeString(ruta, contenido, 
                        StandardOpenOption.CREATE, 
                        StandardOpenOption.APPEND);
                System.out.println("Contenido añadido al archivo.");
                
            } else {
                System.out.println("Opción no válida.");
            }
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public void eliminarArchivo() {
        try {
            boolean eliminado = Files.deleteIfExists(ruta);
            
            if (eliminado) {
                System.out.println("Archivo eliminado exitosamente.");
            } else {
                System.out.println("El archivo no existía, no se eliminó nada.");
            }
        } catch (IOException e) {
            System.err.println("Error al eliminar el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        GestionArchivosNIO operacion = new GestionArchivosNIO();
        
        int op = 0;
        Scanner scMenu = new Scanner(System.in);

        do {
            System.out.println("\n=== MENÚ DE ARCHIVOS ===");
            System.out.println("1. Crear archivo (vacío)");
            System.out.println("2. Leer archivo");
            System.out.println("3. Actualizar (Escribir) archivo");
            System.out.println("4. Eliminar archivo");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");

            if (scMenu.hasNextInt()) {
                op = scMenu.nextInt();
            } else {
                op = -1; 
                scMenu.next(); 
            }

            switch (op) {
                case 1 -> operacion.crearArchivo();
                case 2 -> operacion.leerArchivo();
                case 3 -> operacion.actualizarArchivo();
                case 4 -> operacion.eliminarArchivo();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (op != 0);
        
        scMenu.close();
        operacion.sc.close(); 
    }
}