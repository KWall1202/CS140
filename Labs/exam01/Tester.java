package exam01;

import java.util.Arrays;
import java.util.ArrayList;
import static exam01.PairOperations.*;
import static exam01.RockPaperScissors.*;
import static exam01.Intersperser.*;

public class Tester {
    private static int numWrong;

    public static void main(String[] args) {
        testQ1();
        System.out.println("--------------------");
        testQ2();
        System.out.println("--------------------");
        testQ3();
        System.out.println("--------------------");
        System.out.println(numWrong + " tests failed");
    }

    public static void testQ1() {
    	System.out.println("*********TESTING QUESTION 1********\n");
        testEquality("[1, 0, 2, 0, 3]",
                     intersperse(new int[]{1, 2, 3}, 0));
        testEquality("[1, 0, 2]",
                    intersperse(new int[]{1, 2}, 0));
        testEquality("[1]",
                    intersperse(new int[]{1}, 0));
        testEquality("[1, 4, 2, 4, 3]",
                     intersperse(new int[]{1, 2, 3}, 4));
        testEquality("[]",
                     intersperse(new int[]{}, 4));
    }

    public static void testQ2() {
    	System.out.println("*********TESTING QUESTION 2********\n");
        ArrayList<String> matchResults = new ArrayList<>(Arrays.asList("tied", "won", "lost"));
        ArrayList<String> playerMoves = new ArrayList<>(Arrays.asList("rock", "paper", "paper"));
        deduceOpponentMoves(matchResults, playerMoves);
        testEquality("[rock, rock, scissors]", playerMoves);
        ArrayList<String> mismatchPlayerMoves = new ArrayList<>(Arrays.asList("paper", "scissors"));
        System.out.println("Expecting IllegalArgumentException");
        try {
            deduceOpponentMoves(matchResults, mismatchPlayerMoves);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught the exception: " + e);
        }
        ArrayList<String> incorrectPlayerMoves = new ArrayList<>(Arrays.asList("paper", "scissors", "bloop"));
        System.out.println("Expecting IllegalArgumentException");
        try {
            deduceOpponentMoves(matchResults, incorrectPlayerMoves);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught the exception: " + e);
        }
        ArrayList<String> incorrectMatchResults = new ArrayList<>(Arrays.asList("los", "won", "tied"));
        ArrayList<String> testPlayerMoves = new ArrayList<>(Arrays.asList("rock", "paper", "scissors"));
        System.out.println("Expecting IllegalArgumentException");
        try {
            deduceOpponentMoves(incorrectMatchResults, testPlayerMoves);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught the exception: " + e);
        }
        ArrayList<String> mismatchMatchResults = new ArrayList<>(Arrays.asList("won", "tied"));
        System.out.println("Expecting IllegalArgumentException");
        try {
            deduceOpponentMoves(mismatchMatchResults, testPlayerMoves);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught the exception: " + e);
        }
        System.out.println("Expecting IllegalArgumentException");
        try {
            deduceOpponentMoves(null, testPlayerMoves);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught the exception: " + e);
        }
        System.out.println("Expecting IllegalArgumentException");
        try {
            deduceOpponentMoves(matchResults, null);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught the exception: " + e);
        }
    }

    public static void testQ3() {
    	System.out.println("*********TESTING QUESTION 3********\n");
        ArrayList<Pair> list = PairCollection(new int[] {15,30,25,3}, new int[] {6,11,5,7});
        testEquality("[(15, 6), (30, 11), (25, 5), (3, 7)]", list);
        testEquality(3, lcf(list.get(0).getX(), list.get(0).getY()));
        testEquality(1, lcf(list.get(1).getX(), list.get(1).getY()));
        testEquality(5, lcf(list.get(2).getX(), list.get(2).getY()));
        testEquality(1, lcf(list.get(3).getX(), list.get(3).getY()));
        removeRelPrimePairs(list);
        testEquality("[(15, 6), (25, 5)]", list);
        testEquality(5, findMaxLCF(list));
        System.out.println("Expecting IllegalArgumentException");
        try {
            PairCollection(new int[]{1, 2}, new int[]{1,2,3});
        } catch (IllegalArgumentException e) {
            System.out.println("Caught the exception: " + e);
        }
        System.out.println("Expecting IllegalArgumentException");
        try {
            PairCollection(null, new int[]{1,2,3});
        } catch (IllegalArgumentException e) {
            System.out.println("Caught the exception: " + e);
        }
        System.out.println("Expecting IllegalArgumentException");
        try {
            PairCollection(new int[]{1, 2}, null);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught the exception: " + e);
        }
    }


    private static void testEquality(Object expected, Object actual) {
        if (!expected.toString().equals(actual.toString())) {
            ++numWrong;
            System.out.printf("FAILED: Expected '%s', received '%s'\n",
                              expected.toString(),
                              actual.toString());
        } else {
            System.out.printf("Passed: '%s' == '%s'\n",
                              expected.toString(),
                              actual.toString());
        }
    }

    private static void testEquality(Object expected, int[] actual) {
        testEquality(expected, Arrays.toString(actual));
    }
}
