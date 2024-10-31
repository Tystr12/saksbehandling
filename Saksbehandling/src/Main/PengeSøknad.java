package Main;

import java.util.Random;

public class PengeSøknad extends Søknad {
	
	private double beløp;

	PengeSøknad(String søker, String organisasjon) {
		super(søker, organisasjon);
		this.søknadsType = "PENGER";
		this.id = genererId();
		this.beløp = genererBeløp();
		
	}
	
	private double genererBeløp() {
		double[] beløper = new double[3];
		beløper[0] = 1000.00;
		beløper[1] = 200000.00;
		beløper[2] = 50000.00;
		
		Random random = new Random();
		
		return beløper[random.nextInt(beløper.length)];
	}
	
	private String genererId() {
		// genererer en unik id 
			Random r = new Random();
			String id = this.getSøknadsType();
			for(int i = 0; i < 9; i++) {
				int temp = r.nextInt(10);
				String m = Integer.toString(temp);
				id += m;
			}
			
			return id;
		}
	
	 @Override
	 public String toString() {
	       return super.toString() + ", beløp=" + beløp + "]";
	    }

}
