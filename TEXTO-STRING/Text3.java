import java.util.Scanner;

public class Text3 {
    public static void main(String[] args) {
        
        Scanner entrada=new Scanner(System.in);

        System.out.print(" => ingrese una oracion ");
        String intro=entrada.nextLine();

        for (int i = intro.length()-1; i >= 0 ; i--){
            System.out.println(intro.charAt(i));
        }

    }

    
}

