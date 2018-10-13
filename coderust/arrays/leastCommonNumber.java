class leastCommonNumber{
  static int find_least_common_number(int[] arr1, int[] arr2, int[] arr3) {
    int a1 = 0, a2 = 0, a3 = 0;
    while (a1 < arr1.length && a2 < arr2.length && a3 < arr3.length) {
      if (arr1[a1] == arr2[a2] && arr2[a2] == arr3[a3]) return arr1[a1];
      if (arr1[a1] < arr2[a2] && arr1[a1] < arr3[a3]) a1++;
      if (arr2[a2] < arr1[a1] && arr2[a2] < arr3[a3]) a2++;
      if (arr3[a3] < arr1[a1] && arr3[a3] < arr2[a2]) a3++;
    }
    return -1;
  }
}
