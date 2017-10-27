package lab08;

public class Bonus {
	public static void printPascalsTriangle(int limit) {
		String currentRow = "";
		for(int n=0; n <= limit; n++) {
			currentRow= "";
			for(int k=0; k <= n; k++) {
				currentRow += " " + Recursion.binomialCoefficient(n, k);
			}
			System.out.println(currentRow);
		}
	}
	
	public static void main(String[] args) {
		printPascalsTriangle(5);
	}
}
