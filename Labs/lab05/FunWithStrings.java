package lab05;

import java.util.ArrayList;

public class FunWithStrings {
    public static void swapMaxes(ArrayList<String> list1, ArrayList<String> list2) {
        String list1Max = null;
        int list1MaxIndex = 0;
        String list2Max = null;
        int list2MaxIndex = 0;
        for(int i=0; i < list1.size(); i++) {
            if(list1Max == null || (list1.get(i) != null && list1.get(i).length() > list1Max.length())) {
                list1Max = list1.get(i);
                list1MaxIndex = i;
            }
        }
        for(int i=0; i < list2.size(); i++) { 
            if(list2Max == null || (list2.get(i) != null && list2.get(i).length() > list2Max.length())) {
                list2Max = list2.get(i);
                list2MaxIndex = i;
            }
        }
        if(list1Max != null && list2Max != null) {
            list1.set(list1MaxIndex, list2Max);
            list2.set(list2MaxIndex, list1Max);
        }
    }
}
