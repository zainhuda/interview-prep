class moveZerosToLeft{
  static void move_zeros_to_left_in_array(int[] A) {
    // Move all zeros to left of array
    /**
    counter that goes all the way to end of array
    inplace replacement replacing up to the zero, and then add zero to
    starting index
    */
    int count = 0;
    for (int i = 0; i < A.length; i++) {
      if (A[i] == 0 && count > 0) {
        int finish = i - count;
        int start = i;
        while (start != finish) {
          A[start] = A[start-1];
          start--;
        }
        A[finish] = 0;
      }
      count++;
    }
  }
}
