import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static int highestProductOf3(int[] intArray) {

        // calculate the highest product of three numbers
        // can sort first Onlogn take the three largest and then return
        // can linear scan, if we have an integer larger then one of the three, then we replace it
        int high2 = intArray[0]*intArray[1];
        int low2 = intArray[0]*intArray[1];
        int high = Math.max(intArray[0], intArray[1]);
        int low = Math.min(intArray[0], intArray[1]);
        int res = intArray[0]*intArray[1]*intArray[2];
        for (int x = 2; x < intArray.length; x++) {
            int curr = intArray[x];
            
            res = Math.max(Math.max(curr*high2, curr*low2), res);
            high2 = Math.max(high2, Math.max(curr*high, curr*low));
            low2  = Math.min(low2, Math.min(curr*low, curr*high));
            high = Math.max(high, curr);
            low = Math.min(low, curr);
        }

        return res;
    }


















    // tests

    @Test
    public void shortArrayTest() {
        final int actual = highestProductOf3(new int[] {1, 2, 3, 4});
        final int expected = 24;
        assertEquals(expected, actual);
    }

    @Test
    public void longerArrayTest() {
        final int actual = highestProductOf3(new int[] {6, 1, 3, 5, 7, 8, 2});
        final int expected = 336;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasOneNegativeTest() {
        final int actual = highestProductOf3(new int[] {-5, 4, 8, 2, 3});
        final int expected = 96;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayHasTwoNegativesTest() {
        final int actual = highestProductOf3(new int[] {-10, 1, 3, 2, -10});
        final int expected = 300;
        assertEquals(expected, actual);
    }

    @Test
    public void arrayIsAllNegativesTest() {
        final int actual = highestProductOf3(new int[] {-5, -1, -3, -2});
        final int expected = -6;
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void exceptionWithEmptyArrayTest() {
        highestProductOf3(new int[] {});
    }

    @Test(expected = Exception.class)
    public void exceptionWithOneNumberTest() {
        highestProductOf3(new int[] {1});
    }

    @Test(expected = Exception.class)
    public void exceptionWithTwoNumbersTest() {
        highestProductOf3(new int[] {1, 1});
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