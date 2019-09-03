import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.*;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static Set<String> getPermutations(String inputString) {

        // generate all permutations of the input string
        if (inputString.length() <= 1) {
            return new HashSet<>(Collections.singletonList(inputString));
        }
        
        
        // inclusive, exclusive
        String chars = inputString.substring(0, inputString.length()-1);
        char last = inputString.charAt(inputString.length()-1);
        
        Set<String> permsChars = getPermutations(chars);
        Set<String> perms = new HashSet<>();
        for (String cha  : permsChars) {
            for (int pos = 0; pos <= chars.length(); pos++) {
                String perm = cha.substring(0, pos) + last + cha.substring(pos);
                perms.add(perm);
            }
        }
        
        return perms;
    }


















    // tests

    @Test
    public void emptyStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList(""));
        final Set<String> actual = getPermutations("");
        assertEquals(expected, actual);
    }

    @Test
    public void oneCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("a"));
        final Set<String> actual = getPermutations("a");
        assertEquals(expected, actual);
    }

    @Test
    public void twoCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("ab", "ba"));
        final Set<String> actual = getPermutations("ab");
        assertEquals(expected, actual);
    }

    @Test
    public void threeCharacterStringTest() {
        final Set<String> expected = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca",
                                                                 "cab", "cba"));
        final Set<String> actual = getPermutations("abc");
        assertEquals(expected, actual);
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