class Solution {
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> store = new HashSet<>();
        int count = 0;
        for (char jewel : J.toCharArray()) {
            store.add(jewel);
        }
        for (char stone : S.toCharArray()) {
            if (store.contains(stone)) {
                count++;
            }
        }
        return count;
    }
}
