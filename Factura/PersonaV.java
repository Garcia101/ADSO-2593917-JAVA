public class PersonaV{

	private String cedulavendedores;
	private String nombrevendedores;

	public PersonaV(String cedulavendedores, String nombrevendedores){
		this.cedulavendedores = cedulavendedores;
		this.nombrevendedores = nombrevendedores;
	}

	public String getCedulavendedores(){
		return this.cedulavendedores;
	}

	public String getNombrevendedores(){
		return this.nombrevendedores;
	}

}