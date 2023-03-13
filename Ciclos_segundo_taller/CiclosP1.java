import java.util.Scanner;

public class CiclosP1{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        int aux = 0;
        int producto = 0;

        System.out.println("ingrese un numeor entre 1 y 6");
        int n = entrada.nextInt();

        for(int i = 1; i <= n; i++){
            int aleatorio = (int)(Math.random()*10);
            aux = aux * 10 + aleatorio;
            producto = aux * 2;
            System.out.println("el numero es : " + aleatorio);
        } 
        System.out.println("el numero es construido " + aux);
        System.out.print("el producto es : " + producto);
    }
}