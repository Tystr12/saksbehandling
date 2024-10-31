package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	
	static ArrayList<S�knad> s�knader = new ArrayList<>();
	static ArrayList<String> organisasjoner = new ArrayList<>(List.of("NAV", "Bufdir", "Forbrukertilsynet"));


	public static void genererS�knader() {
		organisasjoner.add("NAV");
		organisasjoner.add("Bufdir");
		organisasjoner.add("Forbrukertilsynet");
		
		Random rand = new Random();
		System.out.println("------------------------------------------------------------");
		
		for(int i = 0; i < 20; i++) {
			int type = rand.nextInt(2);
			int organisasjon = rand.nextInt(organisasjoner.size());
			switch (type) {
			case 0:
				s�knader.add(new S�knad("Test S�knad", organisasjoner.get(organisasjon)));
				
			break;
			case 1:
				s�knader.add(new PengeS�knad("Test S�knad", organisasjoner.get(organisasjon)));
			break;
			}
			
		}
	}
	
	public static void skrivUtAlle() {
		System.out.println("Penger s�knader:");
		System.out.println("------------------------------------------------------------");
		s�knader.stream()
				.filter(s -> s.getS�knadsType() == "PENGER")
				.forEach(System.out::println);
		System.out.println("Tilatelse s�knader:");
		System.out.println("------------------------------------------------------------");
		s�knader.stream()
				.filter(s -> s.getS�knadsType() == "TILATELSE")
				.forEach(System.out::println);
	}

	public static void main(String[] args) {
		
		genererS�knader();
		skrivUtAlle();
		
		
	}

}
