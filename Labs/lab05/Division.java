package lab05;

import java.util.Arrays;
import java.util.ArrayList;

public class Division {
    private ArrayList<Double> list = new ArrayList<>();

    public Division(double[] array) {
        if(array == null || array.length == 0) {
            throw new IllegalArgumentException("need to enter an array with at least one double");
        }
        for(double i : array) {
            list.add(i);        
        }
    }
    
    public void removeZeroes() {
        for(int i=0; i < list.size(); i++) {
            if(list.get(i) == 0) {
                list.remove(i);
                i--;
            }
        }
    }

    public void divide(int divisor) {
        if(divisor == 0) {
            throw new IllegalArgumentException("cannot divide by zero");
        }
        for(int i=0; i < list.size(); i++) {
            list.set(i, list.get(i) / divisor);
        }
    }

    public String toString() {
        return list.toString();
    }
}
