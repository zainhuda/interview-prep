class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length < 1) return 0;
        int rows = matrix.length, cols = matrix[0].length;
        int[][] store = new int[rows+1][cols+1];
        int max = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1') {
                    store[i][j] = Math.min(Math.min(store[i-1][j-1], store[i-1][j]), store[i][j-1])+1;
                    max = Math.max(store[i][j], max);
                }
            }
        }
        return max*max;
    }
}