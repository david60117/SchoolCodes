
import java.util.Scanner;

public class PiramiDeFiguras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i, j;
        System.out.print("Ingrese un número entero: ");
        n = sc.nextInt();

        for (i=1;i<=n;i++){
            for (j=1;j<=n;j++)
            System.out.print("*");
            System.out.println("");
        }
    }
    
}
