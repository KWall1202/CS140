package exam02;

public class Saver extends Shopper {
	public Saver(double[] purchases) {
		super(purchases);
	}

	@Override
	public double measure() {
		return super.measure() - (value() * 10);
	}
}
