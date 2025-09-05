
import java.util.Scanner;

public class SumasCondi {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese números enteros para designar a las variables");
        System.out.print("a: ");
        int a = sc.nextInt();

        System.out.print("b: ");
        int b = sc.nextInt();

        System.out.print("c: ");
        int c = sc.nextInt();

        if (a+b==10 || b+c==10 || a+c==10){
            System.out.println(10);
        }else if (a+b==b+c+10 || a+b==a+c+10){
            System.out.println(5);
        } else{
            System.out.println(0);
        }
        
        sc.close();
    }
    
}
