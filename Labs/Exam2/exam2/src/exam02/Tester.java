package exam02;

import java.util.Arrays;
import java.util.ArrayList;

import org.junit.Test;

import static org.junit.Assert.*;

public class Tester {
	private static final double DELTA = 1e-6;

    @Test
    public void testLucas() {
        assertEquals(47, Recursion.lucas(8));
    }
    
    @Test
    public void testLucas1() {
        assertEquals(1, Recursion.lucas(1));
    }
    
    @Test
    public void testLucas2() {
        assertEquals(3, Recursion.lucas(2));
    }

    @Test
    public void testCount() {
        assertEquals(1,
                     Recursion.minElement(new ArrayList<>(Arrays.asList(10, 2, 3,
                                                                        4, 1, 5, 11, 6))));
    }
    
    @Test
    public void testMinElementAllRepetition() {
    	assertEquals(3,
    					Recursion.minElement(new ArrayList<>(Arrays.asList(3, 3, 3, 3, 3, 3, 3, 3, 3))));
    }
    
    @Test
    public void testMinElementSomeRepetition() {
    	assertEquals(0,
    					Recursion.minElement(new ArrayList<>(Arrays.asList(3, 3, 1, 6, 6, 0, 3, 3, 3))));
    }

    @Test
    public void testFunctions() {
        Pos p = new Pos();
        assertTrue(p.apply(5));
        GEQ f1 = new GEQ(5);
        assertTrue(f1.apply(10));
        Odd f2 = new Odd();
        assertTrue(f2.apply(3));
    }
    
    @Test
    public void testFunctionsWithZeroes() {
        Pos p = new Pos();
        assertFalse(p.apply(0));
        GEQ f1 = new GEQ(0);
        assertFalse(f1.apply(-1));
        Odd f2 = new Odd();
        assertFalse(f2.apply(0));
    }

    @Test
    public void testFilter() {
        GEQ f1 = new GEQ(5);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> exp = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            list.add(i);
        }
        for (int i = 5; i < 10; i++) {
            list.add(i);
            exp.add(i);
        }
        assertEquals(exp, Filter.filter(list, f1));
    }
    
    @Test
   	public void testQ3() {
           double[] purchases = {120.12, 13.99, 250.37, 101.50, 99.46, 30.10, 100.00, 7.23};
           Shopper shopper = new Shopper(purchases);
           assertEquals(722.77, shopper.measure(), DELTA);
           assertEquals(3, shopper.value());
           Saver saver = new Saver(purchases);
           assertEquals(692.77, saver.measure(), DELTA);
    }
    
    @Test
   	public void testQ3NoDiscounts() {
           double[] purchases = {20.12, 13.99, 50.37, 1.50, 99.46, 30.10, 00.00, 7.23};
           Shopper shopper = new Shopper(purchases);
           assertEquals(222.77, shopper.measure(), DELTA);
           assertEquals(0, shopper.value());
           Saver saver = new Saver(purchases);
           assertEquals(222.77, saver.measure(), DELTA);
    }
    
    @Test
   	public void testQ3AllDiscounts() {
           double[] purchases = {120.12, 113.99, 250.37, 101.50, 199.46, 130.10, 100.01, 107.23};
           Shopper shopper = new Shopper(purchases);
           assertEquals(1122.78, shopper.measure(), DELTA);
           assertEquals(8, shopper.value());
           Saver saver = new Saver(purchases);
           assertEquals(1042.78, saver.measure(), DELTA);
    }
    
    
}