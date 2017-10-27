package assignment02;

import java.util.Optional;
import java.util.Arrays;

public class Utilities02 {
    public static int countNulls(Object[] array) {
        int numNulls = 0;
        if (array == null) {
            return numNulls;
        } else if (array.length != 0) {
            for (Object ref : array) {
                if(ref == null) {
                    numNulls++;
                }
            }
        }
        return numNulls;    
    }
    
    public static int countSpaces(String str) {
        int count = -1;
        if(str != null) {
            count = 0;
            for (int i=0; i < str.length(); i++) {
                if (str.charAt(i) == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    public static int countSpaces2(String str) {
        int count = -1;
        if (str != null) {
            char[] arr = str.toCharArray();
            count = 0;
            for (int i=0; i < arr.length; i++) {
                if (arr[i] == ' ') {
                    count++;
                }
            }
        }
        return count;
    }
    
    public static String first(String str) {
        String returnVal = null;
        if(str != null) {
            returnVal = str.trim();
            int i = returnVal.indexOf(' ');
            if (i >= 0) {
                returnVal = returnVal.substring(0,i);
            }
        }
        return returnVal;
    }
    
    public static String rest(String str) {
        String returnVal = null;
        if(str != null) {
            returnVal = str.trim();
            int i = returnVal.indexOf(" ");
            if (i >= 0) {
                returnVal = returnVal.substring(i + 1).trim();
            } else {
                returnVal = "";
            }
        }
        return returnVal;
    }
    
    public static String withoutExtraSpaces(String str) {
        String returnVal = null;
        if (str != null) {
            returnVal = str.trim();
            int len1 = 0;
            int len2 = 0;
            do {
                len1 = returnVal.length();
                returnVal = returnVal.replace("  ", " ");
                len2 = returnVal.length();
            } while (len2 < len1);
        }
        return returnVal;
    }
    
    public static String[] splitOnSpaces(String str) {
        String[] returnVal = null;
        int len = countSpaces(withoutExtraSpaces(str));
        if (str != null && len >= 0) {
            if (str.length() != 0) {
                returnVal = new String[len + 1];
                for(int i=0; i <= len; i++) {
                    returnVal[i] = first(str);
                    str = rest(str);
                }
            } else if (str.length() == 0) {
                returnVal = new String[0];
            }
        }        
        return returnVal;
    }
    
    public static int[] strLengths(String str) {
        int[] returnVal = null;
        String[] words = splitOnSpaces(str);
        if (words != null) {
            int len = words.length;
            returnVal = new int[len];
            for (int i=0; i < len; i++) {
                returnVal[i] = words[i].length();
            }
        }
        return returnVal;
    }
    
    public static Optional<String[]> splitOnSpaces1(String str) {
        String[] returnVal = null;
        if (str != null && str.trim().length() > 0) {
            returnVal = new String[countSpaces(withoutExtraSpaces(str)) + 1];
            int index = 0;
            while (str.length() != 0) {
                returnVal[index] = first(str);
                str = rest(str);
                index++;
            }
            returnVal = Arrays.copyOf(returnVal, index);
        return Optional.of(returnVal);
        } else {
            return Optional.empty();
        }
    }
}