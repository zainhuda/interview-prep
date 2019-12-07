//  useful link
// https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
class Solution {
    public int rob(int[] nums) {
        // dp either continue to rob house-2 or start with house-1;
        // we keep a max of the money we've stolen so far
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];
    }
}
