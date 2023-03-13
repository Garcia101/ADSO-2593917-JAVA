import java.util.Scanner;

public class Ciclos3{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println("ingrese cuantas alturas quiere ver");
        int n = entrada.nextInt();
        
        for (int i = 0; i <= n; i++){
            int multi = (i * 2) - 1;
            int espacio = (n - i);

            for (int j = 0; j < multi; j++){
                System.out.print("X");
            }
            System.out.println();

            for (int m =1; m < espacio; m++)
                System.out.print(" ");
        }
    }
}