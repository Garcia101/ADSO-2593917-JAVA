import java.util.Scanner;

public class Prueba2{
    public static void main(String [] args){

        //creacion de v(ariable de entrada 
        Scanner entrada = new Scanner(System.in);

        //creacion de variable 
        int cantidad_Poblacion_col = 0;
        int cantidad_Poblacion_usa = 35000000;

        //instruccion de salida 
        System.out.println("la poblacion de colombia es: " + cantidad_Poblacion_col);
        System.out.println("la poblacion de usa es: " + cantidad_Poblacion_usa);

        //lectura de datos

        System.out.print("ingrese poblacion de colombia: ");
        cantidad_Poblacion_col = entrada.nextInt();

        System.out.println("la poblacion de colombia es de: " + cantidad_Poblacion_col);
    }
}