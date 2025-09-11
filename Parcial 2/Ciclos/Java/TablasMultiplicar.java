
import java.util.Scanner;

public class TablasMultiplicar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n,i;

        System.out.println("TABLAS DE MULTIPLICAR");

        do { 
            System.out.print("Ingrese el número de la tabla de multiplicar (0=Salir): ");
            n=sc.nextInt();
            if (n!=0){
                System.out.println("Tabla de multiplicar del "+n);
                for (i=1;i<=10;i++){
                    System.out.println(n+" x "+i+" = "+n*i);
                }
            }
        } while (n!=0);
    }
}
