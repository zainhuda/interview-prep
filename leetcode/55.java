class Solution {
    public boolean canJump(int[] nums) {
        // backwards iteatively, top down
        // int array for dp, represents three states
        // 0 unknown, 1 good
        int[] dp = new int[nums.length];
        dp[nums.length-1] = 1;
        for (int i = nums.length-2; i >= 0; i--) {
            int jump = Math.min(nums.length-1, i+nums[i]);
            for (int j = i+1; j <= jump; j++) {
                if (dp[j] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
        }
        return dp[0] == 1;
    }
}