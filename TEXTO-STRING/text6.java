import java.util.Scanner;

public class Text6 { 
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        //tablero con posiciones de el triqui
        int matriz [] [] = {

            {1,1,1},
            {1,1,1},
            {1,1,1},

        };

        //cantidad de jugadores
        System.out.println("usuario 1 ingrese su nombre");
        String usuario1 = entrada.nextLine();

        System.out.println("usuario 2 ingrese su nombre");
        String usuario2 = entrada.nextLine();

        int inicio; 
        int pos = 0;
        char guardar = 'x'; 

        do {
                System.out.println("presione 1 para iniciar el juego");
                inicio = entrada.nextInt();
                    // menu de inicio de juego
                    for (int i = 0; i < matriz.length; i++){
                        for (int j = 0; j < matriz[i].length; j++){
                            pos = j;
                       
                            if (posicion == 1){
                    
                            guardar = posicion[pos];
                            matriz[pos] = guardar;
                            System.out.print(matriz[i][j]);
                    }
                        }
                    System.out.println("");
                }

                System.out.println("presione un numero dependiendo la posicion");
                int posicion = entrada.nextInt();

        }while (inicio != 0);
    }
}
