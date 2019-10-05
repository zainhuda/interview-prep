import java.util.Stack;

class Solution {
    public int calculator(String expression) {
        Stack<Character> stack = new Stack<>();
        int res = 0;
        for (char c : expression.toCharArray()) {
            if (c == ')') {
                res = calculateHelper(stack);
                if (stack.isEmpty()) return res;
                stack.pop();
                char value = (char)(res + '0');
                stack.push(value);
            } else {
                stack.push(c);
            }
        }
        return res;
    }

    public int calculateHelper(Stack<Character> stack) {
        int res = 0;
        if (!stack.isEmpty()) res = stack.pop() - '0';
        
        while (!stack.isEmpty() && stack.peek() != '(') {
        	char c = stack.pop();
            if (c == '+') {
                res += stack.pop() - '0';
            } else if (c == '*') {
                res *= stack.pop() - '0';
            }
        }
        return res;
    }


    public static void main(String[] args) {
    	Solution sol = new Solution();
        System.out.println(sol.calculator("(((((4)))+1))"));
        System.out.println(sol.calculator("(8*((2+4)*2))"));
        System.out.println(sol.calculator("((1+2)*3)"));

    }
}