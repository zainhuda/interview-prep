class Solution {
    public int rob(int[] nums) {
        // we tiehr rob i house or i+1 house 
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(robHelper(nums, 0, nums.length-2), robHelper(nums, 1, nums.length-1));
    }
    
    public int robHelper(int[] nums, int low, int high) {
        int i1 = 0, i2 = 0;
        for (int i = low; i <= high; i++) {
            int curr = Math.max(i2 + nums[i], i1);
            // switch i2 and i1
            int temp = i1;
            i1 = curr;
            i2 = temp;
        }
        return i1;
    }
    
}