class Solution {
    public boolean checkPossibility(int[] nums) {
        // tells us where the nums[i] <= nums[i+1] is not true
        int count = -1;
        for(int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1]) {
                if (count != -1) {
                    return false; // only get here when problem 
                }
                count = i;
            }
        }
        // can occur at either index 0, index length of nums - 2 or in middle of array where nums[i-1] <= nums[i+1] exists
        return (count == -1 || count == 0 || count == nums.length-2 || nums[count-1] <= nums[count+1] || nums[count] <= nums[count+2]);
    }
}