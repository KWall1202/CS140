package exam02;

public class GEQ implements BooleanFunction {
	private int limit;
	
	public GEQ(int limit) {
		this.limit = limit;
	}
	
	@Override
	public boolean apply(int n) {
		return n >= limit;
	}
}
