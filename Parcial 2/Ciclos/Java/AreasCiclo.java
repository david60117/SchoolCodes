
import java.util.Scanner;

public class AreasCiclo {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String rep;
        double res;

        do {
            System.out.println("¿De que figura desea conocer el área?");
            System.out.println("1.Cuadrado. 2.Rectángulo. 3.Triángulo. 4. Circulo.");
            int fig = sc.nextInt();
            switch (fig) {
            case 1:
                System.out.print("Lado: ");
                double lad = sc.nextDouble();
                res = Math.pow(lad, 2);
                System.out.println("Área: "+ res);
                break;
            case 2:
                System.out.print("Base: ");
                double basr = sc.nextDouble();
                System.out.print("Altura: ");
                double altr = sc.nextDouble();
                res = basr*altr;
                System.out.println("Área: "+ res);
                break;
            case 3:
                System.out.print("Base: ");
                double bast = sc.nextDouble();
                System.out.print("Altura: ");
                double altt = sc.nextDouble();
                res = (bast*altt)/2;
                System.out.println("Área: "+ res);
                break;
            case 4:
                System.out.print("Radio: ");
                double rad = sc.nextDouble();
                res = 3.14*(Math.pow(rad, 2));
                System.out.println("Área: "+ res);
                break;
            default:
                System.out.print("Entrada no valida");
            }
            System.out.println("¿Quiere obtener el área de otra figura? (Si/No)");
            sc.nextLine();
            rep=sc.nextLine();
        } while (rep.equalsIgnoreCase("si"));
        sc.close();
    }
    
}
