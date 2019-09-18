class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 0, max = 0;
        Set<Character> store = new HashSet<>();
        while (start < s.length() && end < s.length()) {
            if (!store.contains(s.charAt(end))) {
                store.add(s.charAt(end++));
                max = Math.max(max, end-start);
            } else {
                store.remove(s.charAt(start++));                
            }
        }
        return max;
    }
}