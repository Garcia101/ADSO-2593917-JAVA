import java.util.Scanner;

public class CiclosP5{
    public static void main (String [] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println(" => Ingrese aqui un numero N: ");
        int numero = entrada.nextInt();

        int s=1;

        for (int i=1; i<=numero ; i++){
            s*=i;
            if (i==numero){
                System.out.print(i +" = ");
            }else{
                System.out.print(i +" X ");
            }
        }
        System.out.print(s);


    }

}