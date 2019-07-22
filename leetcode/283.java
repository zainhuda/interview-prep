class Solution {
    // classic two pointer action
    public void moveZeroes(int[] nums) {
        int slow = 0;
        int runner = 1;
        while (runner < nums.length && slow < nums.length) {
            if (nums[slow] == 0 && nums[runner] != 0) {
                nums[slow] = nums[runner];
                nums[runner] = 0;
                slow++;
                runner++;
            } else if (nums[slow] != 0) {
                slow++;
                runner++;                    
            } else if (nums[runner] == 0) {
                runner++;
            }
        }
    }
}
