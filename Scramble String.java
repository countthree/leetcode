public class Solution {
    public boolean isScramble(String s1, String s2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s1.length() != s2.length())
            return false;
        
        int len = s1.length();
        boolean[][][] dp = new boolean[len][len][len+1];
        
        for (int i = len - 1; i >= 0; --i)
            for (int j = len - 1; j >= 0; --j)
                for (int k = 0; k <= len - Math.max(i, j); ++k) {
                    if (s1.substring(i, i + k).equals(s2.substring(j, j + k))) {
                        dp[i][j][k] = true;
                    } else {
                        for (int p = 1; p < k; ++p) {
                            if ((dp[i][j][p] && dp[i+p][j+p][k-p]) 
                            || (dp[i][j+k-p][p] && dp[i+p][j][k-p])) {
                                dp[i][j][k] = true;
                                break;
                            }
                        }
                    }
                }
                
        return dp[0][0][len];
    }
}