class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> store = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            store.put(s.charAt(i), s.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (s.containsValue(1)) {
            for (int i = 0; i < s.length; i++) {
                if (s.charAt(i) == s.getValue(1)) {
                    return i;
                }
            }
        } else {
            return -1;
        }
    }
}
