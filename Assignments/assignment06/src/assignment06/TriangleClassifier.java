package assignment06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TriangleClassifier {
	private static String[] triDesc = {"Equilateral Triangle", "Acute-angled Isosceles Triangle", "Obtuse-angled Isosceles Triangle", "Acute-angled Scalene Triangle", "Right-angled Scalene Triangle", "Obtuse-angled Scalene Triangle"};
	private static Map<String, Integer> number = new HashMap<>();
	
	static {
		for(int i=0; i < triDesc.length; i++) {
			number.put(triDesc[i], i);
		}
	}
	
	public static String classify(int a, int b, int c) {
		if(a == 0 || b == 0 || c == 0 || a + b <= c || a + c <= b || b + c <= a) {
			throw new IllegalArgumentException("Invalid Triangle (" + a + ", " + b + ", " + c + ")");
		}
		if(a == b && a == c) return triDesc[0];
		if((a == b && c*c < a*a + b*b) || (a == c && b*b < a*a + c*c) || (b == c && a*a < b*b + c*c)) return triDesc[1];
		if((a == b && c*c > a*a + b*b) || (b == c && a*a > b*b + c*c) || (a == c && b*b > a*a + c*c)) return triDesc[2];
		if(a*a < b*b + c*c && b*b < a*a + c*c && c*c < a*a + b*b) return triDesc[3];
		if(a*a == b*b + c*c || b*b == a*a + c*c || c*c == a*a + b*b) return triDesc[4];
		return triDesc[5];
	}
	
	public static class Triple implements Comparable<Triple> {
		private int a;
		private int b;
		private int c;
		
		public String toString() {
			return classify(a, b, c);
		}
		
		public int compareTo(Triple arg0) {
			return  number.get(toString()) - number.get(arg0.toString());
		}
	}
	
	public static Triple createTriple(int a, int b, int c) {
		Triple triple = new Triple();
		triple.a = a;
		triple.b = b;
		triple.c = c;
		return triple;
	}
	
	public static void removeScalene(ArrayList<Triple> list) {
		Iterator<Triple> iter = list.iterator();
		while(iter.hasNext()) {
			Triple t = iter.next();
			if(t.toString().contains("Scalene")) {
				iter.remove();
			}
		}
	}
}
