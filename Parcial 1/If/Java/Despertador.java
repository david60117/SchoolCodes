import java.util.Scanner;

public class Despertador {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        System.out.println("¿Son vacaciones? (true/false) ");
        boolean vac = sc.nextBoolean();

        System.out.println("0=Domingo. 1=Lunes. 2=Martes. 3=Miercoles 4=Jueves. 5=Viernes. 6=Sábado");

        System.out.print("Qué dia de la semana es: ");
        int dia = sc.nextInt();

        if (!vac){
            if (dia >0 && dia <6){
                System.out.println("Alarma 6:00");
            } else {
                System.out.println("Alarma 9:00");
            }    
        } else {
            if (dia >0 && dia <6){
                System.out.println("Alarma 8:00");
            } else {
                System.out.println("Sin alarma");
            }
        }

        sc.close();

    }
    
}
