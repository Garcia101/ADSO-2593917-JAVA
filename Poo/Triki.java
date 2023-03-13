import java.util.Scanner;

public class Triki {
    public static void main(String[] args){

        Scanner entradaTexto = new Scanner(System.in);
        Scanner entradaNumeros = new Scanner(System.in);

        char pos = '-';

        char  jugadorX = 'x';
        
        char jugadorO = 'o';

        int JT = 0;

        int jugadasMaximas = 9;

        

        char numerosTablero [] [] = {
          //  0 ,0,1|0,2|0,3|0,4|0,5
            {'_','|','_','|','_','|'},
          // 1,0|1,1|1,2|1,3|,1,4|1,5  
            {'_','|','_','|','_','|'},
          // 2,0|2,1|2,2|2,3|,2,4|2,5
            {'_','|','_','|','_','|'},

        };

        //espacios en juego = 0,0 | 0,2 | 0,4 
        //espacios en juego = 1,0 | 1,2 | 1,4 
        //espacios en juego = 2,0 | 2,2 | 2,4 

        System.out.print("ingrese su nombre jugador 1: ");
        String jugador1 = entradaTexto.nextLine();

        System.out.print("ingrese su nombre jugador 2: ");
        String jugador2 = entradaTexto.nextLine();


      
        
        for(int i = 0; i < numerosTablero.length; i++){
                for(int j = 0; j < numerosTablero[i].length; j++){
                    System.out.print(numerosTablero[i][j]);
                }
                System.out.println(" ");
        }

            
        do{
            if (numerosTablero[0][0] == jugadorX && numerosTablero[0][2] == jugadorX && numerosTablero[0][4] == jugadorX){
                System.out.print("--------------------------");
                System.out.print("jugador x es el ganador: " + jugador1);
                System.out.print("--------------------------");

                break;   
            }

            System.out.println("------------------------------------------");
            System.out.println("||         MENU DE JUEGO :    "+ JT +"  ||");
            System.out.println("||--------------------------------------||");
            System.out.println("||  espacios en juego = 0,0 | 0,2 | 0,4 ||");
            System.out.println("||  espacios en juego = 1,0 | 1,2 | 1,4 ||");
            System.out.println("||  espacios en juego = 2,0 | 2,2 | 2,4 ||");
            System.out.println("------------------------------------------");

            System.out.print("jugador X, haga su jugada: (fila) ");
            int jugador1Fila = entradaNumeros.nextInt();

            System.out.print("jugador X, haga su jugada: (columna) ");
            int jugador1Columna = entradaNumeros.nextInt();

            
            numerosTablero[jugador1Fila][jugador1Columna] = jugadorX;
    

            // if (jugador1Fila == 0 && jugador1Columna == 0){
            //     numerosTablero[jugador1Fila][jugador1Columna] = jugadorX;
            //     JT++;

            // }else if (jugador1Fila == 0 && jugador1Columna == 2){
            //     numerosTablero[jugador1Fila][jugador1Columna] = jugadorX;
            //     JT++;
            // }else if (jugador1Fila == 0 && jugador1Columna == 4){
            //     numerosTablero[jugador1Fila][jugador1Columna] = jugadorX;
            //     JT++;
            // }else if (jugador1Fila == 1 && jugador1Columna == 0){
            //     numerosTablero[jugador1Fila][jugador1Columna] = jugadorX;
            //     JT++;
            // }else if (jugador1Fila == 1 && jugador1Columna == 2){
            //     numerosTablero[jugador1Fila][jugador1Columna] = jugadorX;
            //     JT++;
            // }else if (jugador1Fila == 1 && jugador1Columna == 4){
            //     numerosTablero[jugador1Fila][jugador1Columna] = jugadorX;
            //     JT++;
            // }else if (jugador1Fila == 2 && jugador1Columna == 0){
            //     numerosTablero[jugador1Fila][jugador1Columna] = jugadorX;
            //     JT++;
            // }else if (jugador1Fila == 2 && jugador1Columna == 2){
            //     numerosTablero[jugador1Fila][jugador1Columna] = jugadorX;
            //     JT++;
            // }else if (jugador1Fila == 2 && jugador1Columna == 4){
            //     numerosTablero[jugador1Fila][jugador1Columna] = jugadorX;
            //     JT++;
            // }

            for(int i = 0; i < numerosTablero.length; i++){
                for(int j = 0; j < numerosTablero[i].length; j++){
                     System.out.print(numerosTablero[i][j]);
                }
                System.out.println(" ");
            }

            if (JT >= jugadasMaximas){
                break;
            }

            System.out.println("------------------------------------------");
            System.out.println("||         MENU DE JUEGO :    "+ JT +"  ||");
            System.out.println("||--------------------------------------||");
            System.out.println("||  espacios en juego = 0,0 | 0,2 | 0,4 ||");
            System.out.println("||  espacios en juego = 1,0 | 1,2 | 1,4 ||");
            System.out.println("||  espacios en juego = 2,0 | 2,2 | 2,4 ||");
            System.out.println("------------------------------------------");

            System.out.print("jugador O, haga su jugada: (fila) ");
            int jugador2Fila = entradaNumeros.nextInt();

            System.out.print("jugador O, haga su jugada: (columna) ");
            int jugador2Columna = entradaNumeros.nextInt();

            numerosTablero[jugador2Fila][jugador2Columna] = jugadorO;
            

            // if (jugador2Fila == 0 && jugador2Columna == 0){
            //     numerosTablero[jugador2Fila][jugador2Columna] = jugadorO;
            //     JT++; 
            // }else if (jugador2Fila == 0 && jugador2Columna == 2){
            //     numerosTablero[jugador2Fila][jugador2Columna] = jugadorO;
            //     JT++;
            // }else if (jugador2Fila == 0 && jugador2Columna == 4){
            //     numerosTablero[jugador2Fila][jugador2Columna] = jugadorO;
            //     JT++;
            // }else if (jugador2Fila == 1 && jugador2Columna == 0){
            //     numerosTablero[jugador2Fila][jugador2Columna] = jugadorO;
            //     JT++;
            // }else if (jugador2Fila == 1 && jugador2Columna == 2){
            //     numerosTablero[jugador2Fila][jugador2Columna] = jugadorO;
            //     JT++;
            // }else if (jugador2Fila == 1 && jugador2Columna == 4){
            //     numerosTablero[jugador2Fila][jugador2Columna] = jugadorO;
            //     JT++;
            // }else if (jugador2Fila == 2 && jugador2Columna == 0){
            //     numerosTablero[jugador2Fila][jugador2Columna] = jugadorO;
            //     JT++;
            // }else if (jugador2Fila == 2 && jugador2Columna == 2){
            //     numerosTablero[jugador2Fila][jugador2Columna] = jugadorO;
            //     JT++;
            // }else if (jugador2Fila == 2 && jugador2Columna == 4){
            //     numerosTablero[jugador2Fila][jugador2Columna] = jugadorO;
            //     JT++;
            // }

            for(int i = 0; i < numerosTablero.length; i++){
                for(int j = 0; j < numerosTablero[i].length; j++){
                     System.out.print(numerosTablero[i][j]);
                }
                System.out.println(" ");
            } 

            if (JT >= jugadasMaximas){
                break;
            }

        }while (true); 
 
    }
}