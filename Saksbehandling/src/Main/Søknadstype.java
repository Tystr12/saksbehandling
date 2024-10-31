package Main;

public enum S�knadstype {
	// Det er mulig � legge til flere s�knadstyper
	PENGER("Penger"), 
	TILATELSE("Tilatelse");
	
	
	private final String beskrivelse;

	S�knadstype(String beskrivelse) {
		this.beskrivelse = beskrivelse;
	}
	
	@Override
	public String toString() {
		return beskrivelse;
	}

}


