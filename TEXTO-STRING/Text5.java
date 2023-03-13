import java.util.Scanner;

public class Text5 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        // pedir texto al usuario
        char comparar;

        System.out.println("ingrese nombre de jugador");
        String cadena = entrada.nextLine();
        char[] palabraSecreta = { 'g', 'o', 'k', 'u' };
        char[] guionesBajos = { '_', '_', '_', '_' };

        int vidas = 5;
        int iniciar;
        int pos = 0;

        // Bands
        boolean guardar = false;
        boolean error = false;
        char guardarLetra = 'a';


        do {
            System.out.println("presione 1 para iniciar o presione 0 para salir");
            iniciar = entrada.nextInt();

        } while (iniciar != 1);

        // System.out.println("muy god");
        // int canti = entrada.nextLine();

        // vidas del jugador
        do {
            System.out.println("===== Vidas: "+vidas+" ====="); System.out.println();
            System.out.println("ingrese una letra");
            comparar = entrada.next().charAt(0);
            // recorriendo la palabra secreta
            for (int j = 0; j < palabraSecreta.length; j++) {

                if (comparar == palabraSecreta[j]) {
                    System.out.println("correcto");
                    // guardando posiciones de la coincidencia
                    pos = j;
                    // guardando la letra
                    guardarLetra = palabraSecreta[pos];
                    // bandera para abrir puerta a la siguiente posicion
                    guardar = true;
                    error = true;
                    break;
                   
                }
            }

            if(error == false){
                System.out.println("letra equivocada");
                vidas--;
            }

            // error = true;

            // darle espacios al array
            for (int p = 0; p < palabraSecreta.length; p++) {
                if (guardar == true) {
                    // intercambio de guion a la letra
                    guionesBajos[pos] = guardarLetra;
                }

                System.out.print(guionesBajos[p]);
                System.out.print(" ");
            }
            System.out.println();
            // System.out.print(guionesBajos);
        } while (vidas >= 1);
    }
}