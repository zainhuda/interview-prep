class Solution {
	public int searchInsert(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			if (i + 1 == nums.length) {
				if (nums[i] == target) {
					return i;
				} else if (nums[i] > target) {
					return i;
				}
				return i+1;
			}
			if (nums[i] >= target) {
				return i;
			}
		}
		return nums.length;
	}
}
