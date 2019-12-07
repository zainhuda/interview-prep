class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        // look at all edges in the cycle, and then choose the one that is the latest in 2d arr
        Map<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < 1001; i++) {
            graph.put(i, new HashSet<>());
        }
        Set<Integer> visited = new HashSet<>();
        int[] ret = edges[0];
        for (int[] edge : edges) {
            visited.clear();
            if (dfs(0, edge[0], edge[1], graph)) {
                ret = edge;
            } else {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
        } 
        return ret;
    }
        
    public boolean dfs(int prev, int source, int target, Map<Integer, HashSet<Integer>> graph) {
        if (source == target) return true;
        for (int next : graph.get(source)) {
            if (prev != next && dfs(source, next, target, graph)) {
                return true;
            }
        }
        return false;
    }
}