package Main;

import java.util.Random;

public class S�knad {

	protected String id;
	protected String s�ker;
	protected String organisasjon;
	protected String s�knadsType;
	
	// Constructor for s�knad knyttet til organisasjon
	S�knad(String s�ker, String organisasjon) {
		this.s�knadsType = "TILATELSE";
		this.id = genererId();
		this.s�ker = s�ker;
		this.organisasjon = organisasjon;
	}
	
	private String genererId() {
	// genererer en unik id 
		Random r = new Random();
		String id = this.getS�knadsType();
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
		if(this.organisasjon == "") {
			return "Denne s�knaden er ikke knyttet til en organisasjon";
		}
		return organisasjon;
	}
	public void setOrganisasjon(String organisasjon) {
		this.organisasjon = organisasjon;
	}
	
	@Override
	public String toString() {
		return "S�knad [id=" + id + ", s�ker=" + s�ker + ", organisasjon=" + organisasjon + ", s�knadsType="
				+ s�knadsType + "]";
	}

	public String getS�knadsType() {
		return s�knadsType;
	}

	public void setS�knadsType(String s�knadsType) {
		this.s�knadsType = s�knadsType;
	}
	

}
