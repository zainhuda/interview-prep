import java.util.*;
class Solution {
    // secret codeword, given random subsequences
    // topological sort?
    public String solution(String[] words) {
        HashMap<Character, Set<Character>> graph = new HashMap<>();
        // Pre-processing
        for (String word : words) {
            // Decompose into characters
            for (int i = 0; i < word.length(); i++) {
                Set<Character> temp = graph.getOrDefault(word.charAt(i), new HashSet<>());
                for (int j = i+1; j < word.length(); j++) {
                    temp.add(word.charAt(j));
                }   
                graph.put(word.charAt(i), temp);
            }
        }
        // Now we do the good old dfs and add all edges the path encompasses
        // We can build the path out and and then replace it
        
        Set<Character> seen = new HashSet<>();
        Stack<Character> stack = new Stack<>();
        for (Character key : graph.keySet()) {
            if (!seen.contains(key)) {
                dfs(key, stack, seen, graph);
            }
        }
   
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
        	sb.append(stack.pop());
        }	
        
        return sb.toString();
    }
  
    public void dfs(Character key, Stack<Character> stack, Set<Character> seen, HashMap<Character, Set<Character>> graph) {
        seen.add(key);
        for (Character c : graph.get(key)) {
        	if (!seen.contains(c)) dfs(c, stack, seen, graph);
        }
        stack.push(key);
    }
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	String res = sol.solution(new String[] {"bs3", "wb3", "wba", "as3f"});
        System.out.println(res);
        res = sol.solution(new String[] {"af", "ag"});
        System.out.println(res);
    }
}