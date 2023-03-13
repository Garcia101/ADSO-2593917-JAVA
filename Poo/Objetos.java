public class Objetos{
    int identificationCard;
    String name;
    String lastName;
    String address;
    String phone;
    String e_mail;


    public Objetos(){
        this.identificationCard = 0;
        this.name = "";
        this.lastName = "";
        this.address = "";
        this.phone = "0";
        this.e_mail = "";
    }

    public Objetos(int identificationCard, String name, String lastName, String address, String phone, String e_mail){
        this.identificationCard = identificationCard;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.e_mail = e_mail;
    }
    //getters
    public int getidentificationCard(){
        return this.identificationCard;
    }

    public String getname(){
        return this.name;
    }

    public String getlastName(){
        return this.lastName;
    }

    public String getaddress(){
        return this.address;
    }

    public String getphone(){
        return this.phone;
    }

    public String gete_mail(){
        return this.e_mail;
    }

    //setters
    public void setidentificationCard(int newindetificationCard){
        this.identificationCard = newindetificationCard;
    }

    public void setname(String newname){
        this.name = newname;
    }

    public void setlastName(String newlastName){
        this.lastName = newlastName;
    }

    public void setaddress(String newaddress){
        this.address = newaddress;
    }

    public void setphone(String newphone){
        this.phone = newphone;
    }

    public void sete_mail(String newe_mail){
        this.e_mail = newe_mail;
    }
    
    public void printSomething(){
            System.out.println("-------------------------------------");
            System.out.println("--- PEOPLE DATA                      ");
            System.out.println("-------------------------------------");
            System.out.println("|Identification Card: " + this.identificationCard);
            System.out.println("|Name: " + this.name);
            System.out.println("|last Name :" + this.lastName);
            System.out.println("|Adress: " + this.address);
            System.out.println("|Phone: "  + this.phone);
            System.out.println("|E-mail: " + this.e_mail);
            System.out.println("----------------------------"); 
    }
}
