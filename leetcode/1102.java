class Solution {
    int[][] directions = new int[][] {{0,1}, {1,0}, {0,-1}, {-1,0}};
    public int maximumMinimumPath(int[][] A) {
        // bfs, pq approach
        boolean[][] visited = new boolean[A.length][A[0].length];
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
           @Override
            public int compare(int[] a1, int[] a2) {
                return a2[2] - a1[2]; 
            }
        });
        heap.offer(new int[] {0,0,A[0][0]});
        while (!heap.isEmpty()) {
            int[] cell = heap.poll();
            int R = cell[0];
            int C = cell[1];
            if (R == A.length-1 && C == A[0].length-1) {
                return cell[2];
            }
            visited[R][C] = true;
            for (int[] direction : directions) {
                int X = R+direction[0];
                int Y = C+direction[1];
                if (X < 0 || X >= A.length || Y < 0 || Y >= A[0].length || visited[X][Y]) continue;
                heap.offer(new int[] {X, Y, Math.min(cell[2], A[X][Y])});
            }
        }
        return -1;
    }
}