class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) return 0;
        s = s.trim();
        char[] chArray = s.toCharArray();
        int count = 0;
        for (int i = s.length()-1; i>=0; i--) {
            if (chArray[i] != ' ') count++;
            else break;
        }
        return count;
    }
}
