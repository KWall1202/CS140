package lab04;

import java.util.ArrayList;

public class ArrayListPracticeTester {
    public static void main(String[] args) {
        ArrayList<Integer> arrList1 = new ArrayList<>();
        arrList1.add(1);
        arrList1.add(3);
        arrList1.add(5);
        arrList1.add(7);
        arrList1.add(11);
        ArrayListPractice arrListP1 = new ArrayListPractice();
        arrListP1.appendArray(arrList1);
        ArrayList<Integer> arrList2 = new ArrayList<>();
        arrList2.add(1);
        arrList2.add(1);
        arrList2.add(2);
        arrList2.add(3);
        arrList2.add(5);
        arrList2.add(8);
        ArrayListPractice arrListP2 = new ArrayListPractice();
        arrListP2.appendArray(arrList2);
        ArrayList<Integer> arrList3 = new ArrayList<>();
        arrList3.add(1);
        arrList3.add(3);
        arrList3.add(5);
        arrList3.add(7);
        arrList3.add(11);
        ArrayListPractice arrListP3 = new ArrayListPractice();
        arrListP3.appendArray(arrList3);
        ArrayListPractice arrListP4 = new ArrayListPractice();
        System.out.println("Expected: true");
        System.out.println(arrListP1.isEqual(arrListP3.getArrayList()));
        System.out.println("Expected: true");
        System.out.println(arrListP1.isEqual(arrListP1.getArrayList()));
        System.out.println("Expected: true");
        System.out.println(arrListP4.isEqual(arrListP4.getArrayList()));
        System.out.println("Expected: false");
        System.out.println(arrListP4.isEqual(arrListP3.getArrayList()));
        System.out.println("Expected: false");
        System.out.println(arrListP1.isEqual(arrListP2.getArrayList()));
        System.out.println("Expected: false");
        System.out.println(arrListP1.isEqual(arrListP4.getArrayList()));
        System.out.println("Expected: [2, 4, 7, 10, 16, 8]");
        System.out.println(arrListP1.sumElementWise(arrListP2.getArrayList()));
        System.out.println("Expected: [2, 6, 10, 14, 22]");
        System.out.println(arrListP1.sumElementWise(arrListP3.getArrayList()));
        System.out.println("Expected: [1, 3, 5, 7, 11, 1, 1, 2, 3, 5, 8]");
        arrListP1.appendArray(arrList2);
        System.out.println(arrListP1.getArrayList());
        System.out.println("Expected: 2");
        System.out.println(arrListP2.intRemoveAll(1));
        System.out.println("Expected: 0");
        System.out.println(arrListP3.intRemoveAll(10));
        System.out.println("Expected: 0");
        System.out.println(arrListP4.intRemoveAll(10));
        System.out.println("Expected: [2, 3, 5, 8]");               
        System.out.println(arrListP2.getArrayList());
        System.out.println("Expected IllegalArgumentException");
        try {
            arrListP1.appendArray(arrListP4.getArrayList());
        } catch (Exception e) {
            System.out.println("Caught the IllegalArgumentException");
        }
        System.out.println("Expected IllegalArgumentException");
        try {
            arrListP1.sumElementWise(arrListP4.getArrayList());
        } catch (Exception e) {
            System.out.println("Caught the IllegalArgumentException");
        }
        System.out.println("Expected IllegalArgumentException");
        try {
            arrListP4.sumElementWise(arrListP1.getArrayList());
        } catch (Exception e) {
            System.out.println("Caught the IllegalArgumentException");
        }
    }

}
