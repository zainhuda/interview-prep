class Solution {
    int min = Integer.MAX_VALUE;
    public int assignBikes(int[][] workers, int[][] bikes) {
        // we can do a backtracking approach
        dfs(0, 0, workers, bikes, new boolean[bikes.length]);
        return min;
    }
    
    public void dfs(int worker, int distance, int[][] workers, int[][] bikes, boolean[] visited) {
        if (worker >= workers.length) {
            min = Math.min(distance, min);
            return;
        }
        // short-circuit evaluation
        if (distance > min) return;
        
        for (int i = 0; i < bikes.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            dfs(worker+1, distance+distanceFunc(bikes[i], workers[worker]), workers, bikes, visited);
            visited[i] = false;
        }
    }
    public int distanceFunc(int[] p1, int[] p2) {
        return Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]);
    }
}