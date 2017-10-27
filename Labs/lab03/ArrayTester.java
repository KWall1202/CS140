package lab03;

import java.util.Arrays;

public class ArrayTester {
    public static void main(String[] args) {
        if (args.length == 1) {
            ArrayFromFile test = new ArrayFromFile(args[0]);
            System.out.println("Expecting: [20, 8, 13, 46, 7]");
            System.out.println(test);
            test.removeOddElements();
            System.out.println("Expecting: [20, 8, 46]");
            System.out.println(test);
        } else {
            throw new IllegalArgumentException("ArrayToFile accepts only a single input");
        }
        int[] array = new int[5];
        System.out.println(array);
        System.out.println(Arrays.toString(array));
        int n = 0;
        for (int i : array) {
            i = n;
            n++; // shorthand to increment by 1
        }
        System.out.println(array);
        String[] strs = {"Hi", "my", "name", "is"};
        for (String i : strs) {
            System.out.println(i);
            System.out.println(i.length());
        }
    }
}

