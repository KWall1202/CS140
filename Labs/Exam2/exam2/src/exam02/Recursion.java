package exam02;

import java.util.ArrayList;

public class Recursion {
	public static int lucas(int n) {
		if(n == 1) return  1;
		if(n == 2) return 3;
		return lucas(n-2) + lucas(n-1);
	}
	
	public static int minElement(ArrayList<Integer> list) {
		if(list.size() == 1) return list.get(0);
		return Math.min(list.remove(0), minElement(list));
	}
}
