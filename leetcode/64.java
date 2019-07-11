class Solution {
    // dp solution 
    // O(n*n) space (make copy)
    // each spot is a minimum sum to get to that position
    // hence bottom right spot is minimum sum required to get there
    public int minPathSum(int[][] grid) {
        int ylen = grid.length;
        int xlen = grid[0].length;
        
        int[][] res = grid;
        
        for (int x = 0; x < xlen; x++) {
            for (int y = 0; y < ylen; y++) {
                if (x == 0 && y == 0) {
                    res[y][x] = grid[y][x];
                } else {
                    res[y][x] = Math.min(getValue(ylen, xlen, y-1, x, res), getValue(ylen, xlen, y, x-1, res)) + grid[y][x];
                }
            }
        }
        
        return res[ylen-1][xlen-1];
        
    }
    
    // help avoid out of bound conflicts
    public int getValue(int ylen, int xlen, int y, int x, int[][] res) {
        if (y < 0 || y > ylen-1) {
            return Integer.MAX_VALUE;
        } else if (x < 0 || x > xlen-1) {
            return Integer.MAX_VALUE;
        }
        return res[y][x];
    }
    
}