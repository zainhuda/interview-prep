class Solution {
    public int combinationSum4(int[] nums, int target) {
        // similar to coin change
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i-num];
                }
            }
        }
        
        return dp[target];
    }
}