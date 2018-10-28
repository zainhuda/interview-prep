class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] dp = new  int[nums.length];
        dp[0] = 1;
        int longest = 1;
        for (int i = 1; i < dp.length; i++) {
            int largestSeen = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    largestSeen = Math.max(largestSeen, dp[j]);
                }
            }
            dp[i] = largestSeen + 1;
            longest = Math.max(dp[i], longest);
        }
        return longest;
    }
}
