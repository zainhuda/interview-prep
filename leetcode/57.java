class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // "as we go" approach of merging 
        LinkedList<int[]> result = new LinkedList<>();
        int i = 0;
        while (i < intervals.length && newInterval[0] > intervals[i][0]) {
            result.add(intervals[i++]);
        }
        if (result.isEmpty() || result.getLast()[1] < newInterval[0]) {
            result.add(newInterval);
        } else {
            int[] curr = result.removeLast();
            curr[1] = Math.max(curr[1], newInterval[1]);
            result.add(curr);
        }
        
        while (i < intervals.length) {
            int[] interval = intervals[i++];
            if (interval[0] > result.getLast()[1]) {
                result.add(interval);
            } else {
                int[] curr = result.removeLast();
                curr[1] = Math.max(curr[1], interval[1]);
                result.add(curr);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}