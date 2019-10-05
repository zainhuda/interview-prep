class StreamChecker {

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        boolean isEnd;
    }
    
    TrieNode root;
    StringBuilder sb;
    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        for (String word : words) {
            TrieNode curr = root;
            for (int i = word.length()-1; i >= 0; i--) {
                char c = word.charAt(i);
                if (curr.next[c - 'a'] == null) curr.next[c - 'a'] = new TrieNode();
                curr = curr.next[c - 'a'];
            }
            curr.isEnd = true;
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode node = root;
        for (int i = sb.length()-1; i >= 0 && node != null; i--) {
            char c = sb.charAt(i);
            node = node.next[c - 'a'];
            if (node != null && node.isEnd) return true;
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */