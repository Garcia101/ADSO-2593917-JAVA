import java.util.Scanner;
public class Prueba1 {
    public static void main (String[] args){
        //elemento para entrada por teclado 
        Scanner entrada = new Scanner(System.in);  

        System.out.print("ingrese la base: ");
        int base = entrada.nextInt();

        System.out.print("ingrese a la altura: ");
        int altura = entrada.nextInt();

        int area_rectangulo = base * altura;
        System.out.println("el area es: " + area_rectangulo);

    }
}