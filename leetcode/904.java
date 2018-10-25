class Solution {
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> seen = new HashMap<>();
        int index = 0, totalFruit = 0;
        for (int i = 0; i < tree.length; i++) {
            seen.put(tree[i], seen.getOrDefault(tree[i], 0) + 1);
            while (seen.size() >= 3) {
                seen.put(tree[index], seen.get(tree[index]) - 1);
                if (seen.get(tree[index]) == 0) {
                    seen.remove(tree[index]);
                }
                index++;
            }
            totalFruit = Math.max(totalFruit, i - index + 1);
        }
        return totalFruit;
    }
}
