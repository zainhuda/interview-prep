class rotateArray {
  static void rotate_array(List<Integer> arr, int n) {
    n = n % arr.size();
    if (n < 0) {
      n = n + arr.size();
    }
    reverser(arr, 0, arr.size()-1);
    reverser(arr, 0, n-1);
    reverser(arr, n, arr.size()-1);
  }
  static void reverser(List<Integer> arr, int start, int end) {
    while (start < end) {
      int tempVal = arr.get(start);
      arr.set(start, arr.get(end));
      arr.set(end, tempVal);
      start++;
      end--;
    }
  }
}
