class Solution {
    // O(1) space is trivial, uses XOR 
    public int singleNumber(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for (int i : nums) {
            if (!res.contains(i)) {
                res.add(i);
            } else {
                res.remove(i);
            }
        }
        Integer[] resl = res.toArray(new Integer[0]);
        return resl[0];
    }
}
