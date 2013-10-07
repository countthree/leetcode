public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        int max = 0;
        for (String w : dict)
            max = Math.max(w.length(), max);
            
        for (int i = 0; i < s.length(); ++i) {
            for (int j = i + 1 - max; j <= i; ++j) {
                if (j < 0)
                    continue;
                
                if (dp[j] && dict.contains(s.substring(j, i + 1))) {
                    dp[i + 1] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
}