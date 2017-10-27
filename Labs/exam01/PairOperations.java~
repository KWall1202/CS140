package exam01;

import java.util.ArrayList;
import java.util.Arrays;

public class PairOperations {
    public static ArrayList<Pair> PairCollection(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null || arr1.length != arr2.length) {
            throw new IllegalArgumentException("arrays must be non-null and the same length");
        }
        ArrayList<Pair> retVal = new ArrayList<>();
        for (int i=0; i < arr1.length; i++) {
            retVal.add(new Pair(arr1[i], arr2[i]));
        }
        return retVal;
    }
	
    //Calculates the largest common factor between two integers given as input
	//Example: The largest common factor of 30 and 42 is 6, 
	//since 30 = 2*3*5 and 42 = 2*3*7, and we see 2*3 is the largest factor
	//which appears in both prime factorizations of 30 and 42. 
	//If the lcf between two numbers is 1, we say that the two numbers
	//are relatively prime to one another.
	public static int lcf(int x, int y) {
        if(x == 0 || y == 0) throw new IllegalArgumentException("arguments must be non- zero");
        if(x < 0) x = -x;
        if(y < 0) y = -y;
        while(x != y) {
            while(x > y) x = x-y;
            while(y > x) y = y-x;
        }
        return x;
    }
    
    public static void removeRelPrimePairs(ArrayList<Pair> list) {
        for (int i=0; i < list.size(); i++) {
            int x = list.get(i).getX();
            int y = list.get(i).getY();
            if (lcf(x, y) == 1) {
                list.remove(i);
                i--;
            }
        }
    }

    public static int findMaxLCF(ArrayList<Pair> list) {
        int maxLCF = 0;
        Pair p = new Pair(0, 0);
        for (Pair i : list) {
            int tempLCF = lcf(i.getX(), i.getY());
            if (tempLCF > maxLCF) {
                maxLCF = tempLCF;
                p = i;
            }
        }
        System.out.println(p);
        return maxLCF;
    }
}
