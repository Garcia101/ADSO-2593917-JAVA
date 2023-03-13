//ejercicio #01

import java.util.Scanner;

public class Ejercicio1{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        System.out.println("Hola USUARIO");

        System.out.print("ingrese su edad: ");
        int edad = entrada.nextInt();
        if (edad>=1 && edad<=120){
            if (edad >= 18){
                System.out.println("debe un impuesto de 200000");
            }else{
                System.out.println("recibe un auxilio de 800000");
            }
        }else{
            System.out.print("Datos incorrectos.");
        }

    }

}