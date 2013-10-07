public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] dp = new int[s.length()];
        int ret = 0;
        for (int i = s.length() - 2; i >= 0; --i) {
            if (s.charAt(i) == '(') {
                int right = i + 1 + dp[i + 1];
                if (right < s.length() && s.charAt(right) == ')') {
                    dp[i] = dp[i + 1] + 2;
                    
                    if (right + 1 < s.length())
                        dp[i] += dp[right + 1];
                }
                    
                ret = Math.max(ret, dp[i]);
            }
        }
        
        return ret;
    }
}