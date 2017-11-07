package assignment06P2;

import java.util.Arrays;

public class Array2Dexamples {
	/**
	 * Returns an array where the i-th element is the sum
	 * of the elements in the i-th row of arr.
	 * @param arr possibly ragged array of ints
	 * @return the sums of each row in a 1-dimensional array
	 */
	public static int[] rowSums(int[][] arr) {
		int[] returnVal = new int[arr.length];
		for(int i=0; i < arr.length; i++) {
			int sum = 0;
			for(int j=0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
			returnVal[i] = sum;
		}
		return returnVal;
	}
	
	/**
	 * Returns an array where the i-th element is the sum of
	 * the elements in the i-th column of arr. The length of 
	 * the return array is the maximum length of any row of arr.
	 * The sum for the i-th column only includes elements from 
	 * rows that have an element in the i-th column.
	 * @param arr possibly ragged array of ints
	 * @return the sums of the columns in a 1-dimensional array
	 */
	public static int[] columnSums(int[][] arr) {
		int maxRowLength = 0;
		for(int i=0; i < arr.length; i++) {
			if(arr[i].length > maxRowLength) maxRowLength = arr[i].length;
		}
		int[] returnVal = new int[maxRowLength];
		for(int j=0; j < maxRowLength; j++) {
			for(int i=0; i < arr.length; i++) {
				if(arr[i].length > j) returnVal[j] += arr[i][j];
			}
		}
		return returnVal;
	}
	
	/**
	 * Returns an array where the i-th element is the average
	 * of the elements in the i-th row of arr.
	 * If a row is an empty array, the average is 0.
	 * @param arr possibly ragged array of ints
	 * @return the averages of each row in a 1-dimensional array
	 */
	public static double[] rowAverages(int[][] arr) {
		int[] rowSums = rowSums(arr);
		double[] returnVal = new double[arr.length];
		for(int i=0; i  < arr.length; i++) {
			if(arr[i].length != 0) returnVal[i] = (double)rowSums[i] / arr[i].length;
		}
		return returnVal;
	}
	
	/**
	 * Returns an array where the i-th element is the average of
	 * the elements in the i-th column of arr. The length of 
	 * the return array is the maximum length of any row of arr.
	 * The average for the i-th column only includes elements from 
	 * rows that have an element in the i-th column. You must
	 * get the sum and the count of the elements that appear in
	 * the i-th column in order to take the average.
	 * @param arr possibly ragged array of ints
	 * @return the averages of each columns in a 1-dimensional array
	 */
	public static double[] columnAverages(int[][] arr) {
		int[] columnSums = columnSums(arr);
		double[] returnVal = new double[columnSums.length];
		Arrays.fill(returnVal,  0);
		for(int j=0; j < columnSums.length; j++) {
			int numElementsInColumn = 0;
			for(int i=0; i < arr.length; i++) {
				if(arr[i].length > j) numElementsInColumn++;
			}
			returnVal[j] = (double)columnSums[j] / numElementsInColumn;
		}
		return returnVal;
	}
	
	 /**
	 * Returns the sum of the elements on the main diagonal:
	 * arr[0][0], arr[1][1], arr[2][2], ... arr[n][n], 
	 * where n = arr/length - 1. 
	 * @param arr a square array of int
	 * @return the sum of the elements on the main diagonal
	 * @throws IllegalArgumentException if arr is null or if
	 * any row is null or has a length different from the number of rows
	 */
	public static int diagonalSum(int[][] arr) {
		if(arr == null) throw new IllegalArgumentException("Cannot take the diagonal sum of a null array");
		int returnVal = 0;
		for(int i=0; i < arr.length; i++) {
			if(arr[i] == null || arr[i].length != arr.length) throw new IllegalArgumentException("Cannot take the diagonal sum of an array with null contents or a non-square array");
			returnVal += arr[i][i];
		}
		return returnVal;
	}
	
	/**
	 * Returns the sum of the elements on the main anti-diagonal:
	 * arr[n][0], arr[n-1][1], arr[n-2][2], ... arr[0][n], 
	 * where n = arr/length - 1. 
	 * @param arr a square array of int
	 * @return the sum of the elements on the main anti-diagonal
	 * @throws IllegalArgumentException if arr is null or if
	 * any row is null or has a length different from the number of rows
	 */
	public static int antiDiagonalSum(int[][] arr) {
		if(arr == null) throw new IllegalArgumentException("Cannot take the anti-diagonal sum of a null array");
		int returnVal = 0;
		int j = arr.length - 1;
		for(int i=0; i < arr.length; i++) {
			if(arr[i] == null || arr[i].length != arr.length) throw new IllegalArgumentException("Cannot take the anti-diagonal sum of an array with null contents or a non-square array");
			returnVal += arr[i][j];
			j--;
		}
		return returnVal;
	}
}
