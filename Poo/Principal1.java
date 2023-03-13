import java.util.Scanner;

public class Principal1{
    public static void main(String[] args){

        Scanner entradaNumero = new Scanner(System.in);
        Scanner entradaTexto = new Scanner(System.in);

        int posDisponible = 0;

        Objetos [] list = new Objetos [10];

        //String [] idenCards = new String [10];

        int cont = 0;

        int aux = 0;

        String safe = "";

        boolean flag = false;

        //Objetos peopleList [] = new Objetos [10]

        do{

            System.out.println("||-------------------------||");
            System.out.println("||-------persons-----------||"); 
            System.out.println("||-------------------------||");
            System.out.println("||---------------" + (cont) + "||");
            System.out.println("||                         ||");
            System.out.println("|| 1. people register      ||");
            System.out.println("|| 2. see list of persons  ||");
            System.out.println("|| 3. sort list of persons ||");
            System.out.println("|| 4. exit                 ||");

            System.out.println("enter 1 if you want to register");
            int enter = entradaNumero. nextInt();

            Objetos objetos = new Objetos();

            switch(enter){

                case 1:
                    System.out.print("enter the identication card: ");
                    String identificationCard = entradaTexto.nextLine();

                    System.out.print("enter the names: ");
                    String name = entradaTexto.nextLine();

                    System.out.print("enter the last names: ");
                    String lastName = entradaTexto.nextLine();

                    System.out.print("enter your adress: ");
                    String address = entradaTexto.nextLine();

                    System.out.print("enter your phone: ");
                    String phone = entradaTexto.nextLine();

                    System.out.print("enter your e-mail: ");
                    String e_mail = entradaTexto.nextLine();
                    
                    Objetos temporal = new Objetos(identificationCard, name, lastName, address, phone, e_mail);
                    boolean valido = true;
                    for(int i = 0; i < cont; i++){
                        if (temporal.getidentificationCard() == list[i].getidentificationCard()){
                            valido = false;
                            System.out.println("el Documento ya existe, no se puede registrar: ");
                            break;
                        }
                    }

                    if (valido){
                        list[cont] = temporal;
                        cont++;
                        System.out.println("registrado con exito: ");
                    }
                break; 

                case 2:
                for(int i = 0; i < list.length; i++){
                    if (list[i] != null){
                        list[i].printSomething();
                    }
                }
                break;

                case 3:

                for (int i = 0; i < list.length; i++){
                    for (int j = 0; j < list.length-1; j++){
                        if (list[j] != null && list[j+1] != null){
                            if (list[j].getidentificationCard() > list[j+1].getidentificationCard()){
                                Objetos aux = list[j];
                                list[j] = list[j+1];
                                list[j+1] = aux;
                            }   
                        }
                    }
                }

                case 4: 
                    flag = true;
                break;
            }
        }while(flag == false);
    }
}