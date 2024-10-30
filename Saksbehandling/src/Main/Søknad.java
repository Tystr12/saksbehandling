package Main;

import java.util.Random;

public class S�knad {
	private String id;
	private String s�ker;
	private String organisasjon;
	private boolean harOrganisasjon;
	private Type type;
	
	// Constructor for ingen organisasjon
	S�knad(String s�ker, Type type) {
		this.type = type;
		this.id = genererId();
		this.s�ker = s�ker;
		this.organisasjon = "";
		this.harOrganisasjon = false;
	}
	
	// Constructor for s�knad knyttet til organisasjon
	S�knad(String s�ker, String organisasjon, Type type) {
		this.type = type;
		this.id = genererId();
		this.s�ker = s�ker;
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
	public String getS�ker() {
		return s�ker;
	}
	public void setS�ker(String s�ker) {
		this.s�ker = s�ker;
	}
	public String getOrganisasjon() {
		if(this.harOrganisasjon == false) {
			return "Denne s�knaden er ikke knyttet til en organisasjon";
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
		return "S�knad [id=" + id + ", s�ker=" + s�ker + ", organisasjon=" + organisasjon + ", harOrganisasjon="
				+ harOrganisasjon + ", type=" + type + "]";
	}
	

}
