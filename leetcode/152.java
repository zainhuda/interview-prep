class Solution {
    public int maxProduct(int[] nums) {
        // sliding window, two pointers
        if (nums.length < 1 || nums == null) return 0;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp = max;
            max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
            min = Math.min(Math.min(tmp*nums[i], min*nums[i]), nums[i]);
            if (max > res) res = max; 
        }
        
        return res;
    }
}