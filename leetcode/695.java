class Solution {
    int[][] directions = new int[][] {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int maxArea = Integer.MIN_VALUE;
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    count = 0;
                    dfs(grid, visited, i, j);
                    if (count > maxArea) maxArea = count;
                }
            }
        }
        return maxArea == Integer.MIN_VALUE ? 0 : maxArea;
    }
    
    public void dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) return;
        count++;
        visited[i][j] = true;
        for (int[] direction : directions) {
            dfs(grid, visited, direction[0]+i, direction[1]+j);
        }
    }
}