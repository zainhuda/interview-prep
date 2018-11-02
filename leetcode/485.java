class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currentMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                max++;
                currentMax = Math.max(currentMax, max);
            } else {
                max = 0;
            }
        }
        return currentMax;
    }
}
