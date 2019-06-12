class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
       // three pointers, two arrays, one insert
        int insert = m + n - 1;
        int fp = m-1;
        int sp = n-1;
        while (fp >= 0 && sp >= 0) {
            if (nums1[fp] > nums2[sp]) {
                nums1[insert--] = nums1[fp--];
            } else {
                nums1[insert--] = nums2[sp--];
            }
        }
        while (sp >= 0) {
            nums1[insert--] = nums2[sp--];
        }
    }
}