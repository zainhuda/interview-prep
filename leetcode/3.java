class Solution {
    public int lengthOfLongestSubstring(String s) {
        // two pointers
        int longestString = 0;
        int index = 0;
        HashMap<Character, Integer> store = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (store.containsKey(s.charAt(i))) {
                index = Math.max(store.get(s.charAt(i)), index);
            }
            longestString = Math.max(longestString, i - index + 1);
            store.put(s.charAt(i), i + 1);
        }
        return longestString;
    }
}
