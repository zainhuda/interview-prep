// find_sum_of_two function return true if
// there are two values in array who
// sum to value and returns false otherwise
class findSum{
  static boolean find_sum_of_two(int[] A, int val) {
    HashMap<Integer, Integer> hold = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      int target = val - A[i];
      if (hold.containsKey(target)) {
        return true;
      }
      hold.put(A[i], i);
    }
    return false;
  }
}
