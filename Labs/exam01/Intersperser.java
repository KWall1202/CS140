package exam01;

import java.util.Arrays;

public class Intersperser {
    public static int[] intersperse(int[] array, int n) {
        if (array.length == 0) {
            return new int[0];
        }
        int[] returnArray = new int[(2 * array.length) - 1];
        for (int i=0; i < array.length; i++) {
            if (i != array.length - 1) {
                returnArray[2 * i] = array[i];
                returnArray[(2 * i) + 1] = n;
            } else {
                returnArray[2 * i] = array[i];
            }
        }   
        return returnArray;
    }
}
