class Solution {
    // constant space, runtime < O(n^2)
    // in a sense this is a linkedlist/graph with a cycle
    // two pointer approach to find the start of cycle, which is duplicated node!
    // wow this is hard
    public int findDuplicate(int[] nums) {
        while (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }
            
            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            
            return slow;
        }
        // never expect to be here 
        return -1;
    }
}
