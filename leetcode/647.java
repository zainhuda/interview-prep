class Solution {
    public int countSubstrings(String s) {
        // sliding window, we see if a given substring is a palindrome
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += checker(s, i, i);
            count += checker(s, i, i+1);
        }
        return count;
    }
    
    public int checker(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }
        return count;
    }
}