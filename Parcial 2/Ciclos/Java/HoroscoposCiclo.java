import java.util.Scanner;

public class HoroscoposCiclo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numcump, rep;

        System.out.print("Cuantas fechas de nacimiento desea ingresar: ");
        numcump = sc.nextInt();

        for (rep=1;rep<=numcump;rep++){
            System.out.println("Cumpleaños no. "+rep);
            System.out.print("Ingrese su día de nacimiento: ");
            int dia = sc.nextInt();

            System.out.print("Ingrese su mes de nacimiento (1-12): ");
            int mes = sc.nextInt();

            switch (mes) {
                case 1:
                    if (dia >= 1 && dia <= 19){
                    System.out.println("Capricornio");
                    }else if (dia >= 20 && dia <= 31) {
                    System.out.println("Acuario");
                    }
                break;

                case 2:
                    if (dia >= 1 && dia <= 18) {
                        System.out.println("Acuario");
                    } else if (dia >= 19 && dia <= 29) {
                        System.out.println("Piscis");
                    }
                    break;

                case 3:
                    if (dia >= 1 && dia <= 20) {
                        System.out.println("Piscis");
                    } else if (dia >= 21 && dia <= 31) {
                        System.out.println("Aries");
                    }
                    break;

                case 4:
                    if (dia >= 1 && dia <= 19) {
                        System.out.println("Aries");
                    } else if (dia >= 20 && dia <= 30) {
                        System.out.println("Tauro");
                    }
                    break;

                case 5:
                    if (dia >= 1 && dia <= 20) {
                        System.out.println("Tauro");
                    } else if (dia >= 21 && dia <= 31) {
                        System.out.println("Géminis");
                    }
                    break;

                case 6:
                    if (dia >= 1 && dia <= 20) {
                        System.out.println("Géminis");
                    } else if (dia >= 21 && dia <= 30) {
                        System.out.println("Cáncer");
                    }
                    break;

                case 7:
                    if (dia >= 1 && dia <= 22) {
                        System.out.println("Cáncer");
                    } else if (dia >= 23 && dia <= 31) {
                        System.out.println("Leo");
                    }
                    break;

                case 8:
                    if (dia >= 1 && dia <= 22) {
                        System.out.println("Leo");
                    } else if (dia >= 23 && dia <= 31) {
                        System.out.println("Virgo");
                    }
                    break;

                case 9:
                    if (dia >= 1 && dia <= 22) {
                        System.out.println("Virgo");
                    } else if (dia >= 23 && dia <= 30) {
                        System.out.println("Libra");
                    }
                    break;

                case 10:
                    if (dia >= 1 && dia <= 22) {
                        System.out.println("Libra");
                    } else if (dia >= 23 && dia <= 31) {
                        System.out.println("Escorpio");
                    }
                    break;

                case 11:
                    if (dia >= 1 && dia <= 21) {
                        System.out.println("Escorpio");
                    } else if (dia >= 22 && dia <= 30) {
                        System.out.println("Sagitario");
                    }
                    break;

                case 12:
                    if (dia >= 1 && dia <= 21) {
                        System.out.println("Sagitario");
                    } else if (dia >= 22 && dia <= 31) {
                        System.out.println("Capricornio");
                    }
                    break;

                default:
                    System.out.println("Entrada no válida");
            }
        }
        sc.close();
    }
}
