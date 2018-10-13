class findLowHigh{
  static int find_low_index(List<Integer> arr, int key) {
    int low = 0;
    int high = arr.size()-1;
    int mid = low + ((high-low)/2);
    while (low <= high) {
      int midNum = arr.get(mid);
      if (midNum >= key) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
      mid = low + ((high-low)/2);
    }
    if (arr.get(low) == key) {
      return low;
    }
    return -1;
  }

  static int find_high_index(List<Integer> arr, int key) {
    int low = 0;
    int high = arr.size()-1;
    int mid = low + ((high-low)/2);
    while (low <= high) {
      int midNum = arr.get(mid);
      if (midNum > key) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
      mid = low + ((high-low)/2);
    }
    if (arr.get(high) == key) {
      return high;
    }
    return -1;
  }
}
