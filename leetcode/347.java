class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        // heap question
        // we can keep k elements in the heap 
        // can aim for nlogk sol
        // we can sort by how many times we've seen it
        // if we add in a sorted order
        // what comparator do we make?
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer n1, Integer n2) {
                return map.get(n1) - map.get(n2);
            }
        });
        
        for (int i : map.keySet()) {
            heap.add(i);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        List<Integer> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }
        return res;
    }
}