class Solution {
    public String longestAlphabeticalSubstring(String s) {
        // Two Pointer solution
        // Using left to constrict the string, right to expand the string
        if (s == null) throw new IllegalArgumentException("Must input string!");
    	if (s.length() == 0) return "";
    	if (s.length() == 1) return s;
    	int left = 0, right = 1;
        int[] store = {0, 0, 0};
        while (left < s.length() && right < s.length()) {
            int charAhead = s.charAt(right) - 'a';
            int currChar = s.charAt(right-1) - 'a';
            if (currChar < charAhead) {
                right++;
            } else {
                // The string we have seen so far up at this point is the largest string
                if (right - left > store[0]) {
                    store[0] = right-left;
                    store[1] = left;
                    store[2] = right;
                }
                left = right; 
                right++;
            }
        }

        return s.substring(store[1], store[2]);
    }

    public static void main(String[] args) {
        // Test One
    	Solution sol = new Solution();
        String res = sol.longestAlphabeticalSubstring("abfcj");
        System.out.println(res);
        res = sol.longestAlphabeticalSubstring("abaflmnoa");
        System.out.println(res);
        res = sol.longestAlphabeticalSubstring("zyma");
        System.out.println(res);
    }
}