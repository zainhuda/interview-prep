class Solution {
    int[][] directions = new int[][] {{0,-1}, {1,0}, {-1,0}, {0,1}};
    public int numDistinctIslands(int[][] grid) {
        // dfs with storing of coordinates
        HashSet<String> set = new HashSet<>(); 
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, sb, i, j, "o");
                    set.add(sb.toString());
                }
            }
        }
        return set.size();
    }
    
    public void dfs(int[][] grid, StringBuilder sb, int i, int j, String s) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) return;
        grid[i][j] = 0;
        sb.append(s);
        dfs(grid, sb, i+1, j, "d");
        dfs(grid, sb, i, j+1, "r");
        dfs(grid, sb, i-1, j, "u");
        dfs(grid, sb, i, j-1, "l");
        sb.append("b");
    }
}