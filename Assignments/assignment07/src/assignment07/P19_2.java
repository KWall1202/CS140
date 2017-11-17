package assignment07;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.stream.Stream;

public class P19_2 {
	public static boolean palindrome(BigInteger n) {
		return new StringBuilder("" + n).reverse().toString().equals("" + n);
	}
	
	public static void main(String[] args) {
		try(PrintWriter output = new PrintWriter("test3.txt")) {
			Stream<BigInteger> stream = Stream.iterate(BigInteger.ONE, (x) -> BigInteger.ONE.add(x));
			stream.map((x) -> x.multiply(x))
				.filter(P19_2::palindrome)
				.limit(90)
				.forEach(output::println);
		} catch(FileNotFoundException e) {}
	}
}
