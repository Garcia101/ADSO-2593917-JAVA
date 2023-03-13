import java.util.Scanner;

public class Arreglo03_04{
    public static void main(String[]args){
        
        Scanner entrada = new Scanner(System.in);
        //limite del rango impuesto por la persona
        System.out.println("ingrese el limite del arreglo");
        int limite = entrada.nextInt();

        //arreglo 
        String [] personas = new String [limite]; 

        String auxi = "";

        //nombres de las personas
        for (int i = 0; i < limite; i++){
            System.out.println(" ingrese el nombre " + i);
            personas[i] = entrada.next();
        }

        //imprimir arreglo
         for (int i = 0; i < limite; i++){
            System.out.println("[ " + personas[i] + "]");
        }


        //metodo burbuja 
        for (int i = 0; i < limite-1; i++){
            for (int j = 0; j < limite-1; j++){
                
                if (personas[j].compareTo(personas[j+1])>0){
                    auxi = personas[j];
                    personas[j] = personas[j+1];
                    personas[j+1] = auxi;
                }
            }
        }

        //orden alfabetico
        System.out.println("==== orden alfabetico ====");
        for (int i = 0; i < limite; i++){
            System.out.println(" [ " + personas[i] + " ] ");
        }

    }
}