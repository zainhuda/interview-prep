class Solution {
    int[][] directions = new int[][] {{0,-1}, {-1, 0}, {1,0}, {0, 1}};
    public int longestIncreasingPath(int[][] matrix) {
        // dfs, we only make maths that are increasing, as such we length 
        if (matrix.length < 1) return 0;
        int maxLen = Integer.MIN_VALUE;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxLen = Math.max(maxLen, dfs(matrix, cache, i, j));
            }
        }
        return maxLen;
    }
    
    // bfs
    public int dfs(int[][] matrix, int[][] cache, int i, int j) {
        if (cache[i][j] != 0) return cache[i][j];
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x >= 0 && x <= matrix.length-1 && y >= 0 && y <= matrix[0].length-1 && matrix[i][j] < matrix[x][y]) {
                cache[i][j] = Math.max(cache[i][j], dfs(matrix, cache, x, y));
            }
        }
        return ++cache[i][j];
    }
}