import java.util.Scanner;

public class Text2 {
    public static void main(String[] args) {
        
        Scanner entrada=new Scanner(System.in);

        System.out.print(" => ingrese una oracion ");
        String intro=entrada.nextLine();


        for (int i = 0; i < intro.length(); i++) {
            int pos = (int)intro.charAt(i);

            if(pos >= 97 && pos <= 122){
                char nuevo = (char)(pos-32);
                System.out.print(nuevo);
            }else if(pos >= 65 && pos <=90){
                char nuevo = (char)(pos+32);
                System.out.print(nuevo);
            }else if(pos ==32){
                char nuevo = (char)(pos=32);
                System.out.print(nuevo); 
            }
            
        }


    }
    
}
