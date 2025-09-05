
import java.util.Scanner;

public class Horario {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la hora en formato hrs.: ");
        int hor = sc.nextInt();

        switch (hor){
            case 6,7,8,9,10,11,12:
                System.out.print("Buenos días");
                break;
            case 13,14,15,16,17,18,19,20:
                System.out.print("Buenas tardes");
                break;
            case 21,22,24,0,1,2,3,4,5:
                System.out.print("Buenas noches");
                break;
            default:
                System.out.print("Entrada no valida");
        }

    }
    
}
