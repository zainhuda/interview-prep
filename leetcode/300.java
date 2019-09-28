class Solution {
    public int lengthOfLIS(int[] nums) {
        // On^2 is very easy 
        if (nums == null || nums.length < 1) return 0;
        int size = 0;
        for (int num : nums) {
            int left = 0, right = size;
            while (left != right) {
                int mid = left + (right-left)/2;
                if (num > nums[mid]) {
                    left = mid+1;
                } else {
                    right = mid;
                }
            }
            nums[left] = num;
            if (left == size) size++;
        }
        return size;
    }
}