class Solution {
    // i didn't want to do type conversions
    class Pair {
        int length;
        String word;
        public Pair(String word, int length) {
            this.word = word;
            this.length = length;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // build adj list such that, each word, goes to words that are one edit distance from it
        // this is the preprocessing step
        // we can then bfs and find the shortest path it takes us to get to the endWord
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String intermediate = word.substring(0, i)+"*"+word.substring(i+1, word.length());
                HashSet<String> neighbors = graph.getOrDefault(intermediate, new HashSet<String>());
                neighbors.add(word);
                graph.put(intermediate, neighbors);
            }   
        }
        
        Queue<Pair> bfs = new LinkedList<>();
        bfs.offer(new Pair(beginWord, 1));
        Set<String> visited = new HashSet<>();
        while (!bfs.isEmpty()) {
            Pair next = bfs.poll();
            String word = next.word;
            for (int i = 0; i < word.length(); i++) {
                String adj = word.substring(0, i)+"*"+word.substring(i+1, word.length());
                for (String neighbor : graph.getOrDefault(adj, new HashSet<>())) {
                    if (neighbor.equals(endWord)) return next.length+1;
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        bfs.offer(new Pair(neighbor, next.length+1));
                    }
                }
            }
        }
        return 0;
    }
}