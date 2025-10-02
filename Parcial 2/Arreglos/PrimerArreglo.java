import java.util.Scanner;

public class PrimerArreglo {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Ejemplo arreglos unidimensionales");
        System.out.println("¿Cuántos elementos va a guardar?");
        int N = sc.nextInt();
        int[] A = new int[N];

        for(int i=0;i<N;i++){
            System.out.println("Introduza un valor para la posición: "+i);
            int valor = sc.nextInt();
            A[i]=valor;
        }

        System.out.println("Los valores del arreglo");
        for(int i=0;i<N;i++){
            System.out.print(A[i]+" ");
        }
    
        System.out.println();
        System.out.println("Utilizando length");
        for(int i=0;i<A.length;i++){
            System.out.print(A[i]+" ");
        }
        /*System.out.println();
        System.out.println("Utilizando foreach");
        for(int i:A){
            System.out.print(A[i]+" ");
        }*/ 
    }
    
}
