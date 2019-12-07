class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // we do a dfs, and we compute the "height" as we go through
        // if we a tree that has height we haven't seen then we add it to our res
        // need to reach a leaf, a node where it has no 
        // 0 to n-1
        if (n == 1) return Collections.singletonList(0);
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < edges.length; i++) {
            graph.putIfAbsent(edges[i][0], new HashSet<>());
            graph.putIfAbsent(edges[i][1], new HashSet<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (graph.get(i).size() == 1) leaves.add(i);
        }
        
        while (n > 2) {
            n -= leaves.size();
            List<Integer> currLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = graph.get(i).iterator().next();
                graph.get(j).remove(i);
                if (graph.get(j).size() == 1) currLeaves.add(j);
            }
            leaves = currLeaves;
        }
        
        return leaves;
    }
}