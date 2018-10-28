class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] store = new boolean[s.length() + 1];
        store[0] = true; //base case
         for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(store[j] && dict.contains(s.substring(j, i))){
                    store[i] = true;
                    break;
                }
            }
        }
        return store[s.length()];
    }
}
