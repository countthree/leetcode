public class Solution {
    public String longestPalindrome(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] a = s.toCharArray();
        int len = a.length;
            
        boolean[][] dp = new boolean[len][len];
            
        int start = 0, max = 1;
        
        for (int sub = 1; sub <= len; ++sub)
            for (int i = 0; i + sub - 1 < len; ++i) {
                int j = sub + i - 1;
                
                if (j - i == 0)
		            dp[i][j] = true;
                else if (j - i == 1)
                    dp[i][j] = (a[i] == a[j]);
                else
                    dp[i][j] = (dp[i+1][j-1] && (a[i] == a[j]));
                    
                if (dp[i][j]) {
                    max = sub;
                    start = i;
                }
            }
            
        return s.substring(start, start+max);
    }
}