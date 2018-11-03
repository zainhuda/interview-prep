import java.io.*;
import java.util.*;

class Solution {

  // find the least number of grants we reduce to ensure we
  // are within our budget
  // find the cap the amount
  // if we're above the budget, we look at the difference
  static double findGrantsCap(double[] grantsArray, double newBudget) {
    Arrays.sort(grantsArray);
    double redistribute = newBudget;
    double allocation = newBudget/grantsArray.length; // 38
    for (int i = 0; i < grantsArray.length; i++) {
      if (grantsArray[i] < allocation && i != grantsArray.length-1) {
        redistribute = redistribute - grantsArray[i]; // 190 - 2 == 188
        allocation = redistribute/(grantsArray.length-(i+1)); // 188/(5-1) = 47
      }
    }
    return allocation;
  }

  public static void main(String[] args) {

  }

}
