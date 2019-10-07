class Solution {
    public boolean isAnagram(String s, String t) {
        // constant space, O(n)
        int[] sArr = new int[26];
        int[] tArr = new int[26];
        for (char c : s.toCharArray()) sArr[c-'a']++;
        for (char c : t.toCharArray()) tArr[c-'a']++;
        
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] != tArr[i]) return false;
        }
        return true;
    }
}