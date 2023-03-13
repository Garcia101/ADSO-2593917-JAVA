import java.util.Scanner;

public class Ciclos1{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println("digite la cantidad de notas");
        int n = entrada.nextInt();

        float sumatoria = 0;

        for( int i=1; i<=n; i++){
            System.out.println("digite sus notas" + i);
            float nota = entrada.nextFloat();
            sumatoria = sumatoria + nota;

        }

        float promedio = sumatoria / n;
        System.out.print("su promedio es de " + promedio);
    }
}