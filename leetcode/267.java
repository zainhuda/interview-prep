class Solution {
    public List<String> generatePalindromes(String s) {
        // backtracking solution
        // we only need to use half of chars if it can be made into a palindrome
        
        int[] freq = new int[128];
        String middle = "";
        for (char c : s.toCharArray()) freq[c]++;
        int oddNums = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] % 2 == 1) {
                oddNums++;
                if (oddNums > 1) return new ArrayList<String>();
            }
        }
        // bag of characters that can be used
        List<Character> bag = new ArrayList<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] % 2 != 0) middle += (char) i;
            for (int j = 0; j < freq[i]/2; j++) bag.add((char) i);
        }
        List<String> res = new ArrayList<>();
        builder(bag, new boolean[bag.size()], new StringBuilder(), middle, res);
        
        return res;
        
     
    }
    
    public void builder(List<Character> bag, boolean[] visited, StringBuilder sb, String mid, List<String> res) {
        if (sb.length() == bag.size()) {
            res.add(sb.toString() + mid + sb.reverse().toString());
            sb.reverse();
            return;
        }
        
        for (int i = 0; i < bag.size(); i++) {
            // skip dups
            if (i > 0 && bag.get(i) == bag.get(i-1) && !visited[i-1]) continue;
            
            if (!visited[i]) {
                visited[i] = true;
                sb.append(bag.get(i));
                builder(bag, visited, sb, mid, res);
                sb.deleteCharAt(sb.length()-1);
                visited[i] = false;
            }
        }
    }
}