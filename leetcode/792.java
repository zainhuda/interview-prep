class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        List<Integer[]>[] letters = new List[27];
        
        for (int i = 0; i <= 26; i++) {
            letters[i] = new ArrayList();
        }
        
        // Storing where it is in words, and the character that is waiting next
        for (int i = 0; i < words.length; i++) {
            letters[words[i].charAt(0) - 'a'+1].add(new Integer[] {i, 1});
        }
        
        for (char c : S.toCharArray()) {
            // we do this because wordsToRemove is a reference to letters[c]
            List<Integer[]> wordsToRemove = new ArrayList<>(letters[c- 'a'+1]);
            letters[c -'a'+1].clear();
            for (Integer[] word : wordsToRemove) {
                letters[word[1] < words[word[0]].length() ? words[word[0]].charAt(word[1]++) - 'a'+1: 0].add(word);
            }
        }
        return letters[0].size();
    }
}