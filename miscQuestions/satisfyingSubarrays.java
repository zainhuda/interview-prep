class Solution {
	public int satisfyingSubarrays(int[] arr, int k) {
		// two pointers did not work
		// convert every odd number to 1 and even number to 0
		// if sum of a subarray is k, it is a satisfying subarray
		// can we do better than On^2
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				arr[i] = 0;
			} else {
				arr[i] = 1;
			}
		}
		
		int result = 0, sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum == k) result++;
				if (sum > k) break;
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
        res = sol.satisfyingSubarrays(new int[] {1,4,6,8,10}, 1);
        System.out.println(res);
    }
}