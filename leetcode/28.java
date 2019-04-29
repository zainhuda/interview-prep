class Solution {
    // two pointers
    // O(n)
    public int strStr(String haystack, String needle) {
        if (needle.equals("")) {
            return 0;
        } else if (haystack.length() < needle.length()) {
            return -1;
        }
        int runner = 0;
        int pointer = 0;
        int needleC = 0;
        while (runner != haystack.length()) {
            // Check if letter is the same as needle
            if (haystack.charAt(runner) == needle.charAt(0)) {
                needleC = 0;
                while(haystack.charAt(runner) == needle.charAt(needleC)) {
                    needleC++;
                    runner++;
                    if (needleC == needle.length()) {
                        return pointer;
                    }
                    if (runner == haystack.length()) {
                        return -1;
                    }
                }
                pointer++;
                runner = pointer;
            } else {
                pointer++;
                runner++;
            }
        }
        return -1;
    }
}
