class Solution {
    public int[][] merge(int[][] intervals) {
        // we sort first by the starting point and then we just iterate through 
        // and change ending time if it's earlier than start, hence a "merge"
        if (intervals.length == 0) return new int[0][];
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> result = new ArrayList<>();
        int[] curr = intervals[0];
        result.add(curr);
        for (int[] interval : intervals) {
            if (curr[1] >= interval[0]) {
                curr[1] = Math.max(interval[1], curr[1]);
            } else {
                curr = interval;
                result.add(curr);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}