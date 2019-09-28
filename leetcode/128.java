class Solution {
    public int longestConsecutive(int[] nums) {
        // using a hashset to just look for the next +1 number
        Set<Integer> store = new HashSet<>();
        for (int num : nums) {
            store.add(num);
        }
        
        int maxLen = 0;
        for (int num : store) {
            if (!store.contains(num-1)) {
                int currLen = 1;
                int currNum = num;
                
                while (store.contains(currNum+1)) {
                    currNum += 1;
                    currLen += 1;
                }
                
                maxLen = Math.max(currLen, maxLen);
            }
        }
        
        return maxLen;
    }
}