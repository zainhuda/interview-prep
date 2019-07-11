class Solution {
    // greedy approach 
    // check stations where there is enough gas to go the next station
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                int ret = canComplete(i, gas, cost);
                if (ret != -1) return ret;
            }
        }
        return -1;
    }
    
    public int canComplete(int start, int[] gas, int[] cost) {
        int currGas = gas[start]-cost[start];
        // we begin our journey
        int curr = start+1;
        if (curr > gas.length-1) curr = 0;
        while (curr != start) {
            currGas = currGas + gas[curr];
            if (currGas < cost[curr]) return -1;
            currGas = currGas - cost[curr];
            curr++;
            if (curr > gas.length-1) curr = 0;
        }
        
        return start;
        
    }
}