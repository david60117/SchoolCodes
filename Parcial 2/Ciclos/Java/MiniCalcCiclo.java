
import java.util.Scanner;

public class MiniCalcCiclo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rep;
        System.out.println("¿Cuántas operaciones requiere hacer?");
        int numop = sc.nextInt();
        
        for (rep=1;rep<=numop;rep++){
            System.out.println("Operación no. "+rep);
            System.out.println("Escribe dos números enteros");

            System.out.print("a: ");
            int a = sc.nextInt();

            System.out.print("b: ");
            int b = sc.nextInt();
        

            System.out.print("Escribe un carácter comprendido entre (+, -, *, /): ");
            char ope = sc.next().charAt(0);

            int resultado;

            switch (ope){
                case '+':
                    resultado = a+b;
                    System.out.println("Resultado: "+ resultado);
                    break;
                case '-':
                    resultado = a-b;
                    System.out.println("Resultado: "+ resultado);
                    break;
                case '*':
                    resultado = a*b;
                    System.out.println("Resultado: "+ resultado);
                    break;
                case '/':
                    if (b != 0){
                        resultado = a/b;
                        System.out.println("Resultado: "+ resultado);
                    } else {
                        System.out.println("No se puede dividir entre 0");
                    }
                    break;
                default:
                    System.out.print("Entrada no valida");
            
            }
        }
        
        sc.close();
    }
}
