import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int getClosingParen(String sentence, int openingParenIndex) {

        // find the position of the matching closing parenthesis
        int opening = 0;
        for (int pos = openingParenIndex + 1; pos < sentence.length(); pos++) {
            char c = sentence.charAt(pos);
            if (c == '(') {
                opening++;
            }   
            if (c == ')') {
                if (opening == 0) {
                    return pos;
                } else {
                    opening--;
                }
            }
        }
        throw new IllegalArgumentException("error!");
    }


















    // tests

    @Test
    public void allOpenersThenClosersTest() {
        final int expected = 7;
        final int actual = getClosingParen("((((()))))", 2);
        assertEquals(expected, actual);
    }

    @Test
    public void mixedOpenersAndClosersTest() {
        final int expected = 10;
        final int actual = getClosingParen("()()((()()))", 5);
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void noMatchingCloserTest() {
        getClosingParen("()(()", 2);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}