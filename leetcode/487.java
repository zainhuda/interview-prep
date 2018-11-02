class Solution {
    // two pointer approach yeah
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int left = 0;
        int curr = 0;
        for (int i = 0; i < nums.length; i++) {
            curr++;
            if (nums[i] == 0) {
                left = curr;
                curr = 0;
            }
            max = Math.max(max, left+curr);
        }
        return max;
    }
}
