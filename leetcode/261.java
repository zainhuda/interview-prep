class Solution {
    public boolean validTree(int n, int[][] edges) {
        // we want to check if a cycle exists in the tree
        // pre processing for adj list
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        
        // build graph
        for (int i = 0; i < edges.length; i++) {
                graph.get(edges[i][0]).add(edges[i][1]);
                graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        if (dfs(graph, visited, 0, -1)) {
            return false;
        }
        
        // make sure we have visited all vertices
        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }
        
        return true;
    }
    
    public boolean dfs(HashMap<Integer, HashSet<Integer>> graph, boolean[] visited, int key, int ignore) {
        if (visited[key]) return true;
        visited[key] = true;
        for (int curr : graph.get(key)) {
            if (curr != ignore && dfs(graph, visited, curr, key)) {
                return true;
            } 
        }
        return false;
    }
}