class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // using int[26] for key
        Map<String, ArrayList<String>> result = new HashMap<>();
        for (String s : strs) {
            int[] count = new int[26];
            for (Character c : s.toCharArray()) {
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(s);
        }
        return new ArrayList(result.values());
    }
}