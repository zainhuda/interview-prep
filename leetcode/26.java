class Solution {
    public int removeDuplicates(int[] nums) {
        // two pointers, current node we are at, and then we keep going i.
        // remove numbers from array by moving all subsequent numbers left by one
        // 2nd pointer is the the length that we go to
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }
}
