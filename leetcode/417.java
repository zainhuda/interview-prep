class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        // dfs, we send it down left and up and right and down 
        // can we generalize the dfs?
        List<List<Integer>> res = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return res;
        // we try every single coordinate 
        System.out.println(pacificDfs(matrix, 2, 1));
        System.out.println(atlanticDfs(matrix, 2, 1));
        System.out.println("IGNORE");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacificDfs(matrix, i, j) && atlanticDfs(matrix, i, j)) {
                    List<Integer> curr = new ArrayList<>();
                    curr.add(j);
                    curr.add(i);
                    res.add(curr);
                }
            }
        }
        return res;
    }
    
    public boolean pacificDfs(int[][] matrix, int i, int j) {
        System.out.println(i);
        System.out.println(j);
        System.out.println("pacfic");
        if (i == 0  || j == 0) return true;
        if (i < 0 || j < 0) return false;
        boolean rowCheck = false, colCheck = false;
        if (i-1 >= 0 && matrix[i-1][j] <= matrix[i][j]) {
            rowCheck = pacificDfs(matrix, i-1, j);
        }
        if (j-1 >= 0 && matrix[i][j-1] <= matrix[i][j]) {
            colCheck = pacificDfs(matrix, i, j-1);
        }
        System.out.println(matrix[i][j]);
        System.out.println(matrix[i][j-1]);
        return rowCheck || colCheck;
    }
    
    public boolean atlanticDfs(int[][] matrix, int i, int j) {
        System.out.println(i);
        System.out.println(j);
        System.out.println("atlantic");
        if (i == matrix.length-1 || j == matrix[0].length-1) return true;
        if (i > matrix.length-1 || j > matrix[0].length-1) return false;
        boolean rowCheck = false, colCheck = false;
        if (i+1 < matrix.length && matrix[i+1][j] <= matrix[i][j]) {
            rowCheck = atlanticDfs(matrix, i+1, j);
        }
        if (j+1 < matrix[0].length && matrix[i][j+1] <= matrix[i][j]) {
            colCheck = atlanticDfs(matrix, i, j+1);
        }
        return rowCheck || colCheck;
    }
}