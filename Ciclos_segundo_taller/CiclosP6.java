import java.util.Scanner;

public class CiclosP6{
    public static void main (String [] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println(" => Ingrese aqui un numero N: ");
        int numero_n = entrada.nextInt();
        System.out.println(" =>  Ingrese aqui un numero M: ");
        int numero_m = entrada.nextInt();

        int suma=1;

        for ( int i=numero_n; i<=numero_m; i++){
            for (int j=1; j<=i;j++){
                suma=suma*j;
                if(j==i){
                    System.out.println(j+ " = ");
                }else{
                    System.out.println(j+ " * ");
                }
                if (i==j){
                    System.out.println(suma);
                    suma=1;
                }
            }
        }
    }

}