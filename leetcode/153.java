class Solution {
    public int findMin(int[] nums) {
        if (nums.length < 1) return 0;
        // modified binary search can be done in (Ologn)
        int left = 0;
        int right = nums.length-1;
        if (nums[right] > nums[0]) return nums[0];
        while (left < right) {
            int mid = left + (right - left)/2;
            if (left+1 == right) {
                return nums[right];
            }
            if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}