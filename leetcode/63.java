class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // dynamic programming approach baby
        if (obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            if (obstacleGrid[i][0] == 1) break;
            if (obstacleGrid[i][0] != 1) dp[i][0] = 1;
        }
        for (int i = 0; i < obstacleGrid[0].length; i++) {
            if (obstacleGrid[0][i] == 1) break;
            if (obstacleGrid[0][i] != 1) dp[0][i] = 1;
        }
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    // we can't get to this point, thus dp[i][j] = 0 here
                    continue;
                } else {
                    // sum of the paths that come one up and one left, and thats how many unique paths
                    // come to i,j
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}