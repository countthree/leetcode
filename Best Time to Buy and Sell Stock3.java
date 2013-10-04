public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = prices.length;
        
        if (l == 0)
            return 0;
            
        int[] max= new int[l];
        int low = prices[0];
        
        for (int i = 1; i < l; ++i) {
            max[i] = Math.max(prices[i] - low, max[i-1]);
            
            if (prices[i] < low)
                low = prices[i];
        }
        
        int high = prices[l-1];
        int ret = max[l-1];
        int nextProfit = 0;
        for (int i = l - 2; i >= 1; --i) {
            nextProfit = Math.max(high - prices[i], nextProfit);
            
            if (nextProfit + max[i-1] > ret)
                ret = nextProfit + max[i-1];
                
            if (prices[i] > high)
                high = prices[i];
        }
        
        return ret;
    }
}