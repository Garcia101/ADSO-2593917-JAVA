import java.util.Scanner;
public class CiclosP9{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        System.out.print(" Ingrese un numero ");
        long numero=entrada.nextLong();
        boolean calcular=true;
        int problem=0;
        while (calcular){
            //para invertir
            long ult=0;
            long invertido=0;
            while (numero!=0){
                ult = numero%10;
                invertido = (invertido*10)+ult;
                numero = numero/10;
            }
            numero=invertido;
            //numero latino
            problem=0;
            while (numero!=0){
                long finalidad=numero%10;
                numero=numero/10;
                problem+=finalidad;
                System.out.print(finalidad+((numero==0)?" = " :" + "));
            }
            System.out.println(problem);
            if (problem<10) {
                calcular=false;
            }else{
                numero = problem;
            }
        }
    }
}