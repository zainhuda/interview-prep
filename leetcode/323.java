class Solution {
    public int countComponents(int n, int[][] edges) {
        // we build a graph, and traverse through it to edges we haven't seen before
        // using  a boolean array to keep track of the edges we've already visited
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        // pre processing graph building
        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i, new HashSet<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i); 
                count++;
            }
        }
        return count;
    }
    
    public void dfs(HashMap<Integer, HashSet<Integer>> graph, boolean[] visited, int key) {
        if (visited[key]) return;
        visited[key] = true;
        for (int curr : graph.get(key)) {
            dfs(graph, visited, curr); 
        }
        return;
    }
}