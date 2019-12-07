class Solution {
    public int maximalRectangle(char[][] matrix) {
        // similar approach as maximal square?
        if (matrix.length == 0) return 0;
        int maxArea = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = j == 0 ? 1 : dp[i][j-1] + 1;
                    int w = dp[i][j];
                    for (int k = i; k >= 0; k--) {
                        w = Math.min(dp[k][j], w);
                        maxArea = Math.max(maxArea, (i-k+1)*w);
                    }
                }
            }
        }
        return maxArea;
    }
}