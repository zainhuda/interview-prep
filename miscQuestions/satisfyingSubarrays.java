class Solution {
	public int satisfyingSubarrays(int[] arr, int k) {
		// naaive approach On^2
		// my thoughts on optimal soluton:
		// creating an array of nums "odd groupings"
		// maybe combinatoric solution is smt like that ? (arr[i]+1) * (arr[i+m]+1) = combinations for that given subarray
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			int count = 0;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] % 2 == 1) {
					count++;
				}
				if (count == k) {
					result++;
				} else if (count > k) {
					break;
				}
			}
		}
		return result;
    }

    public static void main(String[] args) {
        // Testing
    	Solution sol = new Solution();
        int res = sol.satisfyingSubarrays(new int[] {1,2,3,4,5}, 2);
        System.out.println(res);
        res = sol.satisfyingSubarrays(new int[] {1,3,4,5}, 0);
        System.out.println(res);
        res = sol.satisfyingSubarrays(new int[] {2,2,5,6,9,2,11,9,2,11,12}, 1);
        System.out.println(res);
    }
}