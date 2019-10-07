class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // distinct integers, we can just do simple permuations
        List<List<Integer>> res = new ArrayList<>();
        builder(res, nums, new boolean[nums.length], new ArrayList<>());
        return res;
    }
    
    public void builder(List<List<Integer>> res, int[] nums, boolean[] visited, List<Integer> temp) {
        if (temp.size() == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            temp.add(nums[i]);
            builder(res, nums, visited, temp);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }
}