class Solution {
    public int numIslands(char[][] grid) {
        // grid check
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        // out of bounds checking
        int col = grid.length; // vert, y
        int row = grid[0].length; // horiz, x

        // counter
        int islandCount = 0;

        // iterate through horizontally
        for (int i = 0; i < row; i++) {
            // iterate through vertically
            for (int j = 0; j < col; j++) {
                if (grid[j][i] == '1') {
                    // depth first search
                    islandCount++;
                    dfs(grid, i, j);
                }
            }

        }
        return islandCount;
    }

    // change to 0 when visited
    public void dfs(char[][] grid, int row, int col) {
        int Tcol = grid.length; // vert
        int Trow = grid[0].length; // horiz

        if (row >= Trow || col >= Tcol || row < 0 || col < 0 || grid[col][row] == '0') return;

        grid[col][row] = '0';

        dfs(grid, row-1, col);
        dfs(grid, row+1, col);
        dfs(grid, row, col-1);
        dfs(grid, row, col+1);
    }
}
