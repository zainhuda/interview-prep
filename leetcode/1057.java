class Solution {
    public int[] assignBikes(int[][] workers, int[][] bikes) {
        // good old heap question 
        // we compute all possible distances for a given worker and bikes
        // then we build our res arr
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] d1, int[] d2) {
                int dist = d1[0] - d2[0];
                if (dist == 0) {
                    if (d1[1] == d2[1]) {
                        return d1[2] - d2[2];
                    }
                    return d1[1] - d2[1];
                }
                return dist;
            }
        });
        
        // Building heap
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int dist = distance(bikes[j], workers[i]);
                int[] arr = new int[] {dist, i, j};
                heap.offer(arr);
            }
        }
        
        // we place index of bike
        int[] res = new int[workers.length];
        for (int i = 0; i < res.length; i++) res[i] = -1;
        Set<Integer> bikesPlaced = new HashSet<>();
        while (bikesPlaced.size() < workers.length) {
            int[] curr = heap.poll();
            if (res[curr[1]] == -1 && !bikesPlaced.contains(curr[2])) {
                res[curr[1]] = curr[2];
                bikesPlaced.add(curr[2]);
            }
        }
        return res;
    }
    
    
    private int distance(int[] p1, int[] p2) {
        return (Math.abs(p1[0]-p2[0]) + Math.abs(p1[1]-p2[1]));
    }
}