import java.util.Scanner;

public class CiclosP2{
    public static void main(String [] args){
        Scanner entrada = new Scanner(System.in);
        // algorimtmo para imprimir el dia
        int dia = (int)(Math.random()*31);
        System.out.print(aleatorio);
        // algoritmo para imprimir el mes 
        boolean mes = true;

        while( mes == true){
            int meses = (int)(Math.random()*12);
            if (meses > 0) {
                if (dia == 31 && (meses == 1 || meses == 3 || meses == 5 || meses == 7 || meses == 8 || meses == 10 || meses == 12)){
                    mes = false;
                    
                    // System.out.print(aleatorio + " / " + meses);
                }else if(dia == 30 && (meses == 4 || meses == 6 || meses == 9 || meses == 11)){
                    mes = false;
                }else if(dia == 28 && (meses == 2 )){
                    mes = false;
                }else if (dia < 30){
                    mes = false;
                }
            }
        }

        // algritmo para imprimir el año

        boolean year = true;

        int years;

        while(year == true){
             years = (int)(Math.random()*9999);

             if( years > 999 && years <= 9999){
                year = false;
             }
        }
        if(dia > 0 && dia < 10 && meses > 0 && meses < 10 ){
            System.out.println("0" dia + "/0" + meses + "/" + years);
        }else if(dia > 0 && dia < 10){
            System.out.println("0" + dia "/" + meses + "/" + years);
        }else if(meses > 0 && meses < 10){
            System.out.println(dia + "/0" + meses + "/" + years);
        }else{
            System.out.println(dia + "/" + meses + "/" + years)
        }
    }
}