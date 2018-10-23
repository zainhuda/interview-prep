/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        // hardest part is sorting 
        Collections.sort(intervals, new IntervalComparator());
        LinkedList<Interval> merged = new LinkedList<>();
        for (Interval i: intervals) {
            if (merged.isEmpty() || merged.getLast().end < i.start) {
                merged.add(i);
            } else {
                merged.getLast().end = Math.max(i.end, merged.getLast().end);
            }
        }
        return merged;
    }
}
