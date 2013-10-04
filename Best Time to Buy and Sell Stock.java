public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = prices.length;
        if (l == 0)
            return 0;
            
        int[] max = new int[l];
        max[l-1] = prices[l-1];
        
        for (int i = l - 2; i >= 0; --i)
            max[i] = Math.max(prices[i], max[i+1]);
            
        int ret = 0;
        for (int i = 0; i < l - 1; ++i)
            if (max[i+1] - prices[i] > ret)
                ret = max[i+1] - prices[i];
                
        return ret;
    }
}