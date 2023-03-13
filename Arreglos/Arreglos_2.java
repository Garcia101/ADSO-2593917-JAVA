package arreglos;

import java.util.Scanner;

public class Arreglos2 {
    public static void main(String [] args){
        Scanner entrada = new Scanner (System.in);

        System.out.println("ingrese el limite de el vector");
        int n = entrada.nextInt();

        int [] arreglito = entrada.nextInt();

        for(int i = 0; i <arreglito.length; i++){
            int aleatorio = (int)(Math.random()*10);
            System.out.println("NUMERO ALEATORIO : " + aleatorio);
        }
    }
}
        
