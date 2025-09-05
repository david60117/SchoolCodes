
import java.util.Scanner;

public class MultaCopy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Es tu cumpleaños?");
        String cumpleaños = sc.nextLine();

        if (cumpleaños.equalsIgnoreCase("No")){

            System.out.print("Velocidad: ");
            int velocidad = sc.nextInt ();

            if (velocidad <= 60){
                System.out.println("0=Sin multa");
            } else if (velocidad > 60 && velocidad <= 80){
                System.out.println("1=Multa pequeña");
            } else {
                System.out.println("2=Multa grande");
            }
        } else {
            System.out.println("No hay multa");
        }
         sc.close();
    }
}