class Solution {
    public boolean isAnagram(String s, String t) {
        // frequency map using hashmap 
        // alternative is a 26int array using it as a freq count for characters
        Map<Character, Integer> store = new HashMap<>();
        for (Character c : s.toCharArray()) {
            if (store.containsKey(c)) {
                store.put(c,store.get(c)+1);
            } else {
                store.putIfAbsent(c, 1);                
            }
        }
        
        for (Character c : t.toCharArray()) {
            if (store.containsKey(c)) {
                store.put(c, store.get(c)-1);
            } else {
                return false;
            }
        }
        
        for (Character key : store.keySet()) {
            if (store.get(key) != 0) return false;
        }
        
        return true;
    }
}