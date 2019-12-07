class Solution {
    public int inflectionPoint(int[] nums) {
    	// Ologn bsearch sol
    	if (nums[0] < nums[nums.length-1]) return nums[nums.length-1];
        int low  = 0;
        int high = nums.length-1;
        while (low < high) {
        	if (low+1 == high) {
        		return Math.max(nums[low], nums[high]);
        	}
        	int mid = low + (high-low)/2;
        	if (nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
        		return nums[mid];
        	} else if (nums[mid] > nums[mid-1]) {
        		low = mid+1;
        	} else {
        		high = mid-1;
        	}
        }
        // we should never reach this
        return -1;
    }
    
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int res = sol.inflectionPoint(new int[] {0,1,2,8,45,67,89,100,321,98,47,-6,-200});
        System.out.println(res);
        res = sol.inflectionPoint(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16});
        System.out.println(res);
        res = sol.inflectionPoint(new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,1});
        System.out.println(res);
    }
}