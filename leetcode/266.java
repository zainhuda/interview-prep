class Solution {
    public boolean canPermutePalindrome(String s) {
        // freq count, if we have more than one character with odd num
        int[] sArr = new int[128];
        for (char c : s.toCharArray()) sArr[c]++;
        boolean oddSeen = false;
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] % 2 == 1) {
                if (oddSeen) return false;
                oddSeen = true;
            }
        }
        return true;
    }
}