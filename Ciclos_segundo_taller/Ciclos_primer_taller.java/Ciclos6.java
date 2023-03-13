import java.util.Scanner;

public class Ciclos6{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println("ingrese un numero");
        int n = entrada.nextInt();

        int numero1 = 0;
        int numero2 = 1;
        int suma = 0;

        for (int i=0; i<n; i++){
            if (i<=1){
                //System.out.println("fib: " + i);
            }else{
                suma = numero1 + numero2;
                numero1 = numero2;
                numero2 = suma;
                //System.out.println("fib: " + suma);
            }
        }System.out.println("fib: " + suma);
    }
}