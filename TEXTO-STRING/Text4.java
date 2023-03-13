import java.util.Scanner;
public class Text4 {
    public static void main(String[] args){

        Scanner entrada = new Scanner(System.in);
        int condicion;

        //pedir texto al usuario
        System.out.println("ingrese una palabra");
        String cadena = entrada.nextLine();
        String invertida = "";
    
        for (int i = cadena.length()-1; i >= 0; i--){
            invertida += cadena.charAt(i);
        }

        condicion = cadena.compareToIgnoreCase(invertida);

        if(condicion == 0){
            System.out.println("La palabra es palindromo"); 
        }else{
             System.out.println("!!!NO ES PALINDROMO!!!"); 
        }
    }
}