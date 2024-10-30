package Main;

public enum Type {
	PENGER("Penger"), 
	TILATELSE("Tilatelse");
	
	private final String beskrivelse;

	Type(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
	
	@Override
	public String toString() {
		return beskrivelse;
	}

}


