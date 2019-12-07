class Solution {
    public int[] dailyTemperatures(int[] T) {
        // what pre processing can we do here
        // two stacks? O(n)
        // do a rebalancing for stacks 
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[T.length];
        // int[] : temp, index
        for (int i = T.length-1; i >= 0; i--) {
            while (!stack.isEmpty() &&  T[i] >= T[stack.peek()]) stack.pop();
            res[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        
        return res;
    }
}