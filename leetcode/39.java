class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtracker(ans, new ArrayList<Integer>(), candidates, target, 0);
        return ans;
    }
    
    public void backtracker(List<List<Integer>> list, List<Integer> tempAns, int[] candidates, int remainder, int start) {
        if (remainder == 0) {
            list.add(new ArrayList<>(tempAns));
            return;
        } else if (remainder < 0) {
            return;
        } else {
            for (int i = start; i<candidates.length; i++) {
                tempAns.add(candidates[i]);
                backtracker(list, tempAns, candidates, remainder-candidates[i], i);
                tempAns.remove(tempAns.size()-1);
            }
        }
    }

