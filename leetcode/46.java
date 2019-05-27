class Solution {
    // something of a pointer/recursive approach 
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), nums);
        return result;
    }
    
    public void backtrack(List<List<Integer>> result, List<Integer> num, int[] nums) {
        if (num.size() == nums.length) {
            result.add(new ArrayList<>(num));
            return;
        } else {
            for (int i = 0; i<nums.length; i++) {
                if (num.contains(nums[i])) continue;
                num.add(nums[i]);
                backtrack(result, num, nums);
                num.remove(num.size()-1);
            }
        }
    }
}
