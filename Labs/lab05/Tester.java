package lab05;

import java.util.Arrays;
import java.util.ArrayList;

public class Tester {
    public static void main(String[] args) {
    	testDivision();
    	testFunWithStrings();
        testZipper();
    }

    public static void testDivision() {
        Division set = new Division(new double[]{1,2,3,0,4,5,0,6,0,7,8,9,0});
        try {
            Division emptySet = new Division(new double[0]);
        } catch(IllegalArgumentException e) {
            System.out.println("Caught: " + e  + "\n");
        }
        try {
            Division nullSet = new Division(null);
        } catch(IllegalArgumentException e) {
            System.out.println("Caught: " + e  + "\n");
        }
        set.removeZeroes();
        System.out.println("Expecting [1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0]");
        System.out.println("Received  " + set + "\n");
        System.out.println("Expecting IllegalArgumentException");
        try {
            set.divide(0);
        } catch(IllegalArgumentException e) {
            System.out.println("Caught: " + e  + "\n");
        }
        set.divide(2);
        System.out.println("Expecting [0.5, 1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5]");
        System.out.println("Received  " + set + "\n");
        
    }

    public static void testFunWithStrings() {
    	ArrayList<String> list1 = new ArrayList<String>(Arrays.asList("to", "cellphone", "truck", "fire"));
    	ArrayList<String> list2 = new ArrayList<String>(Arrays.asList("delicious", "copper", "blue", "red"));
    	ArrayList<String> list3 = new ArrayList<String>(Arrays.asList(null, "yes", "head", "delicious"));
    	ArrayList<String> list4 = new ArrayList<String>(Arrays.asList("graduation", "green", "yellow"));
        String nullString = null;
    	ArrayList<String> list5 = new ArrayList<String>(Arrays.asList(nullString));
    	FunWithStrings.swapMaxes(list1, list2);
        System.out.println("Expecting [to, delicious, truck, fire] [cellphone, copper, blue, red]");
        System.out.println("Received  " + list1 + " " + list2 + "\n");
    	FunWithStrings.swapMaxes(list3, list4);
        System.out.println("Expecting [null, yes, head, graduation] [delicious, green, yellow]");
        System.out.println("Received  " + list3 + " " + list4 + "\n");
    	FunWithStrings.swapMaxes(list5, list4);
        System.out.println("Expecting [null] [delicious, green, yellow]");
        System.out.println("Received  " + list5 + " " + list4 + "\n");
    }

    public static void testZipper() {
        int ret[] = Zipper.zip(new int[]{1, 3, 5, 7}, new int[]{2, 4, 6, 8});
        System.out.println("Expecting [1, 2, 3, 4, 5, 6, 7, 8]");
        System.out.println("Received  " + Arrays.toString(ret)  + "\n");
        System.out.println("Expecting IllegalArgumentException");
        try {
            Zipper.zip(new int[]{1, 2, 3, 4}, new int[]{5, 6, 7});
        } catch(IllegalArgumentException e) {
            System.out.println("Caught: " + e  + "\n");
        }
        System.out.println("Expecting IllegalArgumentException");
        try {
            Zipper.zip(new int[]{1, 2, 3, 4}, null);
        } catch(IllegalArgumentException e) {
            System.out.println("Caught: " + e  + "\n");
        }
        System.out.println("Expecting IllegalArgumentException");
        try {
            Zipper.zip(null, new int[]{1, 3, 5,7});
        } catch(IllegalArgumentException e) {
            System.out.println("Caught: " + e);
        }
        
    }
}
