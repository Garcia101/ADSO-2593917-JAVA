public class Principal{
    public static void main(String[] args){

        persona lista [] = new Persona [10];

        lista[0] = new Persona();
        lista[1] = new Persona(108800, "jhon alberth", "aricapa pinto" ,"masculino", 17, 5000, 160);
        lista[2] = new Persona(108801, "juan david ", "monsalve", "masculino");

        lista[0].imprimirCartaPresentacion();
        lista[1].imprimirCartaPresentacion();
        lista[2].imprimirCartaPresentacion();


        //instancia de la clase persona
        // Persona mauricio = new Persona();
        // Persona alberth = new  Persona(108800, "jhon alberth", "aricapa pinto" ,"masculino", 17, 5000, 160);
        // Persona monsalve = new Persona(108801, "juan david ", "monsalve", "masculino");

        mauricio.imprimirCartaPresentacion();
        alberth.imprimirCartaPresentacion();
        monsalve.imprimirCartaPresentacion();

        alberth.comer(850);
        alberth.imprimirCartaPresentacion();
        
    }
}