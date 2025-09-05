
import java.util.Scanner;

public class Months {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa el número correspondiente al mes");
        int mes = sc.nextInt();

        switch (mes){
            case 1:
                System.out.print("Enero, 31 días");
                break;
            case 2:
                System.out.print("Febrero, 28 días");
                break;
            case 3:
                System.out.print("Marzo, 31 días");
                break;
            case 4: 
                System.out.print("Abril, 30 días");
                break;
            case 5:
                System.out.print("Mayo, 31 días");
                break;
            case 6:
                System.out.print("Junio, 30 días");
                break;
            case 7:
                System.out.print("Julio, 31 días");
                break;
            case 8:
                System.out.print("Agosto, 31 días");
                break;
            case 9:
                System.out.print("Septiembre, 30 días");
                break;
            case 10: 
                System.out.print("Octubre, 31 días");
                break;
            case 11:
                System.out.print("Noviembre, 30 días");
            case 12:
                System.out.print("Diciembre, 31 días");
            default:
                System.out.print("No valido");
            
        }
        sc.close();
    }
    
}
