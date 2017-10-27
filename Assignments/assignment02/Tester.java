package assignment02;

import java.util.Arrays;
import java.util.Optional;

public class Tester {
    public static void main(String[] args) {
        // Tests of Utilities02.countNulls(Object[])
        System.out.println("Expected value 0");
        System.out.println(Utilities02.countNulls(null));
        Object[] test = {}; 
        System.out.println("Expected value 0");
        System.out.println(Utilities02.countNulls(test));
        String[] test2 = {"And", "it", null, "goes", "something", null, "like", "this", null};
        System.out.println("Expected value 3");
        System.out.println(Utilities02.countNulls(test2));
        
        // 4 tests of Utilities02.countSpaces(String)
        System.out.println("Expected value -1");
        System.out.println(Utilities02.countSpaces(null));
        System.out.println("Expected value 0");
        System.out.println(Utilities02.countSpaces(""));
        System.out.println("Expected value 0");
        System.out.println(Utilities02.countSpaces("Hello"));
        System.out.println("Expected value 8");
        System.out.println(Utilities02.countSpaces("The quick brown fox jumped over the lazy dog"));
        
        // 4 tests of Utilities02.countSpaces2(String)
        System.out.println("Expected value -1");
        System.out.println(Utilities02.countSpaces(null));
        System.out.println("Expected value 0");
        System.out.println(Utilities02.countSpaces(""));
        System.out.println("Expected value 0");
        System.out.println(Utilities02.countSpaces("Hello"));
        System.out.println("Expected value 8");
        System.out.println(Utilities02.countSpaces("The quick brown fox jumped over the lazy dog"));
        
        // 7 tests of Utilities02.first(String)
        System.out.println("Expected value null");
        System.out.println(Utilities02.first(null));
        System.out.println("Expected value \"\"");
        System.out.println(Utilities02.first(""));
        System.out.println("Expected value \"\"");
        System.out.println(Utilities02.first("        "));
        System.out.println("Expected value \"Kevin\"");
        System.out.println(Utilities02.first(" Kevin "));
        System.out.println("Expected value \"America\"");
        System.out.println(Utilities02.first("America"));
        System.out.println("Expected value \"The\"");
        System.out.println(Utilities02.first(" The quick brown fox jumped over the lazy dog "));
        System.out.println("Expected value \"lorem\"");
        System.out.println(Utilities02.first("lorem ipsum dolor sit amet"));
        
        // 7 tests of Utilities02.rest(String)
        System.out.println("Expected value null");
        System.out.println(Utilities02.rest(null));
        System.out.println("Expected value \"\"");
        System.out.println(Utilities02.rest(""));
        System.out.println("Expected value \"\"");
        System.out.println(Utilities02.rest("        "));
        System.out.println("Expected value \"\"");
        System.out.println(Utilities02.rest(" Kevin "));
        System.out.println("Expected value \"\"");
        System.out.println(Utilities02.rest("America"));
        System.out.println("Expected value \"quick brown fox jumped over the lazy dog\"");
        System.out.println(Utilities02.rest(" The quick brown fox jumped over the lazy dog "));
        System.out.println("Expected value \"ipsum dolor sit amet\"");
        System.out.println(Utilities02.rest("lorem ipsum dolor sit amet"));
        
        // 3 tests of Utilities02.withoutExtraSpaces(String)
        System.out.println("Expected value null");
        System.out.println(Utilities02.withoutExtraSpaces(null));
        System.out.println("Expected value \"America\"");
        System.out.println(Utilities02.withoutExtraSpaces("America"));
        System.out.println("Expected value \"The quick brown fox jumped over the lazy dog\"");
        System.out.println(Utilities02.withoutExtraSpaces(" The  quick   brown    fox     jumped      over       the        lazy         dog "));
        System.out.println("Expected value \"lorem ipsum dolor sit amet\"");
        System.out.println(Utilities02.withoutExtraSpaces("lorem    ipsum  dolor      sit    amet"));
        
        // 3 tests of Utilities02.splitOnSpaces(String)
        System.out.println("Expected value null");
        System.out.println(Arrays.toString(Utilities02.splitOnSpaces(null)));
        System.out.println("Expected value []");
        System.out.println(Arrays.toString(Utilities02.splitOnSpaces("")));
        System.out.println("Expected value [lorem, ipsum, dolor, sit, amet, consectetur, adipiscing, elit, Vivamus, mollis]");
        System.out.println(Arrays.toString(Utilities02.splitOnSpaces("  lorem ipsum dolor sit amet consectetur adipiscing elit Vivamus mollis")));
        
        // 3 tests of Utilities02.strLengths(String)
        System.out.println("Expeced value null");
        System.out.println(Arrays.toString(Utilities02.strLengths(null)));
        System.out.println("Expected value []");
        System.out.println(Arrays.toString(Utilities02.strLengths("")));
        System.out.println("Expected value [5, 5, 5, 3, 4, 11, 10, 4, 7, 6]");
        System.out.println(Arrays.toString(Utilities02.strLengths("lorem ipsum dolor sit amet consectetur adipiscing elit Vivamus mollis")));
        
        // Tests of Utilities02.splitOnSpaces1(String)
        System.out.println("Expeced value \"The input was null or empty\"");
        Optional<String[]> array1 = Utilities02.splitOnSpaces1(null);
        if(array1.isPresent()) {
            System.out.println(Arrays.toString(array1.get()));
        } else {
            System.out.println("The input was null or empty");
        }
        System.out.println("Expeced value \"The input was null or empty\"");
        Optional<String[]> array2 = Utilities02.splitOnSpaces1("");
        if(array2.isPresent()) {
            System.out.println(Arrays.toString(array2.get()));
        } else {
            System.out.println("The input was null or empty");
        }
        System.out.println("Expected value [The, quick, brown, fox, jumped, over, the, lazy, dog]");
        Optional<String[]> array3 = Utilities02.splitOnSpaces1(" The  quick   brown    fox     jumped      over       the        lazy         dog ");
        if(array3.isPresent()) {
            System.out.println(Arrays.toString(array3.get()));
        } else {
            System.out.println("The input was null or empty");
        }
        
        // Creating test objects for InstanceMethodVersion
        InstanceMethodVersion nullString = new InstanceMethodVersion(null);
        InstanceMethodVersion emptyString = new InstanceMethodVersion("");
        InstanceMethodVersion spacesString = new InstanceMethodVersion("           ");
        InstanceMethodVersion singleWordNoSpaces = new InstanceMethodVersion("Hello");
        InstanceMethodVersion singleWordWithSpaces = new InstanceMethodVersion(" Hello ");
        InstanceMethodVersion regularSentenceQBF = new InstanceMethodVersion("The quick brown fox jumped over the lazy dog");
        InstanceMethodVersion regularSentenceLI = new InstanceMethodVersion("lorem ipsum dolor sit amet consectetur adipiscing elit Vivamus mollis");
        InstanceMethodVersion spacedOutSentenceQBF = new InstanceMethodVersion(" The  quick   brown    fox     jumped      over       the        lazy         dog ");
        InstanceMethodVersion spacedOutSentenceLI = new InstanceMethodVersion("lorem    ipsum  dolor      sit    amet");
        
        // Tests of InstanceMethodVersion.countSpaces()
        System.out.println("Expected value -1");
        System.out.println(nullString.countSpaces());
        System.out.println("Expected value 0");
        System.out.println(emptyString.countSpaces());
        System.out.println("Expected value 0");
        System.out.println(singleWordNoSpaces.countSpaces());
        System.out.println("Expected value 8");
        System.out.println(regularSentenceQBF.countSpaces());
        
        // Tests of InstanceMethodVersion.countSpaces2()
        System.out.println("Expected value -1");
        System.out.println(nullString.countSpaces2());
        System.out.println("Expected value 0");
        System.out.println(emptyString.countSpaces2());
        System.out.println("Expected value 0");
        System.out.println(singleWordNoSpaces.countSpaces2());
        System.out.println("Expected value 8");
        System.out.println(regularSentenceQBF.countSpaces2());
        
        // Tests of InstanceMethodVersion.first()
        System.out.println("Expected value null");
        System.out.println(nullString.first());
        System.out.println("Expected value \"\"");
        System.out.println(emptyString.first());
        System.out.println("Expected value \"\"");
        System.out.println(spacesString.first());
        System.out.println("Expected value \"Hello\"");
        System.out.println(singleWordWithSpaces.first());
        System.out.println("Expected value \"Hello\"");
        System.out.println(singleWordNoSpaces.first());
        System.out.println("Expected value \"The\"");
        System.out.println(regularSentenceQBF.first());
        System.out.println("Expected value \"lorem\"");
        System.out.println(regularSentenceLI.first());
        
        // Tests of InstanceMethodVersion.rest()
        System.out.println("Expected value null");
        System.out.println(nullString.rest());
        System.out.println("Expected value \"\"");
        System.out.println(emptyString.rest());
        System.out.println("Expected value \"\"");
        System.out.println(spacesString.rest());
        System.out.println("Expected value \"\"");
        System.out.println(singleWordWithSpaces.rest());
        System.out.println("Expected value \"\"");
        System.out.println(singleWordNoSpaces.rest());
        System.out.println("Expected value \"quick brown fox jumped over the lazy dog\"");
        System.out.println(regularSentenceQBF.rest());
        System.out.println("Expected value \"ipsum dolor sit amet consectetur adipiscing elit Vivamus mollis\"");
        System.out.println(regularSentenceLI.rest());
        
        // Tests of InstanceMethodVersion.withoutExtraSpaces()
        System.out.println("Expected value null");
        System.out.println(nullString.withoutExtraSpaces());
        System.out.println("Expected value \"Hello\"");
        System.out.println(singleWordNoSpaces.withoutExtraSpaces());
        System.out.println("Expected value \"The quick brown fox jumped over the lazy dog\"");
        System.out.println(spacedOutSentenceQBF.withoutExtraSpaces());
        System.out.println("Expected value \"lorem ipsum dolor sit amet\"");
        System.out.println(spacedOutSentenceLI.withoutExtraSpaces());
        
        // Tests of InstanceMethodVersion.splitOnSpaces()
        System.out.println("Expeced value null");
        System.out.println(Arrays.toString(nullString.splitOnSpaces()));
        System.out.println("Expected value []");
        System.out.println(Arrays.toString(emptyString.splitOnSpaces()));
        System.out.println("Expected value [lorem, ipsum, dolor, sit, amet, consectetur, adipiscing, elit, Vivamus, mollis]");
        System.out.println(Arrays.toString(regularSentenceLI.splitOnSpaces()));

        // Tests of InstanceMethodVersionVersion.strLengths()
        System.out.println("Expeced value null");
        System.out.println(Arrays.toString(nullString.strLengths()));
        System.out.println("Expected value []");
        System.out.println(Arrays.toString(emptyString.strLengths()));
        System.out.println("Expected value [5, 5, 5, 3, 4, 11, 10, 4, 7, 6]");
        System.out.println(Arrays.toString(regularSentenceLI.strLengths()));
    }   
}
        