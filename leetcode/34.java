class Solution {
    // Binary search
    public int[] searchRange(int[] nums, int target) {
        int left = findNum(nums, target, true);
        if (left == nums.length || nums[left] != target) {
            return new int[] {-1, -1};
        }
        int right = findNum(nums, target, false)-1;
        return new int[] {left, right};
    }
    
    public int findNum(int[] nums, int target, boolean max) {
        int start = 0;
        int end = nums.length;
        while (end > start) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > target || (max && target == nums[mid])) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}