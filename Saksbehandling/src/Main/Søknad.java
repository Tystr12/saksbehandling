package Main;

import java.util.Random;

public class Søknad {

	protected String id;
	protected String søker;
	protected String organisasjon;
	protected String søknadsType;
	
	// Constructor for søknad knyttet til organisasjon
	Søknad(String søker, String organisasjon) {
		this.søknadsType = "TILATELSE";
		this.id = genererId();
		this.søker = søker;
		this.organisasjon = organisasjon;
	}
	
	private String genererId() {
	// genererer en unik id 
		Random r = new Random();
		String id = this.getSøknadsType();
		for(int i = 0; i < 9; i++) {
			int temp = r.nextInt(10);
			String m = Integer.toString(temp);
			id += m;
		}
		
		return id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSøker() {
		return søker;
	}
	public void setSøker(String søker) {
		this.søker = søker;
	}
	public String getOrganisasjon() {
		if(this.organisasjon == "") {
			return "Denne søknaden er ikke knyttet til en organisasjon";
		}
		return organisasjon;
	}
	public void setOrganisasjon(String organisasjon) {
		this.organisasjon = organisasjon;
	}
	
	@Override
	public String toString() {
		return "Søknad [id=" + id + ", søker=" + søker + ", organisasjon=" + organisasjon + ", søknadsType="
				+ søknadsType + "]";
	}

	public String getSøknadsType() {
		return søknadsType;
	}

	public void setSøknadsType(String søknadsType) {
		this.søknadsType = søknadsType;
	}
	

}
