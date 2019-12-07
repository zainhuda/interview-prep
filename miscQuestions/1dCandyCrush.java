// https://leetcode.com/discuss/interview-question/395486/Google-or-Phone-screen-or-1d-candy-crush
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    class Tuple {
        char c;
        int val;
        public Tuple(char c, int val) {
            this.c = c;
            this.val = val;
        }
    }
    public String solution(String row) {
        Deque<Tuple> stack = new ArrayDeque<>();
        int charCount = 0;
        for (int i = 0; i < row.length(); i++) {
            char c = row.charAt(i);
            int count = 0;
            for (; i+1 < row.length && row.charAt(i+1) == c; i++) {
                count++;
            }

            if (!stack.isEmpty() && stack.peek().c == c) {
                count += stack.pop().val;
            }

            if (count < 3)  {
                stack.push(new Tuple(c, count));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Tuple tup = stack.pop();
            for (int i = 0; i < tup.val; i++) {
                sb.append(stack.c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        
    }
}