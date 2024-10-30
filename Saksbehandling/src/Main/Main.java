package Main;

public class Main {

	public static void main(String[] args) {
		
		Søknad s1 = new Søknad("Testsøknad", Type.TILATELSE);
		Søknad s2 = new Søknad("TestBed", "NAV", Type.PENGER);
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
	}

}
