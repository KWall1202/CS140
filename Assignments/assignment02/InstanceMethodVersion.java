package assignment02;

import java.util.Optional;
import java.util.Arrays;

public class InstanceMethodVersion {
    private String string;
    
    public InstanceMethodVersion(String str) {
        string = str;
    }
    
    public String getString() {
        return string;
    }
    
    public int countSpaces() {
        int count = -1;
        if(string != null) {
            count = 0;
            for (int i=0; i < string.length(); i++) {
                if (string.charAt(i) == ' ') {
                    count++;
                }
            }
        }
        return count;
    }

    public int countSpaces2() {
        int count = -1;
        if (string != null) {
            char[] arr = string.toCharArray();
            count = 0;
            for (int i=0; i < arr.length; i++) {
                if (arr[i] == ' ') {
                    count++;
                }
            }
        }
        return count;
    }
    
    public String first() {
        String returnVal = null;
        if(string != null) {
            returnVal = string.trim();
            int i = returnVal.indexOf(' ');
            if (i >= 0) {
                returnVal = returnVal.substring(0,i);
            }
        }
        return returnVal;
    }
    
    public String rest() {
        String returnVal = null;
        if(string != null) {
            returnVal = string.trim();
            int i = returnVal.indexOf(" ");
            if (i >= 0) {
                returnVal = returnVal.substring(i + 1).trim();
            } else {
                returnVal = "";
            }
        }
        return returnVal;
    }
    
    public String withoutExtraSpaces() {
        String returnVal = null;
        if (string != null) {
            returnVal = string.trim();
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
    
    public String[] splitOnSpaces() {
        String[] returnVal = null;
        InstanceMethodVersion str = new InstanceMethodVersion(withoutExtraSpaces());
        int len = str.countSpaces();
        if (str != null && len >= 0) {
            str = new InstanceMethodVersion(string.trim());
            if (str.first().length() != 0) {
                returnVal = new String[len + 1];
                for(int i=0; i <= len; i++) {
                    returnVal[i] = str.first();
                    str = new InstanceMethodVersion(str.rest());
                }
            } else {
                returnVal = new String[0];
            }
        }        
        return returnVal;
    }
    
    public int[] strLengths() {
        int[] returnVal = null;
        String[] words = splitOnSpaces();
        if (words != null) {
            int len = words.length;
            returnVal = new int[len];
            for (int i=0; i < words.length; i++) {
                returnVal[i] = words[i].length();
            }
        }
        return returnVal;
    }
}