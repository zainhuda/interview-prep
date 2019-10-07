class Solution {
    public void nextPermutation(int[] nums) {
        // starting from the back 
        int smallestNum = -1;
        for (int i = nums.length-2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                smallestNum = i;
                break;
            }
        }
        if (smallestNum == -1) {
            Arrays.sort(nums);
        } else {
            // from the smallestNum we find the element that is just larger than it
            int swapElem = -1;
            for (int j = nums.length-1; j > smallestNum; j--) {
                if (nums[j] > nums[smallestNum]) {
                    swapElem = j;
                    break;
                }
            }
            // swap
            int temp = nums[swapElem];
            nums[swapElem] = nums[smallestNum];
            nums[smallestNum] = temp;
            reverse(nums, smallestNum+1);
        }
    }
    
    public void reverse(int[] nums, int i) {
        int j = nums.length-1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}