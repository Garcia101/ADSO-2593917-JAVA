import java.util.Scanner;

public class Ciclos7{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        int cont = 1;

        System.out.println("ingrese el primer numero");
        int numero1 = entrada.nextInt();

        System.out.println("ingrese el segundo numero");
        int numero2 = entrada.nextInt();

        System.out.println("ingrese el tercer numero");
        int numero3 = entrada.nextInt();

        while((cont % numero1 !=0)|| (cont % numero2 != 0) || (cont % numero3 != 0)){
            cont++;
        }
        System.out.println("el minimo comun multiplo " + cont);
    }
}