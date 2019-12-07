class Solution {
    int paths = 0;
    int numZeros = 0;
    public int uniquePathsIII(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) numZeros++;
            }
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, i, j, 0);
                    break;
                }
            }
        }
        return paths;
    }
    
    public void dfs(int[][] grid, boolean[][] visited, int i, int j, int count) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == -1 || visited[i][j]) return;
        if (grid[i][j] == 2) {
            System.out.println(count);
            if (count-1 == numZeros) {
                paths++;
            }
            return;
        }
        visited[i][j] = true;
        dfs(grid, visited, i+1, j, count+1);
        dfs(grid, visited, i, j+1, count+1);
        dfs(grid, visited, i-1, j, count+1);
        dfs(grid, visited, i, j-1, count+1);
        visited[i][j] = false;
    }
}