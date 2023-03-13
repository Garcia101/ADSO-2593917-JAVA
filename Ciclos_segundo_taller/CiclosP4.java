import java.util.Scanner;

public class CiclosP4{
    public static void main (String [] args){
       Scanner entrada = new Scanner(System.in);

       System.out.println ("Ingrese un numero n, MAX  6 digitos");
       int numero = entrada.nextInt();
       int original = numero;
       int invertido = 0;
       
       while (numero !=0){
        int ultimo=numero%10;
        invertido = (invertido*10)+ultimo;
        numero=numero/10;
       }
       if (invertido==original){
        System.out.println("El numero SI es palondromo");
       }else{
        System.out.println("El numero NO es palindromo");
       }




    }
}