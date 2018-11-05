class maxSum{
  static int find_max_sum_nonadjacent(int[] a) {
    // dp array
    int[] dp = new int[a.length];
    dp[0] = a[0];
    for (int i = 1; i < a.length; i++) {
      dp[i] = Math.max(a[i], dp[i-1]);
      if (i-2 >= 0) {
        dp[i] = Math.max(dp[i], a[i] + dp[i-2]);
      }
    }
    return dp[a.length-1];
  }
}
