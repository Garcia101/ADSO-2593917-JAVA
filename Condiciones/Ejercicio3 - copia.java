
//ejercicio numero #03

import java.util.Scanner;

public class Ejercicio3{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);
        
         System.out.println("ingrese un numero en x: ");
         int numeroX = entrada.nextInt();

         System.out.println("ingrese un numero en y: ");
         int numeroY = entrada.nextInt();

         if(numeroX > 0 && numeroY > 0){
            System.out.print("esta ene el cuadrante 1");
         }else if (numeroX < 0 && numeroY > 0){
            System.out.print("esta en el cuadrante 2");
         }else if (numeroX < 0 && numeroY < 0){
            System.out.print("esta en el cuadrante 3");
         }else if (numeroX > 0 && numeroY < 0){
            System.out.print("esta en el cuadrante 4");
         }
      }
   }
