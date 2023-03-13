// ejercicio numero #02

import java.util.Scanner;

public class Ejercicio2{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);
        
         System.out.print("ingrese un numero: ");
         int numero = entrada.nextInt();

        if (numero % 2 == 0){
            System.out.print("este numero es par");
        } else {
            System.out.print("este numero no es par");
        }
    }

}