class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean seen = false;
        for (int i : nums) {
            if (i == 1) {
                seen = true;
                break;
            }
        }
        if (!seen) return 1;
        
        if (n == 1) {
            return 2;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > n) nums[i] = 1;
        }
        
        // all ones now we do the bada bing
        for (int i = 0; i < nums.length; i++) {
            int a = Math.abs(nums[i]);
            
            if (a == n) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[a] = - Math.abs(nums[a]);
            }
        }
        
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) return i;
        }
        
        if (nums[0] > 0) {
            return n;
        }
        
        return n+1;

    }
}