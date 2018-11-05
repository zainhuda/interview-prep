class Solution {
    // extension of house robber
    // use solution we already have
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        // two cases, rob first house, or rob last house
        return Math.max(rob(nums, 0, nums.length-2), rob(nums, 1, nums.length-1));
    }

    private int rob(int[] nums, int low, int high) {
        int previousMax = 0; // f(i-2)
        int currentMax = 0; // f(i-1)
        for (int i = low; i <= high; i++) {
            int temp = currentMax;
            currentMax = Math.max(previousMax + nums[i], currentMax);
            previousMax = temp;
        }
        return currentMax;
    }
}
