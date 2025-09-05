import java.util.Scanner;

public class Multiplos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingresa un número no negativo: ");
        int num = sc.nextInt();

        if (num % 3 == 0 && num % 5 == 0){
          System.out.println("Falso");  
        } else if (num % 3 == 0 || num % 5 == 0) {
            System.out.println("Verdadero");
        } else {
            System.out.println("El número no es multiplo de 5 ni de 3");
        }
    sc.close();
    }
    
}
