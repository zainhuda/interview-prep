class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // back tracking stuff, we do a dfs and everytime we reach it we just add it to the list
        HashMap<Integer, HashSet<Integer>> graphT = new HashMap<>();
        int start = 0;
        int end = graph.length-1;
        
        for (int i = 0; i < graph.length; i++) {
            graphT.putIfAbsent(i, new HashSet<Integer>());
            for (int j = 0; j < graph[i].length; j++) {
                graphT.get(i).add(graph[i][j]);
            }
        }
        
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(graphT, result, curr, start, end);
        return result;
    }
    
    private void dfs(HashMap<Integer, HashSet<Integer>> graph, List<List<Integer>> result, List<Integer> curr, int start, int edge) {
        if (start == edge) {
            result.add(new ArrayList<>(curr));
            return;
        }
        for (int next : graph.get(start)) {
            curr.add(next);
            dfs(graph, result, curr, next, edge);
            curr.remove(curr.size()-1);
        }
        return;
    }
}