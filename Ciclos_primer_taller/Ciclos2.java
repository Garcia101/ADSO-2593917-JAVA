import java.util.Scanner;

public class Ciclos2{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println("digite cuantas materias son");
        int n = entrada.nextInt();

        float sumatoria = 0;
        float acum_creditos = 0;


        for(int i = 1; i<n; i++){
            System.out.println("digite sus notas" + i);
            float notas = entrada.nextFloat();
            System.out.println("digite la cantidad de creditos que tiene la materia");
            float creditos = entrada.nextFloat();

            sumatoria = sumatoria + creditos;
            acum_creditos = acum_creditos + (notas * creditos);
        }

        float promedio = acum_creditos / sumatoria;
        System.out.println("este es su promedio del semestre " + promedio);
        System.out.println("el total de creditos es" + sumatoria);
    }
}