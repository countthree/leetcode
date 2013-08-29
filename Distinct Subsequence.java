public class Solution {
    public int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l1 = S.length(), l2 = T.length();
        
        int [][]dp = new int[l1+1][l2+1];
        
        for (int i = 0; i <= l1; ++i)
            dp[i][0] = 1;
            
        for (int j = 1; j <= l2; ++j)
            for (int i = j; i <= l1; ++i) {
                dp[i][j] = dp[i-1][j];
                if (S.charAt(i-1) == T.charAt(j-1))
                    dp[i][j] += dp[i-1][j-1];
            }
            
        return dp[l1][l2];
    }
}