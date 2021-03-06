class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> store = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            store.put(s.charAt(i), store.getOrDefault(s.charAt(i), 0) + 1);
        }
        if (store.containsValue(1)) {
            for (int i = 0; i < s.length(); i++) {
                if (1 == store.get(s.charAt(i))) {
                    return i;
                }
            }
        }
        return -1;
    }
}
