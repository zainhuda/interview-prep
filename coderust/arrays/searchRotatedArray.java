class searchRotated{
  static int binary_search_rotated(int[] arr,int key) {
    return searchRecursive(0, arr.length-1, key, arr);
  }
  static int searchRecursive(int low, int high, int key, int[] arr) {
    if (low > high) {
      return -1;
    }
    int mid = low + ((high-low)/2);
    if (arr[mid] == key) {
      return mid;
    } else if (arr[mid] < arr[high] && arr[high] >= target && arr[mid] < target) {
      return searchRecursive(mid+1, high, key, arr);
    } else if (arr[mid] > arr[low] && arr[low] <= target && arr[mid] > target) {
      return searchRecursive(low, mid-1, key, arr);
    } else if (arr[low] > arr[mid]) {
      return searchRecursive(low, mid-1, key, arr);
    } else if (arr[high] < arr[mid]) {
      return searchRecursive(mid+1, high, key, arr);
    }
    return -1;
  }
}
