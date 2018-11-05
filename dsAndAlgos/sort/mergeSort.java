class MergeSort {
  void sort(int arr[], int left, int right) {
    if (left < right) {
      int middle = (left+right)/2;
      sort(arr, left, middle);
      sort(arr, middle+1, right);
      merge(arr, left, middle, right);
    }
  }

  void merge(int[] arr, int left, int middle, int right) {
    // sizes of the 2 sub arrays to merge
    int n1 = middle - left + 1;
    int n2 = right - middle;

    // create temp arrays
    int LEFT[] = new int[n1];
    int RIGHT[] = new int[n2];

    System.arraycopy(arr, left+0, LEFT, 0, n1);
    for (int j = 0; j < n2; j++) {
      RIGHT[j] = arr[middle+1+j];
    }

    // merging temp arrays
    int i = 0; j = 0;

    int k = left;
    while (i < n1 && j < n2) {
      if (LEFT[i] <= RIGHT[j]) {
        arr[k] = LEFT[i];
        i++;
      } else {
        arr[k] = RIGHT[j];
        j++;
      }
      k++;
    }

    // copy remaining elements
    while (j < n2) {
      arr[k] = RIGHT[j];
      j++;
      k++;
    }
  }
}
