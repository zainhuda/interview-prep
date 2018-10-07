// given array of integers, return a new array such
// that each element of index i of the new array is the product
// of all the numbers in the original array except the one at i
// example
// if input [1,2,3,4,5]
// output is [120,60,40,30,24]
// ex 2
// input [3,2,1]
// output [2,3,6]
// follow up: what if div is not allowed
import java.util.*;
class Solution {
  public int[] productArray(int[] array) {
    // get product of whole array and then divide by given value at index i for result
    // runs in O(n)
    int[] results = new int[array.length];
    int product = 1;
    for (int i = 0; i < array.length; i++) {
      product = product*array[i];
    }
    for (int k = 0; k < results.length; k++) {
      int value = product/array[k];
      results[k] = value;
    }
    return results;
  }

  // if div not allowed
  // recursively find product
  // O(n)? 
  public int[] productArrayNoDiv(int[] array) {
    int[] results = new int[array.length];
    for (int i = 0; i < array.length; i++) {
      int resultOne = productHelper(i+1, i, array[i], array, 1);
      int resultTwo = productHelper(i-1, i, array[i], array, 1);
      results[i] = resultOne*resultTwo;
    }
    return results;
  }

  public int productHelper(int index, int i, int value, int[] array, int product) {
    // out of bounds checking
    if (index > array.length) {
      return product;
    }
    if (index < 0) {
      return product;
    }
    // multiply
    product = product*array[index];

    if (index > i) {
      return productHelper(index+1, i, value, array, product);
    } else {
      return productHelper(index-1, i, value, array, product);
    }
  }

  public static void main(String[] args) {

  }
}
