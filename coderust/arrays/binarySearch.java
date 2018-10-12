class BinarySearch{
  //a is sorted array
  // RECURSIVE
  static int binSearch(int[] a, int key) {
    return searchRecursive(0, a.length-1, a, key);
  }
  static int searchRecursive(int low, int high, int[] a, int key) {
    if (low > high) {
      return -1;
    }
    int mid = low + ((high-low)/2);
    if (a[mid] == key) {
      return mid;
    } else if (a[mid] > key) {
      return searchRecursive(low, high-1, a, key);
    } else {
      return searchRecursive(low+1, high, a, key);
    }
  }
  // ITERATIVE
  static int binSearch(int[] a, int key) {
    // array is sorted
    int low = 0;
    int high = a.length-1;
    while (low <= high) {
      int mid = low + ((high-low)/2);
      if (a[mid] == key) {
        return mid;
      } else if (a[mid] > key) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return -1;
  }

}
