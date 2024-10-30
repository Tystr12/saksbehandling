package Main;

import java.util.Random;

public class Søknad {
	private String id;
	private String søker;
	private String organisasjon;
	private boolean harOrganisasjon;
	private Type type;
	
	// Constructor for ingen organisasjon
	Søknad(String søker, Type type) {
		this.type = type;
		this.id = genererId();
		this.søker = søker;
		this.organisasjon = "";
		this.harOrganisasjon = false;
	}
	
	// Constructor for søknad knyttet til organisasjon
	Søknad(String søker, String organisasjon, Type type) {
		this.type = type;
		this.id = genererId();
		this.søker = søker;
		this.organisasjon = organisasjon;
		if(!this.organisasjon.equals("")) {
			this.harOrganisasjon = true;
		}
	}
	
	private String genererId() {
	// genererer en unik id 
		Random r = new Random();
		String id = this.type.toString();
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
		if(this.harOrganisasjon == false) {
			return "Denne søknaden er ikke knyttet til en organisasjon";
		}
		return organisasjon;
	}
	public void setOrganisasjon(String organisasjon) {
		this.organisasjon = organisasjon;
	}
	public boolean isHarOrganisasjon() {
		return harOrganisasjon;
	}
	public void setHarOrganisasjon(boolean harOrganisasjon) {
		this.harOrganisasjon = harOrganisasjon;
	}
	@Override
	public String toString() {
		return "Søknad [id=" + id + ", søker=" + søker + ", organisasjon=" + organisasjon + ", harOrganisasjon="
				+ harOrganisasjon + ", type=" + type + "]";
	}
	

}
