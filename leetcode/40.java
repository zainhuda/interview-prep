class Solution {
    // use backtracking to try solutions, however do not include the current val 
    // as it has to be UNIQUE
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtracker(ans, new ArrayList<>(), candidates, target, 0);
        return ans;
    }
    
    private void backtracker(List<List<Integer>> sol, List<Integer> tempAns, int[] candidates, int remainder, int start) {
        if (remainder == 0) {
            Collections.sort(tempAns);
            if (!sol.contains(tempAns)) {
                sol.add(new ArrayList<>(tempAns));
            }
            return;
        } else if (remainder < 0) {
            return;
        } else {
            for (int i = start; i<candidates.length; i++) {
                tempAns.add(candidates[i]);
                backtracker(sol, tempAns, candidates, remainder-candidates[i], i+1);
                tempAns.remove(tempAns.size()-1);
            }
        }
    }
}
