public class Ciclos {
    public static void main(String[] args) {
        //Ciclo while
        int n=1,result=0;
        while(n<10){
            result=result+n;
            n++;
        }
        System.out.println(result);

        //ciclo do/while
        n=1;result=0;
        do { 
            result=result+n;
            n++;
        } while (n<10);
        System.out.println(result);

        //ciclo for
        result=0;
        for (n=1;n<10;n++){
            result=result+n;
        }
        System.out.println(result);
    }
}
