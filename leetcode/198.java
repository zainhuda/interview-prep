//  useful link
// https://leetcode.com/problems/house-robber/discuss/156523/From-good-to-great.-How-to-approach-most-of-DP-problems.
class Solution {
    // can rob nums.length - 2 houses
    // we propogate and compare at ith house the max value between
    // f(i-2) + f(i) vs f(i-1)
    // f is a function which represents the money at ith house
    // we are updating f(i-2) as we go down the array
    // if at ith house, f(i-1) yields more money than f(i-2)+f(i) then we switch
    // our robbing scheme
    public int rob(int[] nums) {
        int previousMax = 0; // f(i-2)
        int currentMax = 0; // f(i-1)
        for (int x: nums) {
            int temp = currentMax;
            currentMax = Math.max(previousMax + x, currentMax);
            previousMax = temp;
        }
        return currentMax;
    }
}
