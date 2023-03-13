import java.util.Scanner;
public class CiclosP7{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print("Ingrese el numero N donde es la altura y el ancho-->  ");
        int ura = entrada.nextInt();

        int altura = (ura + 1 ) / 2;

        for (int i=0; i<=altura; i++) {
            for (int j=altura-i; j>0; j--) {
                System.out.print(" ");
            }
            for (int j=0; j<i;j++) {
                System.out.print(" x");
            }
            System.out.println("");
        }

        for (int i=0; i<=altura; i++) {
            for (int j=0; j<=i; j++) {
                System.out.print(" ");
            }
            for (int j=altura-i-1; j>0; j--) {
                System.out.print(" x");
            }
            System.out.println("");
        }
    }
}