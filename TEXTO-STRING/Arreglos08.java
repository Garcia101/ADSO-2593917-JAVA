import java.util.Scanner;

public class Arreglos08 {
    public static void main(String [] args){
        Scanner entrada = new Scanner (System.in);
        //limite dado por el usuario
        System.out.println("ingrese el limite de el vector");
        int n = entrada.nextInt();
        //arreglo de pares
        int [] pares = new int [n];

        // arreglo vacio : es el primer arreglo
        int [] contenedor = new int [n];

        // int par = 0;
        // int impar = 0; 
        // int bag = 0;
        

        for(int i = 0; i < contenedor.length; i++){
            System.out.println("ingrese los numeros que desee");
            int numbers = entrada.nextInt();
            contenedor [i] = numbers; 
            
        }
        //segundo for para imprimir que hace parte del primero
        for(int i = 0; i < contenedor.length; i++){
            System.out.println("[ " + contenedor [i] + " ]");
            System.out.print("");
            System.out.println("[  " + pares[i] + " ]");
            System.out.print("es par");
            
        }

    }
}