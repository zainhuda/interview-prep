class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        // heap, if we can put it in by alphabetically and frequency
        
        // pre processing step
        Map<String, Integer> freqCount = new HashMap<>();
        for (String word : words) {
            freqCount.put(word, freqCount.getOrDefault(word, 0)+1);
        }
        
        // min heap for numbers and max heap for the strings 
        PriorityQueue<Map.Entry<String,Integer>> heap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue();
            }
        });
        
        for (Map.Entry<String, Integer> word : freqCount.entrySet()) {
            heap.offer(word);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        List<String> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(0, heap.poll().getKey());
        }
        
        return  res;
        
        
    }
}