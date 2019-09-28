class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        // OPTIMAL SOLUTION USES A TRIE WITH DFS
        // dfs problem
        // adjacent horizontally or vertically neighboring 
        // we can keep track of the word we have built so far with stringbuilder
        // if we see start of a word, we dfs it ???
        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (String word : words) {
                    if (word.charAt(0) == board[i][j]) {
                        boolean[][] visited = new boolean[board.length][board[0].length];
                        dfs(board, word, visited, 0, i, j, result);
                    }
                }    
            }
        }
        
        return new ArrayList<String>(result);
    }
    
    private void dfs(char[][] board, String word, boolean[][] visited, int wordChar, int i, int j, Set<String> result) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || wordChar >= word.length()) return;
        if (visited[i][j]) return;
        if (word.charAt(wordChar) != board[i][j]) return;
        if (wordChar == word.length()-1 && word.charAt(wordChar) == board[i][j]) {
            result.add(word);
            return;
        }
        visited[i][j] = true;
        dfs(board, word, visited, wordChar+1, i+1, j, result); 
        dfs(board, word, visited, wordChar+1, i-1, j, result);
        dfs(board, word, visited, wordChar+1, i, j+1, result);
        dfs(board, word, visited, wordChar+1, i, j-1, result);  
        visited[i][j] = false;
    }
}