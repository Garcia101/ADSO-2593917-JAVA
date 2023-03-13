import java.util.Scanner;
public class CiclosUno{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println("ingrese el sueldo");
            int sueldo = entrada.nextInt();

        System.out.print("ingrese la cantidad de pagos");
        int cant_pagos = entrada.nextInt();

        System.out.println("--------------FORMAS DE PAGO------------");
        System.out.println("         1. pagos de igual valor        ");
        System.out.println("         2. primer pago diferente      ");
        System.out.println("         3. ultimo pago diferente      ");
        System.out.print("    4. primer pago y ultimo pago diferente");
        
        System.out.println("ingrese el metodo de pago que quiere");
        int metodo_pago = entrada.nextInt();

        if(metodo_pago == 1){
            int division = sueldo / cant_pagos; 
            for(int j = 0; j < cant_pagos; j++){
            System.out.println("division" + division);
            } 
        }else if(metodo_pago == 2){
            System.out.print("ingrese el nuevo sueldo");
            
        }
    }
}