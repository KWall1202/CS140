package assignment06P2;

public class Challenge {
	private int[][] array;
	int[] colSums;
	int[] rowSums;
	int diagSum;
	int antiDiagSum;
	
	public Challenge(int[][] array, int[] colSums, int[] rowSums, int diagSum, int antiDiagSum) {
		super();
		this.array = array;
		this.colSums = colSums;
		this.rowSums = rowSums;
		this.diagSum = diagSum;
		this.antiDiagSum = antiDiagSum;
	}
	
	public String view(int[][] arr) {
		String returnVal = "";
		for(int i=0; i < arr.length; i++) {
			returnVal += " \t";
		}
		returnVal += antiDiagSum + "\n";
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr[i].length; j++) {
				returnVal += arr[i][j] + "\t";
			}
			returnVal += rowSums[i] + "\n";
		}
		for(int i : colSums) {
			returnVal += i + "\t";
		}
		returnVal += diagSum + "\n";
		return returnVal;
	}
	
	public int countZeroes(int[][] arr)  {
		int returnVal = 0;
		for(int[] i : arr) {
			for(int j : i) {
				if(j == 0) returnVal++;
			}
		}
		return returnVal;
	}
	
	class Pair {
		int row; int col;
		public Pair(int x, int y) {
			row = x;
			col = y;
		}
	}
	
	public Pair nextZero(int[][] arr) {
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr[i].length; j++) {
				if(arr[i][j] == 0) return new Pair(i, j);
			}
		}
		return new Pair(0,0);
	}
	
	public boolean feasible(int[][] arr) {
		if(Array2Dexamples.antiDiagonalSum(arr) > antiDiagSum) return false;
		if(Array2Dexamples.diagonalSum(arr) > diagSum) return false;
		int[] arrRowSums = Array2Dexamples.rowSums(arr);
		int[] arrColSums = Array2Dexamples.columnSums(arr);
		for(int i=0; i < arr.length; i++) {
			if(arrRowSums[i] > rowSums[i] || arrColSums[i] > colSums[i]) return false;
		}
		return true;
	}
	
	public boolean solved(int[][] arr) {
		if(Array2Dexamples.antiDiagonalSum(arr) != antiDiagSum) return false;
		if(Array2Dexamples.diagonalSum(arr) != diagSum) return false;
		int[] arrRowSums = Array2Dexamples.rowSums(arr);
		int[] arrColSums = Array2Dexamples.columnSums(arr);
		for(int i=0; i < arr.length; i++) {
			if(arrRowSums[i] != rowSums[i] || arrColSums[i] != colSums[i]) return false;
		}
		return true;
	}
	
	private int[][] duplicate(int[][] arr) {
		int[][] returnVal = new int[arr.length][arr.length];
		for(int i=0; i < arr.length; i++) {
			for(int j=0; j < arr[i].length; j++) {
				returnVal[i][j] = arr[i][j];
			}
		}
		return returnVal;
	}
	
	public void solve(int[][] arr) {
		if(countZeroes(arr) > 0) {
			Pair p = nextZero(arr);
			for(int i=1; i <= 9; i++) {
				arr[p.row][p.col] = i;
				if(countZeroes(arr) == 0 && solved(arr)) {
					System.out.println("\nSOLUTION\n" + view(arr));
				}
				if(countZeroes(arr) > 0 && feasible(arr)) {
					solve(duplicate(arr));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Challenge puzzle = new Challenge(new int[][]{{2,0,0,0},{0,0,0,1},{0,5,0,0},{0,0,6,0}},
				new int[]{8,9,15,28}, new int[]{15,11,17,17}, 14, 20);
		System.out.println(puzzle.view(puzzle.array));
		puzzle.solve(puzzle.duplicate(puzzle.array));
	}
}
