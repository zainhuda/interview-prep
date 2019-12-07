class Solution {
    public boolean isPossible(int[] nums) {
        // greedily choose numbers to make a sequence
        // when we have used all numbers we remove
        // if we are left with less han 3 numbers then we return false
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        Map<Integer, Integer> built = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == 0) continue;
            if (built.getOrDefault(num, 0) > 0) {
                built.put(num, built.get(num)-1);
                built.put(num+1, built.getOrDefault(num+1, 0)+1);
            } else if (map.getOrDefault(num+1, 0) > 0 && map.getOrDefault(num+2, 0) > 0) {
                map.put(num+1, map.get(num+1)-1);
                map.put(num+2, map.get(num+2)-1);
                built.put(num+3, built.getOrDefault(num+3, 0)+1);
            } else {
                return false;
            }
            map.put(num, map.get(num)-1);
        }
        
        return true;
    }
}