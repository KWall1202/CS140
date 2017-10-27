package lab05;

import java.util.Arrays;

public class Zipper {
    public static int[] zip(int[] arr1, int[] arr2) {
        if(arr1 == null || arr2 == null || arr1.length != arr2.length) {
            throw new IllegalArgumentException("bad input");
        }
        int[] zippedArray = new int[arr1.length + arr2.length];
        for(int i=0; i < arr1.length; i++) {
            zippedArray[2 * i] = arr1[i];
            zippedArray[2 * i + 1] = arr2[i];
        }
        return zippedArray;
    }
}
