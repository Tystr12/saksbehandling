package Main;

import java.util.Random;

public class PengeS�knad extends S�knad {
	
	private double bel�p;

	PengeS�knad(String s�ker, String organisasjon) {
		super(s�ker, organisasjon);
		this.s�knadsType = "PENGER";
		this.id = genererId();
		this.bel�p = genererBel�p();
		
	}
	
	private double genererBel�p() {
		double[] bel�per = new double[3];
		bel�per[0] = 1000.00;
		bel�per[1] = 200000.00;
		bel�per[2] = 50000.00;
		
		Random random = new Random();
		
		return bel�per[random.nextInt(bel�per.length)];
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
	
	 @Override
	 public String toString() {
	       return super.toString() + ", bel�p=" + bel�p + "]";
	    }

}
