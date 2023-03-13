import java.util.Scanner;

public class EjemploMtz {

    public static void main(String[] args) {
        
        // Declaramos y llenamos la matriz con valores iniciales
        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        
        // Creamos un objeto Scanner para obtener entrada del usuario
        Scanner entrada = new Scanner(System.in);
        
        // Solicitamos al usuario que ingrese la fila y la columna de la matriz que desea cambiar
        System.out.println("Ingrese la fila de la matriz que desea cambiar (0-2): ");
        int fila = entrada.nextInt();
        
        System.out.println("Ingrese la columna de la matriz que desea cambiar (0-2): ");
        int columna = entrada.nextInt();
        
        // Solicitamos al usuario que ingrese el carácter que desea colocar en la posición especificada de la matriz
        System.out.println("Ingrese el caracter que desea colocar en la posición (" + fila + ", " + columna + "): ");
        char caracter = entrada.next().charAt(0);
        
        // Actualizamos el valor de la matriz en la posición especificada con el carácter ingresado por el usuario
        matriz[fila][columna] = caracter;
        
        // Imprimimos la matriz actualizada
        System.out.println("Matriz actualizada: ");
        
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}
