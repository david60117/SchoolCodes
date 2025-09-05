import java.util.Scanner;

public class SumaCondi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese números enteros para designar a las variables");
        System.out.print("a: ");
        int a = sc.nextInt();

        System.out.print("b: ");
        int b = sc.nextInt();

        System.out.print("c: ");
        int c = sc.nextInt();

        if(a+b==c || a+c==b || b+c==a){
            System.out.println("Verdadero");
        } else {
            System.out.println("Falso");
        }
        sc.close();
    }
    
}
