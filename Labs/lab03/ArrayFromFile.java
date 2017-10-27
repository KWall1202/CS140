package lab03;

import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class ArrayFromFile {
    private int[] array;

    public ArrayFromFile(String filename) {
        // try-with-resources block (sc is the resource we are trying to use)
        try (Scanner sc = new Scanner(new File(filename))) {
            array =  new int[sc.nextInt()];
            for(int i=0; i < array.length; i++) {
                array[i] = sc.nextInt();
            }
        } catch (Exception e) {
            array = new int[0];
        }
    }

    public String toString() {
    return Arrays.toString(array);
    }

    public int[] getArray() {
    return array;
    }

    public void removeOddElements() {
        int count = 0;        
        for (int i : array) {
            if (i % 2 != 0) {
                count++;
            }
        }
        int[] tempArray = new int[array.length - count];
        int index = 0;
        for (int i : array) {
            if (i % 2 == 0) {
                tempArray[index] = i;
                index++;
            }
        }
        array = tempArray;
    }
}
