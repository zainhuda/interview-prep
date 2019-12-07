class Solution {
    public String alienOrder(String[] words) {
        // dfs topological sort  
        // stack and then just put em in stringbuiolder
        // between two words, we create our graph
        HashMap<Character, HashSet<Character>> graph = new HashMap<>();
        // pre processing
        for (String word : words) {
            for (Character c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());  
            }
        }
        
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i-1];
            String w2 = words[i];
            int len = Math.min(w1.length(), w2.length());
            for (int j = 0; j < len; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    graph.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }
        
        // we need to check for cyclicality 
        Set<Character> visited = new HashSet<>();
        for (Character c : graph.keySet()) {
            if (isCyclic(visited, graph, c)) return "";
        }        
        // toposort
        Deque<Character> stack = new ArrayDeque<>();
        visited.clear();        
        for (Character c : graph.keySet()) {
            if (!visited.contains(c)) {
                dfs(visited, stack, graph, c);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.toString();
    }
    
    
    public boolean isCyclic(Set<Character> visited, HashMap<Character, HashSet<Character>> graph, Character c) {
        if (visited.contains(c)) return true;
        visited.add(c);
        for (Character k : graph.get(c)) {
            if (isCyclic(visited, graph, k)) return true;
        }
        visited.remove(c);
        return false;
    }
    
    public void dfs(Set<Character> visited, Deque<Character> stack, HashMap<Character, HashSet<Character>> graph, Character c) {
        if (visited.contains(c)) return;
        visited.add(c);
        for (Character k : graph.get(c)) {
            if (!visited.contains(k)) dfs(visited, stack, graph, k);
        }
        stack.push(c);
    }
}