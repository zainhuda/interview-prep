class FreqStack {
    HashMap<Integer, Integer> freq = new HashMap<>(); // key is int val is freq
    HashMap<Integer, Stack<Integer>> stack = new HashMap<>(); // freq is key, val is int
    int mode = 0;

    public FreqStack() {
        // nothing to intialize lol
    }

    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        mode = Math.max(mode, f);
        if(!stack.containsKey(f)) {
            stack.put(f, new Stack<Integer>());
        }
        stack.get(f).push(x);
    }

    public int pop() {
        int popped = stack.get(mode).pop();
        freq.put(popped, mode - 1);
        if (stack.get(mode).size() == 0) mode--;
        return popped;
    }
}
