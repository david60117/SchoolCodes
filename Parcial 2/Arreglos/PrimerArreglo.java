import java.util.Scanner;

public class PrimerArreglo {
    public static void main(String[] args) {
        int[] A = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejemplo arreglos unidimensionales");
        System.out.println("¿Cuántos elementos va a guardar?");
        int N = sc.nextInt();

        for(int i=0;i<=N;i++){
            System.out.println("Introduza un valor para la posición: "+i);
            int valor = sc.nextInt();
            A[i]=valor;
        }
        System.out.println("Los valores del arreglo");
        for(int i=0;i<=4;i++){
            System.out.print(A[i]+" ");
        }
    }
    
}
