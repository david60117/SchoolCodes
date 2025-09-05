public class ParesImpares {
    public static void main(String[] args) {
        int SumPar=0;
        int SumImp=0;
        int i;

        for(i=0;i<=100;i++){
            if(i%2==0){
                SumPar=SumPar+i;
            } else {
                SumImp=SumImp+i;
            }
        }

        System.out.println("La suma de pares es: "+SumPar);
        System.out.println("La suma de impares es: "+SumImp);
    }
    
}
