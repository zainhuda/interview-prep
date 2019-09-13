class Solution {
    public int[] productExceptSelf(int[] nums) {
        // take the product of the left side, and then right side
        int[] res = new int[nums.length];
        
        int prod = 1;
        for (int i = 0; i < res.length; i++) {
            res[i] = prod;
            prod *= nums[i];
        }
        
        // now we do the right side
        prod = 1;
        for (int i = res.length-1; i >= 0; i--) {
            res[i] *= prod;
            prod *= nums[i];
        }
        return res;
    }
}