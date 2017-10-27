package lab04;

import java.util.ArrayList;

public class ArrayListPractice {
    private ArrayList<Integer> arrList = new ArrayList<>();

    public int intRemoveAll(int e) {
        int count = 0;
        for (int i=0; i < arrList.size(); i++) {
            if (arrList.get(i) == e) {
                arrList.remove(i);
                count++;
                i--;
            }
        }
        return count;
    }
    
    public boolean isEqual(ArrayList<Integer> other) {
        boolean returnVal = false;
        if (other != null && arrList.size() == other.size()) {
            returnVal = true;
            for (int i=0; i < arrList.size(); i++) {
                if (!arrList.get(i).equals(other.get(i))) {
                    returnVal = false;
                }
            }
        }
        return returnVal;
    }

    public void appendArray(ArrayList<Integer> arr) {
        if (arr == null) {
            throw new IllegalArgumentException("Cannot append null ArrayList");
        }
        for (int i=0; i < arr.size(); i++) {
            arrList.add(arr.get(i));
        }
    }

    public ArrayList<Integer> sumElementWise(ArrayList<Integer> other) {
        if (other == null || arrList == null) {
            throw new IllegalArgumentException("Cannot add null ArrayList");
        }
        ArrayList<Integer> summedArrList = new ArrayList<>();
        ArrayList<Integer> shortArrList = other;
        ArrayList<Integer> longArrList = arrList;
        if (arrList.size() < other.size()) {
            shortArrList = arrList;
            longArrList = other;
        }
        int i = 0;
        while (i < longArrList.size()) {
            if (i < shortArrList.size()) {
                summedArrList.add(longArrList.get(i) + shortArrList.get(i));
            } else {
                summedArrList.add(longArrList.get(i));
            }
            i++;
        }
        return summedArrList;
    }

    public ArrayList<Integer> getArrayList() {
        return arrList;
    }

// TO DO: DEBUG
}
