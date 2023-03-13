// ejercicio #05

import java.util.Scanner;

public class Ejercicio5{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println("ingrese primer numero: ");
        int primerNumero = entrada.nextInt();

        System.out.println("ingrese segundo numero: ");
        int segundoNumero = entrada.nextInt();

        System.out.println("ingrese segundo numero: ");
        int tercerNumero = entrada.nextInt();

        if(primerNumero < segundoNumero && segundoNumero < tercerNumero){
            System.out.print("esta en forma ascendente");
        }else{
            System.out.print("no esta en forma ascendente");
        }
    }
}
