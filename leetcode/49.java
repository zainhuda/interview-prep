class Solution {
    // utilize hashmaps and sorting babyyyyyy
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List> builder = new HashMap<>();
        for (String word: strs) {
            // innit
            char[] chars = word.toCharArray();
            // sort to "normalize"
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!builder.containsKey(key)) builder.put(key, new ArrayList<>());
            builder.get(key).add(word);
        }
        return new ArrayList(builder.values());
    }
    
}