package Main;

public enum Søknadstype {
	// Det er mulig å legge til flere søknadstyper
	PENGER("Penger"), 
	TILATELSE("Tilatelse");
	
	
	private final String beskrivelse;

	Søknadstype(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
	
	@Override
	public String toString() {
		return beskrivelse;
	}

}


