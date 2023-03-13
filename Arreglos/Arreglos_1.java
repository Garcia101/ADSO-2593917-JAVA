package Arreglos;

import java.util.Scanner;

public class Arreglos_1 {
    public static void main(String [] args){
        Scanner entrada = new Scanner (System.in);

        System.out.println("ingrese el limite de el vector");
        int n = entrada.nextInt();

        //arreglo vacio
        int [] a = new int [n];

        for(int i = 0; i<a.length; i++){
            int g= i+1;
            a[i] = (g*2)-1;
        }

        //imprimir arreglo
        for(int i=0; i<=a.length; i++){
            System.out.println("["+a[i]+"]");
        }

    }
}
