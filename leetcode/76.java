class Solution {
    public String minWindow(String s, String t) {
        // see notes in notebook
        // building freq dictionary for string t 
        Map<Character, Integer> T = new HashMap<>();
        for (Character c : t.toCharArray()) {
            int count = T.getOrDefault(c, 0);
            T.put(c, count+1);
        }
        
        int target = T.size();
        Map<Character, Integer> S = new HashMap<>();
        int left = 0, right = 0, formed = 0;
        
        int[] res = {-1, 0, 0};
    
        while (right < s.length()) {
            int count = S.getOrDefault(s.charAt(right), 0);
            S.put(s.charAt(right), count+1);
            
            if (T.containsKey(s.charAt(right)) && S.get(s.charAt(right)).intValue() == T.get(s.charAt(right)).intValue()) {
                formed++;
            }
            
            while (left <= right && formed == target) {
                S.put(s.charAt(left), S.get(s.charAt(left)) - 1);
                // update ans 
                if (res[0] == -1 || right-left+1 < res[0]) {
                    res[0] = right - left + 1;
                    res[1] = left;
                    res[2] = right;
                }
                if (T.containsKey(s.charAt(left)) && S.get(s.charAt(left)).intValue() < T.get(s.charAt(left)).intValue()) {
                    formed--;
                }
                left++;
            }
            right++;
        }
        return res[0] == -1 ? "" : s.substring(res[1], res[2]+1);
    }
}