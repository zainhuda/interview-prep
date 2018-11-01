class Solution {
    // prority queue
    // add till we have k elements, and then as new elements come in, we pop elements and find max and add it to
    // answer list
    // do this until we reach end of list
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) return new int[0];
        int[] result = new int[nums.length-k+1];
        int start = 0;
        int end = k - 1;
        int insert = 0;
        while (end <= nums.length-1) {
            int max =  Integer.MIN_VALUE; //  placeholder
            for (int i = start; i < end+1; i++) {
                if (nums[i] > max) max = nums[i];
            }
            result[insert] = max;
            insert++;
            start++;
            end++;
        }
        return result;
    }
}
