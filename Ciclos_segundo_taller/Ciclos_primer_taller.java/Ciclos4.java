import java.util.Scanner;

public class Ciclos4{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        int opcion = 0;

        while(opcion != 3){
            
        System.out.println("bienvenido");
        System.out.println("1.docente");
        System.out.println("2.estudiante");
        System.out.println("3.salir");
        System.out.println("digite la opcion que quiere");

        opcion = entrada.nextInt();

            if(opcion == 1){
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
            else if(opcion == 2){
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
            else if(opcion == 3){
                System.out.println("salir");
            }else{

            }
        }
    }
}
