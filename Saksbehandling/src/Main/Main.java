package Main;

public class Main {

	public static void main(String[] args) {
		
		S�knad s1 = new S�knad("Tests�knad", Type.TILATELSE);
		S�knad s2 = new S�knad("TestBed", "NAV", Type.PENGER);
		
		System.out.println(s1.toString());
		System.out.println(s2.toString());
	}

}
