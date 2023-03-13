import java.util.Scanner;

public class CiclosP3{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);

        //System.out.println("ingrese la cantidad de primos que quiere que le aparezcan");
        //int n = entrada.nextInt();

        //int candado = 0;
        int cont = 0;

        // for(int i = 0; i < n ; i++){
        //     int aleatorio = (int)(Math.random()*100);
        //      if(aleatorio % 2 == 1){
        //         cont++;
        //         candado = aleatorio;
            
        //      }
        //     if(cont == 2 ){
        //         System.out.println("el numero " + candado + " es primo");
        //     }else{
        //         if(cont > 2 ){
        //             System.out.println("el numero " + candado + " no es primo");
        //         }
        //     }
        //      //System.out.println("los numeros aleatorios son " + aleatorio);

        // }
        int aleatorio = (int)(Math.random()*100);
        for(int i = 1; i <= aleatorio ; i++){
             if(aleatorio % i == 0){
                cont++;
                // candado = aleatorio;
             }
        }

        if(cont == 2){
            System.out.println("el numero " + aleatorio + " es primo");
        } //else {
        //     System.out.println("el numero " + aleatorio + " no es primo");
        // }
    }
}