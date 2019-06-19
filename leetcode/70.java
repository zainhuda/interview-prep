class Solution {
    // recursive naive approach
    public int climbStairs(int n) {
        int mem[] = new int[n+1];
        return sol(0, n, mem);
    }
    
    public int sol(int i, int n, int mem[]) {
        if (i > n) {
            return 0;
        }
    
        if (i == n) {
            return 1;
        }
        
        if (mem[i] > 0) {
            return mem[i];
        }
        
        mem[i] = sol(i+1, n, mem) + sol(i+2, n, mem);
        return mem[i];
    }
}
