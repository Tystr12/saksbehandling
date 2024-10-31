package Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	
	static ArrayList<Søknad> søknader = new ArrayList<>();
	static ArrayList<String> organisasjoner = new ArrayList<>(List.of("NAV", "Bufdir", "Forbrukertilsynet"));


	public static void genererSøknader() {
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
				søknader.add(new Søknad("Test Søknad", organisasjoner.get(organisasjon)));
				
			break;
			case 1:
				søknader.add(new PengeSøknad("Test Søknad", organisasjoner.get(organisasjon)));
			break;
			}
			
		}
	}
	
	public static void skrivUtAlle() {
		System.out.println("Penger søknader:");
		System.out.println("------------------------------------------------------------");
		søknader.stream()
				.filter(s -> s.getSøknadsType() == "PENGER")
				.forEach(System.out::println);
		System.out.println("Tilatelse søknader:");
		System.out.println("------------------------------------------------------------");
		søknader.stream()
				.filter(s -> s.getSøknadsType() == "TILATELSE")
				.forEach(System.out::println);
	}

	public static void main(String[] args) {
		
		genererSøknader();
		skrivUtAlle();
		
		
	}

}
