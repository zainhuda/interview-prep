class maxSlidingWindow{
  public static ArrayDeque<Integer> find_max_sliding_window(
    int[] array,
    int window_size) {
    ArrayDeque<Integer> result = new ArrayDeque<Integer>();
    int start = 0;
    int end = window_size - 1;
    while (end <= array.length-1) {
      int max =  0; //  placeholder
      for (int i = start; i < end+1; i++) {
        if (array[i] > max) max = array[i];
      }
      result.add(max);
      start++;
      end++;
    }
    return result;
  }
  // faster method
  public static ArrayDeque<Integer> find_max_sliding_window(
    int[] array,
    int window_size) {
    if (array.length < window_size) return;
    ArrayDeque<Integer> index = new ArrayDeque<>();
    ArrayDeque<Integer> store = new ArrayDeque<>();
    // first window look
    for (int i = 0; i<window_size; i++) {
      while (!index.isEmpty() && array[i] >= array[index.peekLast()]) {
        index.removeLast();
      }
      index.addLast(i);
    }
    store.add(array[index.peekFirst()]);
    // iterative window look
    for (int i = window_size; i<array.length; i++) {
      while (!index.isEmpty() && array[i] >= array[index.peekLast()]) {
        index.removeLast();
      }
      while (!index.isEmpty() && index.peekFirst() <= i - window_size) {
        index.removeFirst();
      }
      index.addLast(i);
      store.add(array[index.peekFirst()]);
    }
    return store;
  }
}
