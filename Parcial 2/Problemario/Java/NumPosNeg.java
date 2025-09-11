
import java.util.Scanner;

public class NumPosNeg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int NumP=0, NumN=0,Neutr=0,CantNum,Cont=1, CantLeer;
        System.out.print("¿Cuántos número requiere introducir?: ");
        CantNum = sc.nextInt();

        do { 
            System.out.print("Ingrese el número: ");
            CantLeer = sc.nextInt();
            if(CantLeer==0){
                Neutr=Neutr+1;
            } else if (CantLeer<0){
                NumN=NumN+1;
            } else {
                NumP=NumP+1;
            }
            Cont++;
        } while (Cont<=CantNum);

        System.out.println("Cantidad de números neutros: "+Neutr);
        System.out.println("Cantidad de números positivos: "+NumP);
        System.out.print("Cantidad de números negativos: "+NumN);
    }
    
}
