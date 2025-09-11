
import java.util.Scanner;

public class Fibonanci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int NumElem, A=0, B=1, C, Cont=1;

        System.out.print("Número de elementos de la serie: ");
        NumElem = sc. nextInt();
        System.out.println(A);
        System.out.println(B);
        while (Cont<=(NumElem-2)){
            C=A+B;
            System.out.println(C);
            A=B;
            B=C;
            Cont++;
        }

    }
    
}
