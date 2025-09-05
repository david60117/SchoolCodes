import java.util.Scanner;

public class EnterosOrdenados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese los valores a, b, c correspondientemente");

        System.out.print("a: ");
        int a = sc.nextInt();

        System.out.print("b: ");
        int b = sc.nextInt();

        System.out.print("c: ");
        int c = sc.nextInt();

        System.out.print("¿Se permite equalOk? (true/false) ");
        boolean rep = sc.nextBoolean();

        if(rep){
            if (a <= b && b <= c){
            System.out.println("Verdadero");
            } else{
            System.out.println("Falso");
            }
        } else {
            if (a < b && b < c){
            System.out.println("Verdadero");
            } else{
            System.out.println("Falso");
            }
        }
        
        sc.close();

    }
    
}
