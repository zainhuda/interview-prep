class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0 || nums == null) return -1;
        int low = 0;
        int high = nums.length-1;
        int middle;
        // Find the true start of the array
        while(low < high) {
            middle = low + (high - low)/2;
            if (nums[middle] > nums[high]) {
                 low = middle+1;
            } else {
                high = middle;
            }
        }
        // Find where target is left or right of start in array
        int start = low;
        low = 0;
        high = nums.length-1;
        if (target >= nums[start] && target <= nums[high]) {
            low = start;
        } else {
            high = start;
        }
        // Proceeding with binary search
        while(low <= high) {
            middle = low + (high - low)/2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return -1;
    }
}
