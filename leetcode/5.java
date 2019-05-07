class Solution {
    // O(n^2)
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int length, length1, length2, start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            length1 = palindromeChecker(s, i, i);
            length2 = palindromeChecker(s, i, i+1);
            length = Math.max(length1, length2);
            if (length > end - start + 1) {
                start = i - (length-1)/2;
                end = i + length/2;
            }
        }
        return s.substring(start, end+1);
    }
    
    private int palindromeChecker(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        return end - start - 1;
    }
    
  
}