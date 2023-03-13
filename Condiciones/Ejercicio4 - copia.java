// ejerecicio numero #04

import java.util.Scanner;

public class Ejercicio4{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println("ingrese primer numero: ");
        int primerNumero = entrada.nextInt();

        System.out.println("ingrese segundo numero: ");
        int segundoNumero = entrada.nextInt();

        System.out.println("ingrese segundo numero: ");
        int tercerNumero = entrada.nextInt();

        if (primerNumero > segundoNumero && primerNumero > tercerNumero){
            System.out.println("primer numero es mayor");
        }else if (segundoNumero > primerNumero && segundoNumero > tercerNumero){
            System.out.println("segundo numero es mayor");
        }else if (tercerNumero > primerNumero && tercerNumero > segundoNumero){
            System.out.println("tercer digito es mayor");
        }

        if (primerNumero < segundoNumero && primerNumero < tercerNumero){
            System.out.println("primer numero es menor");
        }else if (segundoNumero < primerNumero && segundoNumero < tercerNumero){
            System.out.println("segundo numero es menor");
        }else if (tercerNumero < primerNumero && tercerNumero < segundoNumero){
            System.out.println("tercer digito es menor");
        }

    }
}

