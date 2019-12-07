class Solution {
    public boolean removeAtMostK(int[] arr, int k) {
        // LIS Problem 
        int[] LIS = new int[arr.length];
        int maxLen = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    LIS[i] = Math.max(LIS[i], 1+LIS[j]);
                    maxLen = Math.max(LIS[i], maxLen);
                }
            }
        }
        return arr.length-maxLen >= K;
    }
}