package exam02;

public class Shopper {
	private double[] purchases;
	
	public Shopper(double[] purchases) {
		this.purchases = purchases;
	}
	
	public double measure() {
		double sum = 0;
		for(double i : purchases) {
			sum += i;
		}
		return sum;
	}
	
	public int value() {
		int ctr = 0;
		for(double i : purchases) {
			if(i > 100) ctr++;
		}
		return ctr;
	}
}
