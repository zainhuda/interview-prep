class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> answer = new ArrayList<>();
        if (digits.isEmpty()) return answer;
        String[] store = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        answer.add("");
        char[] c = digits.toCharArray();
        for (char digit : c) {
            String current = store[Character.getNumericValue(digit)];
            ArrayList<String> result = new ArrayList<>();
            for (char letter : current.toCharArray()) {
                for (String str : answer) {
                    result.add(str + letter);
                }
            }
            answer = result;
        }
        Collections.sort(answer);
        return answer;
    }
}
