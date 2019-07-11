class Solution {
    // linear scan, two pointers
    // O(n), O(1) space
    // at most k duplicates, here k = 2
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            // using sorting property, add the first two to array
            // second conditional using the sorting property sees if current value is greater than the one 2 indexes before it
            // if its not, then we know we don't need to add it 
            if (i < 2 || num > nums[i-2]) {
                nums[i++] = num;
            }
        }
        return i;
    }
    
    
}