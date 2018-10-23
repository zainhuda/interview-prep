class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {
          return findMedianSortedArrays(nums2, nums1);
        }
        int imin = 0;
        int imax = m;
        while (imin <= imax) {
            int i = (imin + imax)/2;
            int j = (m+n)/2 - i;
            if (i < m && nums2[j-1] > nums1[i]) {
              imin = i + 1;
            } else if (i > 0 && nums1[i-1] > nums2[j]) {
              imax = i - 1;
            } else {
                double rightSideMin, leftSideMin;
                if (i == m) {
                  rightSideMin = nums2[j];
                } else if (j == n) {
                  rightSideMin = nums1[i];
                } else {
                  rightSideMin = Math.min(nums1[i], nums2[j]);
                }

                // check for even
                if (!((m+n)%2 == 0)) return rightSideMin;

                if (i == 0) {
                  leftSideMin = nums2[j-1];
                } else if (j == 0) {
                  leftSideMin = nums1[i-1];
                } else {
                  leftSideMin = Math.max(nums2[j-1], nums1[i-1]);
                }
                return (leftSideMin + rightSideMin) / 2;
            }
        }
        return 0;
    }
}
