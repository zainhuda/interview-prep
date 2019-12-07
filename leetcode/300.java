class Solution {
    public int lengthOfLIS(int[] nums) {
        // binary search dp way
        // for each num, we use bserch to find where we put it
        // if its end of arr, we inc size
        int[] dp = new int[nums.length];
        int size = 0;
        for (int num : nums) {
            int low = 0, high = size;
            while (low != high) {
                int mid = low + (high-low)/2;
                if (dp[mid] < num) {
                    low = mid+1;
                } else {
                    high = mid;
                }
            }
            dp[low] = num;
            if (low == size) size++;
        }
        return size;
    }
}