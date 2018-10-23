class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] bits = new int[256];
        int max = 0, index = 0;
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            if(bits[s.charAt(i)] == 0) {
                count++;
            }
            bits[s.charAt(i)]++;
            while(count > k) {    // count > k delete char from the substring
                bits[s.charAt(index)]--;
                if(bits[s.charAt(index)] == 0) {
                    count--;
                }
                index++;
            }
            max = Math.max(max, i - index + 1);
        }
        return max;
    }
}
