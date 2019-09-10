class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> each = new ArrayList<>();
        builder(res, each, 0, nums);
        return res;
    }
    
    public void builder(List<List<Integer>> res, List<Integer> build, int i, int[] nums) {
        if (i <= nums.length) {
            res.add(new ArrayList<>(build));
        }
        while (i < nums.length) {
            build.add(nums[i]);
            builder(res, new ArrayList<>(build), i+1, nums);
            build.remove(build.size()-1);
            i++;
            while (i < nums.length && nums[i] == nums[i-1]) i++;
        }
        return;
    }
}