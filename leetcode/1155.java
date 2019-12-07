class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        // how can we use dp to get to our target sum
        // we for each d, we can have a resulting sum 
        // we can make a matrix of computations we've completed
        // row's are face, columns are number of dice rolled 
        // we can handle some edges cases 
        // if target < f, if target > f && d == 1
        int MOD_NUM = 1000000007;
        int[][] dp = new int[d+1][target+1];
        dp[0][0] = 1;
        for (int i = 1; i <= d; i++) {
            for (int j = 1; j <= target; j++) {
                if (j > i * f) {
                    continue;
                } else {
                    for (int k = 1; k <= j && k <= f; k++) {
                        dp[i][j] = (dp[i][j] + dp[i-1][j-k]) % MOD_NUM;
                    }
                }
            }
        }
        return dp[d][target];
    }
}