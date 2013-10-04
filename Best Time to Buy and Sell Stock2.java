public class Solution {
    public int maxProfit(int[] prices) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int ret = 0;
        for (int i = 1; i < prices.length; ++i)
            if (prices[i] > prices[i-1])
                ret += prices[i] - prices[i-1];
                
        return ret;
    }
}