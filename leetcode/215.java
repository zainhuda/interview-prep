class Solution {
    public int findKthLargest(int[] nums, int k) {
        // kth largest element in the sorted array
        // we can keep a heap and implicitly sort for us
        // minheap, if we want the kth largest element
        // nlogk 
        
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1.compareTo(i2);
            }
        });
        
        for (int num : nums) {
            heap.add(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        return heap.poll();
    }
}