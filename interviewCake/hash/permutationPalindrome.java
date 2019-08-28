import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.Map;
import java.util.HashMap;

import static org.junit.Assert.*;

public class Solution {

    public static boolean hasPalindromePermutation(String theString) {

        // check if any permutation of the input is a palindrome
        // palindrome to be true, each letter should have multiple of 2 occurences, with one letter only seen once
        char[] charArr = theString.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < charArr.length; i++) {
            int temp = map.getOrDefault(charArr[i], 0)+1;
            map.put(charArr[i], temp);
        }
        
        boolean oddSeen = false;
        for (char ch : map.keySet()) {
            int curr = map.get(ch);
            if (curr % 2 != 0 && oddSeen) return false;
            if (curr % 2 != 0) oddSeen = true;
        }

        return true;
    }


















    // tests

    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabcbcd");
        assertTrue(result);
    }

    @Test
    public void permutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabccbdd");
        assertTrue(result);
    }

    @Test
    public void noPermutationWithOddNumberOfChars() {
        final boolean result = hasPalindromePermutation("aabcd");
        assertFalse(result);
    }

    @Test
    public void noPermutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabbcd");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = hasPalindromePermutation("");
        assertTrue(result);
    }

    @Test
    public void oneCharacterStringTest() {
        final boolean result = hasPalindromePermutation("a");
        assertTrue(result);
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