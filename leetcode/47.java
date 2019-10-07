class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        // back tracking here also 
        // similar to 267
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        builder(nums, new boolean[nums.length], res, new ArrayList<Integer>());
        return res;
    }
    
    public void builder(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> built) {
        if (built.size() == nums.length) {
            res.add(new ArrayList<>(built));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            // if we have not used the previous number that's the same as this one
            // then we use it 
            if (i > 0 && nums[i] == nums[i-1] && !visited[i-1]) continue;
            built.add(nums[i]);
            visited[i] = true;
            builder(nums, visited, res, built);
            built.remove(built.size()-1);
            visited[i] = false;
        }
    }
}