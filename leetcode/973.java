class Solution {
    public int[][] kClosest(int[][] points, int K) {
        // heap question
        // max heap, points furhter way from origin are at the top
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            // by default min heap
            @Override
            public int compare(int[] p1, int[] p2) {
                int dist2 = Math.abs(p2[0]*p2[0]) + Math.abs(p2[1]*p2[1]);
                int dist1 = Math.abs(p1[0]*p1[0]) + Math.abs(p1[1]*p1[1]);
                return dist2-dist1;
            }
        });
        
        for (int[] point : points) {
            heap.add(point);
            if (heap.size() > K) heap.poll();
        }
        
        List<int[]> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(heap.poll());
        }
        
        return res.toArray(new int[res.size()][]);
    }
}