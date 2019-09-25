class Solution {
	public int satisfyingSubarrays(int[] arr, int k) {
		int left = 0, right = 0, count = 0, result = 0;
		while (right < arr.length) {
			if (arr[right] % 2 == 1) {
				count++;
			}
			if (count == k) result++;
			if (count > k) {
				while (count >= k && left < right) {
					if (arr[left] % 2 == 1) {
						count--;
					}
					if (count == k) result++;
					left++;
				} 
			}
			right++;
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