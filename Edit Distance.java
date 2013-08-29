public class Solution {
    public int minDistance(String word1, String word2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char []w1 = word1.toCharArray(), w2 = word2.toCharArray();
        int l1 = w1.length, l2 = w2.length;
        
        int [][]dp = new int[l1+1][l2+1];
        
        for (int i = 1; i <= l1; ++i)
            dp[i][0] = i;
            
        for (int i = 1; i <= l2; ++i)
            dp[0][i] = i;
            
        for (int i = 1; i <= l1; ++i)
            for (int j = 1; j <= l2; ++j) {
                dp[i][j] = Math.min(1+dp[i-1][j], 1+dp[i][j-1]);
                
                if (w1[i-1] != w2[j-1])
                    dp[i][j] = Math.min(1+dp[i-1][j-1], dp[i][j]);
                else
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i][j]);
            }
            
        return dp[l1][l2];
    }
}