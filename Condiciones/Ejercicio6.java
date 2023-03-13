//ejercicio # 07
import java.util.Scanner;

public class Ejercicio6{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println("ingrese un numero entero de 6 digitos: ");
        int numeroEntero = entrada.nextInt();


        System.out.println("menu");
        System.out.println("1:sexto numero, 2:quinto digito, 3:cuarto dgito");
        System.out.println("4:tercer digito, 5:segundo digito, 6:primer digito");
        System.out.println("digite un numero de el menu");
        int opcion = entrada.nextInt();

        if(opcion == 1){
            int primerDigito = numeroEntero % 10;{
                System.out.println("este es el primer digito " + primerDigito);
            }
        }else if (opcion == 2){
            int segundodigito = (numeroEntero % 100) / 10;{
                System.out.println("este es el segundo digito " + segundodigito);
            }
        }else if (opcion == 3){
            int tercerDigito = (numeroEntero % 1000) / 100;{
                System.out.println("este es el tercer digito " + tercerDigito);
            }
        }else if (opcion == 4){
            int cuartoDigito = (numeroEntero % 10000) / 1000;{
                System.out.println("este el cuarto digito " + cuartoDigito);
            }
        }else if (opcion == 5){
            int quintoDigito = (numeroEntero % 100000) / 10000;{
                System.out.println("este es el quinto digito " + quintoDigito);
            }
        }else if (opcion =6){
            int sextoDigito = (numeroEntero % 1000000) / 100000;{
                System.out.println("este el sexto digito " + sextoDigito);
            }
        }
    }
}



