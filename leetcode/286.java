class Solution {
    public void wallsAndGates(int[][] rooms) {
      // another dfs style but we do a bfs  
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    boolean[][] visited = new boolean[rooms.length][rooms[0].length];
                    visited[i][j] = true;
                    dfs(rooms, visited, i, j);
                }
            }
        }
    }
    
    public void dfs(int[][] rooms, boolean[][] visited, int i, int j) {
        int directions[][] = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
        for (int[] direction : directions) {
            int x = i + direction[0];
            int y = j + direction[1];
            if (x < 0 || y < 0 || x >= rooms.length || y >= rooms[0].length || rooms[x][y] == -1 || rooms[x][y] == 0 || visited[x][y]) {
                continue;
            }
            rooms[x][y] = Math.min(rooms[i][j]+1, rooms[x][y]);
            visited[x][y] = true;
            dfs(rooms, visited, x, y);
            visited[x][y] = false;
        }
    }
}