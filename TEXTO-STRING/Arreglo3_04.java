import java.util.Scanner;

public class Arreglo3_04 {
    public static void main(String[] args) {
        String[] personas = new String[3];
        String auxiliar = " ";
        String palabra = " ";
        int letra = 0;
        int letra2 = 0;
        String palabra2 = "";
        String [] ordenNombres = new String [3];
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingresa los nombres de las 3 personas:");
        for (int i = 0; i < personas.length; i++) {
            System.out.print("Persona " + (i + 1) + ": ");
            personas[i] = scanner.nextLine();
        }

        for(int i = 0; i < personas.length; i++){
        palabra = personas[i];
        for(int j = i+1;j < personas.length;j++){
            palabra2 = personas[j];
            letra = palabra.charAt(0);
            letra2 = palabra2.charAt(0);
          if(letra > letra2){
            auxiliar = personas[i];
            personas[i] = personas[j];
            personas[j] = auxiliar;
          }
        }
      }
        
        System.out.println("Los nombres de las personas son: ");
        // for (String persona : personas) {
        //     //System.out.println(persona);
        // }

        System.out.println();

        for (int i = 0; i < personas.length; i++){
            System.out.println(personas[i]);
        }
    }

}