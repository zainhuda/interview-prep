class coinChanging{
  static int solve_coin_change_dp(
      int[] denominations,
      int amount) {
    int[] solution = new int[amount+1];
    solution[0] = 1;
    for (int den: denominations) {
      for (int i = den; i < (amount+1); i++) {
        solution[i] += solution[i-den];
      }
    }
    return solution[amount];
   }
}
