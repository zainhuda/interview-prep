class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return helper(dp, 0, s, words);
    }
    
    public boolean helper(Boolean[] dp, int start, String s, Set<String> words) {
        if (start == s.length()) {
            return true;
        }
        if (dp[start] != null) return dp[start];
        for (int i = start+1; i <= s.length(); i++) {
            if (words.contains(s.substring(start, i)) && helper(dp, i, s, words)) {
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
}