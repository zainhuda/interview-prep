class Solution {
    public int maximumProduct(int[] nums) {
        // heap
        // min heap
        PriorityQueue<Integer> min = new PriorityQueue<>();
        // max heap
        PriorityQueue<Integer> max = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        });
        
        for (int num : nums) {
            min.offer(num);
            max.offer(num);
            if (max.size() > 2) {
                max.poll();
            }
            if (min.size() > 3) {
                min.poll();
            }
        }
        
        int maxProd = 1, minProd = 1;
        int maxVal = 0;
        while (!min.isEmpty()) {
            maxVal = min.poll();
            maxProd *= maxVal;
        }
        
        while (!max.isEmpty()) {
            maxVal *= max.poll();
        }
        
        return Math.max(maxVal, maxProd);
    }
}