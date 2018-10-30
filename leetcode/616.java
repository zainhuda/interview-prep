public class Solution {
    public String addBoldTag(String s, String[] dict) {
        boolean[] bold = new boolean[s.length()];
        int end = 0;

        for(int i = 0; i < s.length(); i++) {
            boolean found = false;
            for (String word:dict){
                if (s.startsWith(word,i)){
                    found = true;
                    end = Math.max(end, i+word.length());
                }
            }
            int j = i;
            if (found) {   //once we find a word matches, then set all the index of dp array to be true.
                while (j < end){
                    bold[j] = found;
                    j++;
                }
            }
        }

        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!bold[i]) {
                ret.append(s.charAt(i));
                continue;
            }
            // else we add bold tags
            int j = i;
            while (j < s.length() && bold[j]) {
                j++;
            }
            ret.append("<b>"+s.substring(i, j)+"</b>");
            i = j-1; // it is then incremented to j or loop is quit
        }
        return ret.toString();
    }
}
