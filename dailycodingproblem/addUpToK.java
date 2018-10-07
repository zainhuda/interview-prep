// given a list of numbers and a number k
// return whether any two numbers from the list add up to k
// if [10, 15, 3, 7]  and k of 17, return true since 10+7 is 17
// bonus: do this in one pass?

import java.util.*;

class Solution {
  public boolean addUpToK(int[] array, int k) {
    // iterate through for each number and see if its component exists
    // O(n^2) sol 0(1) space 
    boolean checked = false;
    for (int i = 0; i < array.length; i++) {
      int find = Math.abs(k-num);
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] == find) {
          checked = true;
          break;
        }
      }
      if (checked) break;
    }
    return checked;

    // how to do this in one pass?
    // can put in hashtable, and then see if it contains x value
    // O(N) space and time complex
    HashMap<Integer, Integer> values = new HashMap<>();
    for (Integer num: array) {
      int value = values.containsKey(num) ? value + 1 : 0;
      values.put(num, value);
    }
    for (int i =  0; i < array.length; i++) {
      int find = Math.abs(k-num);
      if (value.containsKey(find)) {
        checked = true;
        break;
      }
    }
    return checked;
  }

  public static void main(String[] args) {

  }
}
