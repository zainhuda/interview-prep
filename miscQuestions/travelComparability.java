import java.util.*;

class Solution {
	public int travelComparability(String[] travel, String[][] friends) {
        // Sets intersection find solution
		if (travel == null || friends == null) throw new IllegalArgumentException("Pass in string array!");
		if (travel.length == 0 || friends.length == 0) return -1;
		Set<String> myPref = new HashSet<>(Arrays.asList(travel));
		Set<String> temp = new HashSet<>();
		int result = -1, max = 0;
		for (int i = 0; i < friends.length; i++) {
			Set<String> curr = new HashSet<>(Arrays.asList(friends[i]));
			temp.addAll(curr);
			temp.retainAll(myPref);
			if (temp.size() > max) {
				max = temp.size();
				result = i;
			}
			temp.clear();
		}
        return result;
    }

    public static void main(String[] args) {
        // Testing
    	Solution sol = new Solution();
    	int result = sol.travelComparability(new String[] {"YYZ", "JFK", "SFO"}, new String[][] {{"YXU", "YYZ"},{"SFO", "BOS", "JFK"},{"LGA"}});
    	System.out.println(result);
    	result = sol.travelComparability(new String[] {"YYR"}, new String[][] {{"A"},{"B"},{"LGA"}});
    	System.out.println(result);
    }
}