class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        int[] days = new int[flowers.length];
        // switch array to hold days and indexes are positions
        for (int i = 0; i < flowers.length; i++) {
            days[flowers[i]-1] = i + 1;
        }
        int ret = Integer.MAX_VALUE;
        int left = 0;
        int right = k+1;
        find : while (right < days.length) {
            for (int i = left+1; i < right; ++i) {
                if (days[i] < days[left] || days[i] < days[right]) {
                    left = i;
                    right = i + k + 1;
                    continue find;
                }
            }
            ret = Math.min(ret, Math.max(days[left], days[right]));
            left = right;
            right = left + k + 1;
        }
        return ret == Integer.MAX_VALUE ? -1 : ret;
    }
}
