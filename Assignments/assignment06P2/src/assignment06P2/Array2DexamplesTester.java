package assignment06P2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Array2DexamplesTester {
	@Test
	public void testRowSums() {
		int[][] test = {{1,7,2,4}, {3,5}, {4,0,2,1,4}};
		try {
			assertArrayEquals(new int[] {14,8,11}, Array2Dexamples.rowSums(test));
		} catch(AssertionError e) {
			System.out.println("Array2Dexamples' rowSums() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testRowSumsEmptyArr() {
		int[][] test = {};
		try {
			assertArrayEquals(new int[] {}, Array2Dexamples.rowSums(test));
		} catch(AssertionError e) {
			System.out.println("Array2Dexamples' rowSums() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testRowSumsEmptyRow() {
		int[][] test = {{1,7,2,4}, {}, {4,0,2,1,4}};
		try {
			assertArrayEquals(new int[] {14,0,11}, Array2Dexamples.rowSums(test));
		} catch(AssertionError e) {
			System.out.println("Array2Dexamples' rowSums() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testColumnSums() {
		int[][] test = {{1,7,2,4}, {3,5}, {4,0,2,1,4}};
		try {
			assertArrayEquals(new int[] {8,12,4,5,4}, Array2Dexamples.columnSums(test));
		} catch(AssertionError e) {
			System.out.println("Array2Dexamples' columnSums() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testColumnSumsEmptyRow() {
		int[][] test = {{1,7,2,4}, {3,5}, {}, {4,0,2,1,4}};
		try {
			assertArrayEquals(new int[] {8,12,4,5,4}, Array2Dexamples.columnSums(test));
		} catch(AssertionError e) {
			System.out.println("Array2Dexamples' columnSums() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testColumnSumsEmptyArr() {
		int[][] test = {};
		try {
			assertArrayEquals(new int[] {}, Array2Dexamples.rowSums(test));
		} catch(AssertionError e) {
			System.out.println("Array2Dexamples' columnSums() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testRowAverages() {
		int[][] test = {{1,7,2,4}, {3,5}, {4,0,2,1,4}};
		try {
			assertArrayEquals(new double[] {3.5,4.0,2.2}, Array2Dexamples.rowAverages(test), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Array2Dexamples' rowAverages() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testRowAveragesEmptyRow() {
		int[][] test = {{1,7,2,4}, {}, {4,0,2,1,4}};
		try {
			assertArrayEquals(new double[] {3.5,0,2.2}, Array2Dexamples.rowAverages(test), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Array2Dexamples' rowAverages() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testRowAveragesEmptyArr() {
		int[][] test = {};
		try {
			assertArrayEquals(new double[] {}, Array2Dexamples.rowAverages(test), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Array2Dexamples' rowAverages() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testColumnAverages() {
		int[][] test = {{1,7,2,4}, {3,5}, {4,0,2,1,4}};
		try {
			assertArrayEquals(new double[] {8.0/3, 4.0, 2.0, 2.5, 4.0}, Array2Dexamples.columnAverages(test), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Array2Dexamples' columnAverages() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testColumnAveragesEmptyRow() {
		int[][] test = {{1,7,2,4}, {3,5}, {}, {4,0,2,1,4}};
		try {
			assertArrayEquals(new double[] {8.0/3, 4.0, 2.0, 2.5, 4.0}, Array2Dexamples.columnAverages(test), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Array2Dexamples' columnAverages() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testColumnAveragesEmptyRows() {
		int[][] test = {{}, {}, {}, {}};
		try {
			assertArrayEquals(new double[] {}, Array2Dexamples.columnAverages(test), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Array2Dexamples' columnAverages() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testColumnAveragesEmptyArr() {
		int[][] test = {};
		try {
			assertArrayEquals(new double[] {}, Array2Dexamples.rowAverages(test), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Array2Dexamples' rowAverages() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testDiagonalSum() {
		int[][] test = {{1,7,2,4}, {3,5,6,1}, {5,5,1,1}, {4,0,2,1}};
		try {
			assertEquals(8, Array2Dexamples.diagonalSum(test));
		} catch(AssertionError e) {
			System.out.println("Array2Dexamples' diagonalSum() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testDiagonalSumNonSquare() {
		int[][] test = {{1,7,2,4}, {3,5,6,1}, {5,5,1,1}, {4,0,2,1}, {}};
		try {
			Array2Dexamples.diagonalSum(test);
			fail("Array2Dexamples' diagonalSum() did not throw an error when given a non-square array");
		} catch(IllegalArgumentException e) {
		}
	}
	
	@Test
	public void testAntiDiagonalSum() {
		int[][] test = {{1,7,2,4}, {3,5,6,1}, {5,5,1,1}, {4,0,2,1,}};
		try {
			assertEquals(19, Array2Dexamples.antiDiagonalSum(test));
		} catch(AssertionError e) {
			System.out.println("Array2Dexamples' antiDiagonalSum() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testAntiDiagonalSumNonSquare() {
		int[][] test = {{1,7,2,4}, {3,5,6,1}, {5,5,1,1}, {4,0,2,1,4}, {}};
		try {
			Array2Dexamples.diagonalSum(test);
			fail("Array2Dexamples' antiDiagonalSum() did not throw an error when given a non-square array");
		} catch(IllegalArgumentException e) {
		}
	}
}
