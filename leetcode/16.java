lass Solution {
    public int threeSumClosest(int[] nums, int target) {
        // iterative sol
        // keep distance and sum 
        // two loops 
        Arrays.sort(nums);
        int sum = 0;
        int curr;
        int distance = Integer.MAX_VALUE;
        for (int i = 0; i <= nums.length-3; i++) {
            int j = i+1; 
            int k = nums.length-1;
            while (j < k) {
                curr = nums[i]+nums[j]+nums[k];
                if (curr < target) {
                    j++;
                } else {
                    k--;
                }
                if (Math.abs(curr-target) < Math.abs(distance)) {
                    sum = curr;
                    distance = sum - target;
                }
            }
        }
        return sum;
    }
}
