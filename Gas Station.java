public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int ret = 0;
        int sum = 0, total = 0;
        
        for (int i = 0; i < gas.length; ++i) {
            int tmp = gas[i] - cost[i];
            
            sum += tmp;
            total += tmp;
            
            if (sum < 0) {
                sum = 0;
                ret = i + 1;
            }
        }
        
        return total >= 0 ? ret : -1;
    }
}c