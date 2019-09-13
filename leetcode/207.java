class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build an adajacency list
        ArrayList[] graph = new ArrayList[numCourses];
        
        // Pre-processing
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // Building Graph
        for (int i = 0; i < prerequisites.length; i++) {
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        boolean[] checker = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(checker, graph, i)) return false;
        }
        
        return true;
    }
    
    public boolean dfs (boolean[] checker, List[] graph, int num) {
        if (checker[num]) return false;
        checker[num] = true;
        for (int i = 0; i < graph[num].size(); i++) {
            if (!dfs(checker, graph, (int)graph[num].get(i))) return false;
        }
        checker[num] = false;
        return true;
    }
}