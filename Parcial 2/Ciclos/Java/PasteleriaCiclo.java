
import java.util.Scanner;

public class PasteleriaCiclo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rep;

        System.out.println("¿Desea registrar una venta? (Si/No)");
        rep=sc.nextLine();
        while (rep.equalsIgnoreCase("Si")){
            System.out.println("Sabores: 1.Manzana 2.Fresa. 3.Chocoloate");
            System.out.print("Ingrese su valor: ");     
            int sab = sc.nextInt();
            
            int din =0;
            int dinsnk;
            int dintt;

            switch (sab) {
                case 1:
                    din=200;
                    break;
                case 2:
                    din=250;
                    break;
                case 3:
                    System.out.println("Chocolate: 1. Negro. 2.Blanco");
                    System.out.print("C: ");
                    int choc = sc.nextInt();
                    if (choc==1){
                        din=280;
                    } else if (choc==2) {
                        din=300;
                    } else {
                        System.out.print("Entrada no valida");
                        System.exit(0);
                    }
                    break;
                default:
                    System.out.print("Entrada no valida");
                    System.exit(0);
            }
            System.out.println("Snacks: fresa, galleta, durazno");
            System.out.print("¿Cuántos snacks desea agregar?: ");
            int snk = sc.nextInt();

            dinsnk=din+(snk*25);

            System.out.print("¿Desea agregar nombre personalizado? (si/no): ");
            sc.nextLine();
            String nom = sc.nextLine();
            if(nom.equalsIgnoreCase("si")){
                dintt=dinsnk+30;
            } else {
                dintt=dinsnk+0;
            }
            System.out.println("Total: "+dintt);
                System.out.println("¿Desea registrar otra venta? (Si/No)");
                rep = sc.nextLine();
            }

        sc.close();
    }
    
}
