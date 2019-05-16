class Solution {
    // two counters
    // one for name, one for type
    // if first and 
    public boolean isLongPressedName(String name, String typed) {
        int j = 0;
        for(char c: name.toCharArray()) {
            if (j == typed.length()) {
                return false;
            }
            
            if (typed.charAt(j) != c) {
                if (j == 0) {
                    return false;
                }
                // case: prev char is not same as curr then block has interruption that isnt 
                // == prev c
                if (typed.charAt(j-1) != typed.charAt(j)) {
                    return false;
                }
                char k = typed.charAt(j);
                while (j < typed.length() && typed.charAt(j) == k) {
                    j++;
                }
                
                if (j == typed.length() || typed.charAt(j) != c) {
                    return false;
                }
            }
            j++;
       }
        return true;
    }
}
