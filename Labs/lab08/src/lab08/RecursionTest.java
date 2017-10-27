package lab08;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class RecursionTest {

	@Test
	public void testFactorial0() {
		try {
			assertEquals(1, Recursion.factorial(0));
		} catch(AssertionError e) {
			System.out.println("Recursion's factorial() method failed: " + e.getMessage());
			throw e;
		}
	}

	@Test
	public void testFactorial1() {
		try {
			assertEquals(1, Recursion.factorial(1));
		} catch(AssertionError e) {
			System.out.println("Recursion's factorial() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testFactorial5() {
		try {
			assertEquals(120, Recursion.factorial(5));
		} catch(AssertionError e) {
			System.out.println("Recursion's factorial() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testSquareRoot0() {
		try {
			assertEquals(1, Recursion.squareRoot(1), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Recursion's squareRoot() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testSquareRoot81() {
		try {
			assertEquals(9, Recursion.squareRoot(81), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Recursion's squareRoot() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testArrayListSum() {
		ArrayList<Integer> nums = new ArrayList<>();
		nums.add(17);
		nums.add(90);
		nums.add(6);
		try {
			assertEquals(113, Recursion.sum(nums), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Recursion's sum() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testArraySum() {
		try {
			assertEquals(113, Recursion.sum(new int[] {90, 6, 17}), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Recursion's sum() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testBinomialCoefficientKGreaterThanHalfN() {
		try {
			assertEquals(4, Recursion.binomialCoefficient(4, 3), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Recursion's binomialCoefficient() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testBinomialCoefficientKLessThanHalfN() {
		try {
			assertEquals(35, Recursion.binomialCoefficient(7, 3), 1e-6);
		} catch(AssertionError e) {
			System.out.println("Recursion's binomialCoefficient() method failed: " + e.getMessage());
			throw e;
		}
	}
}
