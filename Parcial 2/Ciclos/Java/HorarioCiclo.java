
import java.util.Scanner;

public class HorarioCiclo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rep;
        int hor;
        do { 
            System.out.print("Ingrese la hora en formato hrs.: ");
        hor = sc.nextInt();

        switch (hor){
            case 6,7,8,9,10,11,12:
                System.out.println("Buenos días");
                break;
            case 13,14,15,16,17,18,19,20:
                System.out.println("Buenas tardes");
                break;
            case 21,22,24,0,1,2,3,4,5:
                System.out.println("Buenas noches");
                break;
            default:
                System.out.println("Entrada no valida");
        }
        System.out.println("¿Desea introducir otra hora?");
        sc.nextLine();
        rep = sc.nextLine();
        } while (rep.equalsIgnoreCase("si"));

    }
    
}
