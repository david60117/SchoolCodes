
import java.util.Scanner;

public class Ahorro {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int Ahor, ContMes, cant;

        Ahor=0;
        ContMes=1;

        while (ContMes<=12){
            System.out.print("Ingrese la cantidad que ahorro en el mes "+ContMes+": ");
            cant=sc.nextInt();
            Ahor=Ahor+cant;
            System.out.println("Ahorro hasta el mes "+ContMes+" es de: "+Ahor);
            ContMes++;
        }
        
    }
    
}
