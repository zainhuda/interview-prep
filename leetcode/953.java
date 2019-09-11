class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // for each pair of words, we check the order, if it passes order, then we're good
        // we want fast lookup for order, so we can put it in a hashtable
        // Data Pre-processing
        char[] letters = order.toCharArray();
        Map<Character, Integer> store = new HashMap<>();
        for (int i = 0; i < letters.length; i++) {
            store.put(letters[i], i);
        }
        
        System.out.println(store);
        
        // Now we check each pair of words
        // Helper written for brevity
        for (int i = 1; i < words.length; i++) {
            if (!checker(words[i-1], words[i], store)) return false;
        }
        return true;
    }
    
    public boolean checker(String word1, String word2, Map<Character, Integer> store) {
        int len = Math.min(word1.length(), word2.length()); 
        for (int i = 0; i < len; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                if (store.get(word1.charAt(i)) < store.get(word2.charAt(i))) {
                    return true;
                } else {
                    return false;
                }
            } 
        }
        if (word1.length() > word2.length()) return false;
        return true;
    }
}