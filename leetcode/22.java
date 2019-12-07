class Solution {
    public List<String> generateParenthesis(int n) {
        // backtracking
        // we can reduce n, when we have placed a pair
        // for each pair we decremet n
        int currUsed = 0;
        List<String> res = new ArrayList<>();
        builder(res, 0, 0, n, new StringBuilder());
        return res;
    }
    
    public void builder(List<String> res, int currUsed, int endUsed, int n, StringBuilder sb) {
        if (sb.length() == 2*n) {
            res.add(sb.toString());
            return;
        }
        // we'll use currUsed a way to how many open/close paranthesis we have used
        // we can place a ) or (
        if (currUsed < n) {
            sb.append("(");
            builder(res, currUsed+1, endUsed, n, sb);
            sb.deleteCharAt(sb.length()-1);   
        } 
        if (endUsed < currUsed) {
            sb.append(")");
            builder(res, currUsed, endUsed+1, n, sb);
            sb.deleteCharAt(sb.length()-1);
        }     
    }
}