import java.util.Scanner;

public class NumSei {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Escribe los valores de a y b");
        System.out.print("a: ");
        int a = sc.nextInt();

        System.out.print("b: ");
        int b = sc.nextInt();

        if (a==6 || b==6 || a+b==Math.abs(6)|| Math.abs(a-b)==6 ){
            System.out.println("Verdadero");
        } else {
            System.out.println("Falso");
        }
        sc.close();
    }
    
}
