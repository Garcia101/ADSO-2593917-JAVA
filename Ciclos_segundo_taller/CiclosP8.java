import java.util.Scanner;
public class CiclosP8{
    public static void main(String [] args){
        try (Scanner Entrada = new Scanner(System.in)) {
            System.out.print(" Ingrese un numero ");
            int numero=Entrada.nextInt();
            int t1=1;
            for (int i=1;i<=numero;i++) {
                for (int j=1;j<=numero;j++) {
                    if (t1%2==0) {
                        int h=0;
                        while (h<1){
                            int aleatorio=(int)(Math.random()*999);
                            //algoritmo para determinar si el numero es primo
                            int acumulador=0;
                            int b=1;
                            while (b<=aleatorio){
                                if (aleatorio%b==0) {
                                    acumulador++;
                                }
                                b++;
                            }
                            if (acumulador>2) {
                                System.out.print(" "+((aleatorio<10)? "00" : ((aleatorio<100)? "0":""))+aleatorio + " ");
                                h++;
                            }
                        }
                    }else{
                        int h=0;
                        while (h<1) {
                            int aleatorio = (int)(Math.random()*999);
                            //algoritmo para determinar si el numero es primo
                            int acumulador=0;
                            int b=1;
                            while (b<=aleatorio){
                                if (aleatorio%b==0) {
                                    acumulador++;
                                }
                                b++;
                            }
                            if (acumulador==2) {
                                System.out.print(" "+((aleatorio<10)? "00" : ((aleatorio<100)? "0":""))+aleatorio + " ");
                                h++;
                            }
                        }
                    }
                    t1++;
                }
                System.out.println(" ");
            }
        }
    }
}