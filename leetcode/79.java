class Solution {
    public boolean exist(char[][] board, String word) {
        // dfs for word, if we find it then bang its a true
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++)  {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (dfs(board, word, 0, i, j, visited)) return true;
                }
            }
        }
        return false;
    }
    
    // bfs!
    public boolean dfs(char[][] board, String word, int c, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || c >= word.length()) return false;
        if (visited[i][j]) return false;
        if (word.charAt(c) != board[i][j]) return false;
        if (c == word.length()-1) return true;
        visited[i][j] = true;
        int[][] directions = new int[][] {{0,-1}, {-1, 0}, {0,1}, {1,0}};
        for (int[] direction : directions) {
            if (dfs(board, word, c+1, i+direction[0], j+direction[1], visited)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}