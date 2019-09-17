class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // backtracking i think
        // might as well sort it
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        for (int i = 0; i < nums.length; i++) {
            build(res, new ArrayList<>(Arrays.asList(nums[i])), nums, i+1, nums[i]);
        }
        return res;
    }
    
    public void build(List<List<Integer>> res, List<Integer> curr, int[] nums, int i, int sum) {
        if (curr.size() > 3 || res.contains(curr)) {
            return;
        }
        if (sum == 0 && curr.size() == 3 && !res.contains(curr)) {
            res.add(new ArrayList<>(curr));
        }
        for (int j = i; j < nums.length; j++) {
            curr.add(nums[j]);
            build(res, curr, nums, j+1, sum+nums[j]);
            curr.remove(curr.size()-1);
        }
        return;
    }
}