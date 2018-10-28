class Solution {
    // want to find first number that breaks the descening order of array
    // replace that with the smallest value that is greater than it
    // reverse everything to the right of the array
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) return;
        int target = -1;
        for (int i = nums.length-1; i > 0; i--) {
            if (nums[i-1] < nums[i]) {
                target = i-1;
                break;
            }
        }
        if (target == -1) {
            reverser(nums, 0, nums.length-1);
            return;
        }
        // find smallest largest number
        int number = nums[target];
        int smallestLargest = nums[target+1];
        int smallestLargestIndex = target+1;
        for (int i = target+1; i < nums.length; i++) {
            if (smallestLargest >= nums[i] && nums[i] > number) {
                smallestLargest = nums[i];
                smallestLargestIndex = i;
            }
        }
        nums[target] = smallestLargest;
        nums[smallestLargestIndex] = number;

        reverser(nums, target+1, nums.length-1);
    }

    public void reverser(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        while (i < j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
    }
}
