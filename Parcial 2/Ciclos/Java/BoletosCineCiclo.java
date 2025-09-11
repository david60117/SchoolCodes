
import java.util.Scanner;

public class BoletosCineCiclo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double din=0,pars,tper,sol;
        String rep;
       
        System.out.println("¿Desea registrar una venta? (Si/No)");
        rep=sc.nextLine();
        while (rep.equalsIgnoreCase("Si")){
            System.out.println("¿Qué día es?: ");
            System.out.println("0. Domingo. 1.Lunes. 2. Martes. 3.Miércoles. 4.Jueves. 5.Viernes. 6.Sabado");
            System.out.print("Día: ");
            int dia = sc.nextInt();

            System.out.print("¿Cuántas entradas desea comprar?: ");
            double per = sc.nextDouble();

            System.out.println("¿Cuenta con membresia?: (true/false)");
            boolean mem = sc.nextBoolean();

            switch (dia){
                case 0,1,2,5,6:
                    if (mem) {
                        din=(50*per)*.9;
                    } else{
                        din=50*per;
                    }
                    break;
                case 3:
                    if (mem) {
                        din=(30*per)*.9;
                    } else{
                        din=30*per;
                    }
                    break;
                case 4:
                    if(mem){
                        if(per%2==0){
                            din=(per*37.5)*.9;
                        } else {
                            pars=Math.floor(per/2);
                            tper=pars*2;
                            sol=per%2;
                            din=((tper*37.5)+(sol*50))*.9; 
                        }
                    } else{
                        if(per%2==0){
                            din=(per*37.5);
                        } else {
                            pars=Math.floor(per/2);
                            tper=pars*2;
                            sol=per%2;
                            din=((tper*37.5)+(sol*50)); 
                        }
                    }
                    break;

                default:
                    System.out.print("Entrada no valida");    
            } 
        
            System.out.println("Su total es de: "+ din);
            System.out.println("¿Desea registrar otra venta? (Si/No)");
            sc.nextLine();
            rep = sc.nextLine();
        }

        sc.close();
    }
    
}
