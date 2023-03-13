import java.util.Scanner;

public class Ejercicio7{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println("ingrese un numero entero de 10 digitos: ");
        int numeroEntero = entrada.nextInt();

        int primerDigito = numeroEntero % 10;
        int segundodigito = (numeroEntero % 100) / 10;
        int tercerDigito = (numeroEntero % 1000) / 100;
        int cuartoDigito = (numeroEntero % 10000) / 1000;
        int quintoDigito = (numeroEntero % 100000) / 10000;
        int sextoDigito = (numeroEntero % 1000000) / 100000;
        int sepitmoDigito = (numeroEntero % 10000000) / 1000000;
        int octavoDigito = (numeroEntero % 100000000) / 10000000;
        int novenoDigito = (numeroEntero % 1000000000) / 100000000;
        int decimoDigito = (numeroEntero % 10000000000) / 1000000000;

        if (numeroEntero == " "){
            int moneda10 = decimoDigito + novenoDigito + octavoDigito + "." + sepitmoDigito + sextoDigito + quintoDigito + "." + cuartoDigito + tercerDigito + segundodigito + "." +primerDigito;
        }
         
        if (numeroEntero == ""){
            int moneda9 = novenoDigito + octavoDigito + sepitmoDigito + "." + sextoDigito + quintoDigito + cuartoDigito + "." + tercerDigito + segundodigito +primerDigito;
        }

        if (numeroEntero == " "){
            int moneda8 = octavoDigito + sepitmoDigito + "." + sextoDigito + quintoDigito + cuartoDigito + "." + tercerDigito + segundodigito + primerDigito;
        }

        if ( numeroEntero == " "){
            int moneda7 = sepitmoDigito + "." + sextoDigito + quintoDigito + cuartoDigito + "." + tercerDigito + segundodigito + primerDigito;
        }

        if (numeroEntero == " "){
            int moneda6 =  sextoDigito + quintoDigito + cuartoDigito + "." + tercerDigito + segundodigito + primerDigito;
        }

        if (numeroEntero == " "){
            int moneda5 = quintoDigito + cuartoDigito + "." + tercerDigito + segundodigito + primerDigito;
        }

        if (numeroEntero == " "){
            int moneda4 = cuartoDigito + "." + tercerDigito + segundodigito + primerDigito;
        }

        if (numeroEntero == " "){
            int moneda3 =  tercerDigito + segundodigito + primerDigito;
        }

        if (numeroEntero == " "){
            int moneda2 =  segundodigito + primerDigito;
        }

        if (numeroEntero == " "){
            int moneda2 =  segundodigito + primerDigito;
        }

        if (numeroEntero == " "){
            int moneda1 =  primerDigito;
        }



    }
}