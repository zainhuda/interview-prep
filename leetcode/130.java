class Solution {
    int[][] directions = new int[][] {{0,-1}, {1,0}, {-1,0}, {0,1}};
    public void solve(char[][] board) {
        if (board == null || board.length < 1 || board[0].length < 1) return;
        int n = board.length-1;
        int m = board[0].length-1;
        boolean[][] visited = new boolean[n+1][m+1];
        // doing top and bottom border
        for (int i = 0; i <= n; i++) {
            if (board[i][m] == 'O') dfs(visited, board, i, m);
            if (board[i][0] == 'O') dfs(visited, board, i, 0);
        }
        
        for (int j = 0; j <= m; j++) {
            if (board[0][j] == 'O') dfs(visited, board, 0, j);
            if (board[n][j] == 'O') dfs(visited, board, n, j);
        }
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (!visited[i][j]) board[i][j] = 'X';
            }
        }
    }
    
    public void dfs(boolean[][] visited, char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || board[i][j] == 'X') return;
        visited[i][j] = true;
        for (int[] direction : directions) {
            dfs(visited, board, i+direction[0], j+direction[1]);
        }
    }
}