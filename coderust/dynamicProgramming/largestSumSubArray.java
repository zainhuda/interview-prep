class largestSum{
  static int find_max_sum_sub_array(int[] A) {
    int current = A[0];
    int max = A[0];
    for (int i = 0; i < A.length; i++) {
      if (current < 0) {
        current  = A[i];
      } else {
        current += A[i];
      }

      if (max < current) {
        max = current;
      }
    }
    return max;
  }
}
