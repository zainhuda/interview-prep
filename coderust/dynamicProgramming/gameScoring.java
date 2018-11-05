class gameScoring{
  // Scoring options are 1, 2, 4
  public static int scoring_options(int n) {
    if (n < 0) {
      return -1;
    }

    int [] result = new int[4];
    result[3] = 1; //base

    for (int i = 1; i <= n; i++) {
      int sum = result[3] + result[2] + result[0];
      result[0] = result[1];
      result[1] = result[2];
      result[2] = result[3];
      result[3] = sum;
    }
    return result[3];
  }
}
