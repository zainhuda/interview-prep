class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }
    public void backtrack(List<String> ans, String build, int close, int open, int max) {
        if (build.length() == max*2) {
            ans.add(build);
            return;
        }
        if (open < max) {
            backtrack(ans, build+"(", close, open+1, max);
        }
        if (close < open) {
            backtrack(ans, build+")", close+1, open, max);
        }
    }
}
