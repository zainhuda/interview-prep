class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // we can find max non overlapping intervals
        if (intervals.length < 1) return 0;
        // sort
        Arrays.sort(intervals, new Comparator<int[]>() {
           @Override
            public int compare(int[] i1, int[] i2) {
                return i1[1] - i2[1];
            }
        });
        int end = intervals[0][1];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length - count;
    }
}