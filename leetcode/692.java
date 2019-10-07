class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // heap 
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String w1, String w2) {
                if (map.get(w1) == map.get(w2)){
                    return w2.compareTo(w1);
                }
                return map.get(w1) - map.get(w2);
            }
        });
        
        for (String word : map.keySet()) {
            heap.add(word);
            if (heap.size() > k) heap.poll();
        }
        
        List<String> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(0, heap.poll());
        }
        
        return res;
    }
}