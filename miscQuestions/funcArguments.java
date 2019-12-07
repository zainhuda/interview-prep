// https://leetcode.com/discuss/interview-question/391709/Google-or-Onsite-or-Find-Function-Arguments
import java.util.*;

class Solution {
	public int f(int x, int y) {
		return x + y;
	}
    public List<List<Integer>> funcArgument(int z) {
    	List<List<Integer>> res = new ArrayList<>();
    	int x = 1;
    	int y = Integer.MAX_VALUE;
    	while (f(x,1) <= z) {
    		y = bSearch(x, y, z);
    		if (y != -1) {
    			List<Integer> temp = new ArrayList<>();
    			temp.add(x);
    			temp.add(y);
    			res.add(temp);
    		} else {
    			y = Integer.MAX_VALUE;
    		}
    		x++;
    	}
        return res;
    }
    
    public int bSearch(int x, int yMax, int z) {
    	int y = 1;
    	while (y <= yMax) {
    		int mid = y + (yMax-y)/2;
    		if (f(x, mid) == z) {
    			return mid;
    		} else if (f(x,mid) < z) {
    			y = mid+1;
    		} else {
    			yMax = mid-1;
    		}
    	}
    	return -1;
    }
  
    
    
    public static void main(String[] args) {
    	Solution sol = new Solution();
    	List<List<Integer>> res = sol.funcArgument(5);
        System.out.println(res);
    }
}