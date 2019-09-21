class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // dfs, we send it down left and up and right and down 
        // can we generalize the dfs?
        // do inside out
        // two boolean arrays? 
        List<List<Integer>> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        boolean[][] pacific = new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic = new  boolean[matrix.length][matrix[0].length];
        
        for (int i = 0; i < matrix[0].length; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
            dfs(matrix, atlantic, Integer.MIN_VALUE, matrix.length-1, i);
        }
        
        for (int i = 0; i < matrix.length; i++) {
            dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
            dfs(matrix, atlantic, Integer.MIN_VALUE, i, matrix[0].length-1);
        }
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (atlantic[i][j] && pacific[i][j]) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(i);
                    curr.add(j);
                    res.add(curr);
                }
            }
        }
        return res;
    }
    
    // pacific and atlantic dfs, how do we make it true 
    public void dfs(int[][] matrix, boolean[][] visited, int height, int i, int j) {
        if (i < 0 ||  j < 0 || i >= matrix.length || j >= matrix[0].length || visited[i][j] || matrix[i][j] < height) {
            return;
        }
        visited[i][j] = true;
        dfs(matrix, visited, matrix[i][j], i+1, j);
        dfs(matrix, visited, matrix[i][j], i-1, j);
        dfs(matrix, visited, matrix[i][j], i, j+1);
        dfs(matrix, visited, matrix[i][j], i, j-1);
    }
}