class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // using a queue to simulative topologicla ordering
        // put nodes with 0 in degrees first and move on forward from there
        boolean top = true;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] degrees = new int[numCourses];
        int[] topOrder = new int[numCourses];
        
        // building graph
        for (int i = 0; i < prerequisites.length; i++) {
            graph.putIfAbsent(prerequisites[i][1], new ArrayList<>());
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            degrees[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)  {
            if (degrees[i] == 0) {
                q.add(i);
            }
        }
        
        int i = 0;
        while (!q.isEmpty()) {
            int node = q.remove();
            topOrder[i++] = node;
            
            if (graph.containsKey(node)) {
                for (Integer adj : graph.get(node)) {
                    degrees[adj]--;
                    
                    if (degrees[adj] == 0) {
                        q.add(adj);
                    }
                }
            }
        }
        
        if (i == numCourses) {
            return topOrder;
        }
        
        return new int[0];
        
        
        
    }
}