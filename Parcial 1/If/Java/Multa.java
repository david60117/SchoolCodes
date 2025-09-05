
import java.util.Scanner;

public class Multa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Es tu cumpleaños? 1.Si 2.No");
        int cumpleaños = sc.nextInt();

        if (cumpleaños==2){

            System.out.print("Velocidad: ");
            int velocidad = sc.nextInt ();

            if (velocidad <= 60){
                System.out.println("0=Sin multa");
            } else if (velocidad > 60 && velocidad <= 80){
                System.out.println("1=Multa pequeña");
            } else {
                System.out.println("2=Multa grande");
            }
        } else if (cumpleaños==1) {
            System.out.println("No hay multa");
        }
         sc.close();
    }
}