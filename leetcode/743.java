class Solution {
    // 1 to N
    // keep a max
    // we can use a boolean array to check if every node has been reached
    Map<Integer, Integer> dist;
    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, HashSet<int[]>> graph = new HashMap<>();
        dist = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.putIfAbsent(i, new HashSet<>());
            dist.putIfAbsent(i, Integer.MAX_VALUE);
        }
        // Source Node --> Target, Time
        for (int i = 0; i < times.length; i++) {
            graph.get(times[i][0]).add(new int[] {times[i][1], times[i][2]});
        }
        // we will ignore 0
        dfs(graph, K, 0);
        int max = 0;
        for (int cand : dist.values()) {
            if (cand == Integer.MAX_VALUE) return -1;
            max = Math.max(max, cand);
        }
        return max;
    }
    
    public void dfs(HashMap<Integer, HashSet<int[]>> graph, int node, int time) {
        if (dist.get(node) <= time) return;
        dist.put(node, time);
        for (int[] nextNode : graph.get(node)) {
            dfs(graph, nextNode[0], time+nextNode[1]);
        }
    }
}

// improved heap djikstras solution
class Solution {
    // 1 to N
    // keep a max
    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, HashSet<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            graph.putIfAbsent(i, new HashSet<>());
        }
        // Source Node --> Target, Time
        for (int i = 0; i < times.length; i++) {
            graph.get(times[i][0]).add(new int[] {times[i][1], times[i][2]});
        }
        
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] n1, int[] n2) {
                return n1[1]-n2[1];
            }
        });

        heap.offer(new int[] {K, 0});
        // we will ignore 0
        // we can decrement N each time or we can use dist hashmap
        Map<Integer, Integer> dist = new HashMap<>();
        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int node = curr[0];
            int distance = curr[1];
            if (dist.containsKey(node)) continue;
            dist.put(node, distance);
            if (graph.containsKey(node)) {
                for (int[] nextNode : graph.get(node)) {
                    heap.offer(new int[] {nextNode[0], distance+nextNode[1]});
                }   
            }            
        }
        
        int max = 0;
        for (int i = 1; i <= N; i++) {
            if (!dist.containsKey(i)) return -1;
            if (max < dist.get(i)) max = dist.get(i);
        }
        
        return max;
    }
}