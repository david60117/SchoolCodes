
import java.util.Scanner;

public class PoliComTelef {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Politicas de cobro sobre el uso del teléfono");
        float min, prec = 0, tprec = 0;
        int dia,turn;
        System.out.println("0. Domingo. 1.Lunes. 2. Martes. 3.Miércoles. 4.Jueves. 5.Viernes. 6.Sábado");
        System.out.print("Que día es: ");
        dia = sc.nextInt();
        System.out.println("Turno: (1.Matutino 2.Vespertino)");
        turn = sc.nextInt();
        System.out.print("Minutos: ");
        min = sc.nextFloat();
        
        if(min<=5){
            prec=min;
        } else if (min>=6 && min<=8){
            prec= (float) (5+((min%5)*(0.8)));
        } else if(min>=9 && min <=10){
            prec=(float)(7.4+((min%8)*(0.7)));
        } else {
            prec=(float)(8.8+((min-10)*(0.5)));
        }
        switch (dia) {
            case 0:
                tprec=(float) (prec*1.03);
                break;
            case 1,2,3,4,5,6:
                if(turn==1){
                    tprec=(float) (prec*1.15);
                } else if (turn==2){
                    tprec=(float) (prec*1.1);
                } else {
                    System.out.print("Entrada no valida");
                }
                break;
            default:
                System.out.print("Error");;
        }
        System.out.println("Precio antes de imp.: "+prec);
        System.out.print("Precio: "+tprec);

        sc.close();
    }
}
