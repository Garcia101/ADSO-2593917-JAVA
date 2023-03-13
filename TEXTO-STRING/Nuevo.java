import java.util.Scanner;
public class Nuevo {
    public static void main(String[] args) {
        
        // variable de datos.
        Scanner entrada = new Scanner(System.in);

        //pedir texto al usuario.
        System.out.print(" ingrese nombre ");
        String cadena=entrada.nextLine();

        //pruebas
        System.out.println(" => "+cadena);
        System.out.println(" cantidad de letras => "+cadena.length());
        System.out.println(" letra en pos 0 => "+cadena.charAt(0));
        System.out.println(" letra en pos 1 => "+cadena.charAt(1));
        System.out.println(" letra en pos 2 => "+cadena.charAt(2));
        System.out.println(" letra en pos 3 => "+cadena.charAt(3));

        String palabra_1 = "a";
        String palabra_2 = "A";

        System.out.println(" compareTo P1 a P2: "+palabra_1.compareTo(palabra_2));
        System.out.println(" compareTo P2 a P1: "+palabra_2.compareTo(palabra_1));
        System.out.println(" equals P1 a P2: "+palabra_1.equals(palabra_2));
        System.out.println(" equals P2 a P1: "+palabra_2.equals(palabra_1));

        String palabr_1 = "Hola Mundo";
        String palabr_2 = "hola mundo";

        System.out.println(" compareToIgnoreCase P1 a P2: "+palabr_1.compareToIgnoreCase(palabr_2));
        System.out.println(" compareToIgnoreCase P2 a P1: "+palabr_2.compareToIgnoreCase(palabr_1));
        System.out.println(" equalsIgnoreCase P1 a P2: "+palabr_1.equalsIgnoreCase(palabr_2));
        System.out.println(" equalsIgnoreCase P2 a P1: "+palabr_2.equalsIgnoreCase(palabr_1));


    }
    
}
