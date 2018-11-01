class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        HashMap<Character, Integer> store = new HashMap<>();
        int index = 0;
        int runner = 0;
        int count = 0;
        int result = 0;
        while (runner < s.length()) {
            char curr = s.charAt(runner);
            store.put(curr, store.getOrDefault(curr, 0)+1);
            runner++;
            if (store.get(curr) == 1) count++;
            while (count > 2) {
                store.put(s.charAt(index), store.get(s.charAt(index))-1);
                if (store.get(s.charAt(index)) == 0) {
                    count--;
                }
                index++;
            }
            result = Math.max(result, runner - index);
        }
        return result;
    }
}
