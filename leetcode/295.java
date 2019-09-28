class MedianFinder {
    PriorityQueue<Integer> low;
    PriorityQueue<Integer> high;
    int count = 0;
    /** initialize your data structure here. */
    public MedianFinder() {
        this.low = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        this.high = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        low.offer(num);
        high.offer(low.poll());
        if (high.size() > low.size()) low.offer(high.poll());
    }
    
    public double findMedian() {
        if (low.size() == high.size()) {
            return (double)(low.peek() + high.peek())/2;
        } else {
            return (double)low.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */