class Solution {
    public int uniquePaths(int m, int n) {
        // starting in top left, we want to get to bottom right
        // we bfs this
        int[][] dp = new int[n][m];
        for (int i = 0; i < dp.length; i++) dp[i][0] = 1;
        for (int j = 0; j < dp[0].length; j++) dp[0][j] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (i-1 >= 0) dp[i][j] += dp[i-1][j];
                if (j-1 >= 0) dp[i][j] += dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
}