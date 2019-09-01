import java.util.Arrays;
import java.util.Random;

public class Solution {

    private static Random rand = new Random();

    private static int getRandom(int floor, int ceiling) {
        return rand.nextInt((ceiling - floor) + 1) + floor;
    }

    public static void shuffle(int[] array) {

        // shuffle the input in place
        if (array.length == 1) return;
        
        int index = 0;
        while (index <= array.length-1) {
            int replaceIndex = getRandom(index, array.length-1);
            
            int replaceVal = array[replaceIndex];
            array[replaceIndex] =  array[index];
            array[index] = replaceVal;
            index++;
        }
    }

    public static void main(String[] args) {
        final int[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        final int[] shuffled = Arrays.copyOf(initial, initial.length);
        shuffle(shuffled);
        System.out.printf("initial array: %s\n", Arrays.toString(initial));
        System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled));
    }
}