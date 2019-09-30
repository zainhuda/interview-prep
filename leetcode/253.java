class Solution {
    public int minMeetingRooms(int[][] intervals) {
        // we sort the input and then do the badabing badaboom
        if (intervals.length < 1) return 0;
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        int count = 0;
        int endPointer = 0, startPointer = 0;
        while (startPointer < intervals.length) {
            if (start[startPointer] >= end[endPointer]) {
                count--;
                endPointer++;
            }
            count++;
            startPointer++;
        }
        return count;
    }
}