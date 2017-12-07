package exam02;

public class Odd extends Pos {
	@Override
	public boolean apply(int n) {
		return n % 2 != 0;
	}
}
