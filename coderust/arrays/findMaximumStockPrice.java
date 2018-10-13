class stock_prices{
  public static Tuple find_buy_sell_stock_prices(int[] array) {
    // array[0] is initial buy and array[1] is inital sell
    int currentProfit = Integer.MIN_VALUE;
    int currentBuy = array[0];
    int optimalSell = array[1];
    int optimalProfit = optimalSell - currentBuy;
    for (int i = 1; i < array.length; i++) {
      currentProfit = array[i] - currentBuy;
      if (currentProfit > optimalProfit) {
        optimalSell = array[i];
        optimalProfit = currentProfit;
      }
      if (currentBuy > array[i]) {
        currentBuy = array[i];
      }
    }
    Tuple<Integer, Integer> optimal = new Tuple<Integer, Integer>(optimalSell - optimalProfit, optimalSell);
    return optimal;
  }
}
