
import java.util.Scanner;

public class Figuras {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, fig, lin;
        System.out.print("Ingrese el núm de la figura deseada (1. Cuadrado 2. Triángulo 3. Triángulo inverso): ");
        fig = sc.nextInt();
        if (fig>3){
            System.out.println("Instrucción invalida");
            System.exit(0);
        }
        System.out.print("Dimensiones: ");
        lin = sc.nextInt();

        switch (fig) {
            case 1:
                for (i=1;i<=lin;i++){
                    for (j=1;j<=lin;j++){
                        System.out.print("*");
                    }
                    System.out.println("");
                }
                break;
            case 2:
                for (i=1;i<=lin;i++){
                    for(j=1;j<=(lin-i);j++){
                        System.out.print(" ");
                    }
                    for(j=1;j<=(2*i-1);j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 3:
                for(i=lin;i>=1;i--){
                    for (j=1;j<=(lin-i);j++){
                        System.out.print(" ");
                    }
                    for (j=1; j<=(2*i-1);j++){
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            default:
                System.out.print("Instruccion invalida");;
        }
    }
    
}
