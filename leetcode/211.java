class WordDictionary {
    // we need to support the "." operation
    // we can naaively check all nodes for the "." and see if another exists
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }
    /** Initialize your data structure here. */
    private TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node = root;
        return searchHelper(word, 0, node);
    }
    
    private boolean searchHelper(String word, int i, TrieNode node) {
        if (i == word.length()) return node.isEnd;
        char curr = word.charAt(i);
        if (curr != '.') {
            return node.children[curr - 'a'] != null && searchHelper(word, i+1, node.children[curr-'a']);
        } else {
            for (int j = 0; j < node.children.length; j++) {
                if (node.children[j] != null && searchHelper(word, i+1, node.children[j])) {
                    return true;
                } 
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */