class Solution {
    int[][] directions = new int[][] {{0,-1}, {-1, 0}, {1,0}, {0,1}};
    public int numEnclaves(int[][] A) {
        // check from which numbers we can't get to the boundary from
        // if we cant get to boundary, then we keep those 1's false
        // we traverse matrix, if its 1 and false, then we count it
        // we can use a cache, if it's a 1 and we can 
        
        boolean[][] canWalk = new boolean[A.length][A[0].length];
        // top bottom
        for (int j = 0; j < A[0].length; j++) {
            dfs(A, canWalk, 0, j);
            dfs(A, canWalk, A.length-1, j);
        }
        // left rigth
        for (int i = 0; i < A.length; i++) {
            dfs(A, canWalk, i, 0);
            dfs(A, canWalk, i, A[0].length-1);
        }
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1 && !canWalk[i][j]) count++;
            }
        }
        
        return count;

    }
    
    public void dfs(int[][] A, boolean[][] canWalk, int i, int j) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == 0 || canWalk[i][j]) return;
        canWalk[i][j] = true;
        for (int[] direction : directions) {
            dfs(A, canWalk, i+direction[0], j+direction[1]);
        }
    }
}