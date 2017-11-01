package assignment06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MCompJTester {

	@Test
	public void testCheapest() {
		MComp testObj = MCompTester.makeTest();
		try {
			assertEquals(1.59, MCompTester.cheapest(testObj).getPrice(), 1e-6);
		} catch(AssertionError e) {
			System.out.println("MCompTester's cheapest() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testDearest() {
		MComp testObj = MCompTester.makeTest();
		try {
			assertEquals(4.29, MCompTester.dearest(testObj).getPrice(), 1e-6);
		} catch(AssertionError e) {
			System.out.println("MCompTester's dearest() method failed: " + e.getMessage());
			throw e;
		}
	}
	
	@Test
	public void testLongestDescr() {
		MComp testObj = MCompTester.makeTest();
		try {
			assertEquals("Veggie burger on a whole wheat bun, lettuce, tomato, and fries".length(), MCompTester.longestDescr(testObj).getDescription().length());
		} catch(AssertionError e) {
			System.out.println("MCompTester's longestDescr() method failed: " + e.getMessage());
			throw e;
		}
	}
}
