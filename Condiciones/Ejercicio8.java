import java.util.Scanner;

public class Ejercicio8{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println("ingrese un numero entero de 6 digitos: ");
        int numeroEntero = entrada.nextInt();

        int digito_1 = numeroEntero % 10;
        int digito_2 = (numeroEntero % 100) / 10
        int digito_3 = (numeroEntero % 1000) / 100
        int digito_4 = (numeroEntero % 10000) / 1000
        int digito_5 = (numeroEntero % 100000) / 10000
        int digito_6 = (numeroEntero % 1000000) / 100000

        
    }
}