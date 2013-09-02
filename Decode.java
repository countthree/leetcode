public class Solution {
    public int numDecodings(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char []a = s.toCharArray();
        int l = a.length;
        
        if (l == 0)
            return 0;
        
        if (l == 1)
            return a[0] == '0' ? 0 : 1;
            
        int []dp = new int[2];
        dp[0] = 1;
        dp[1] = a[l-1] == '0' ? 0 : 1;
        
        for (int i = 2; i <= l; ++i) {
            if (a[l-i] == '0')
                dp[i%2] = 0;
            else if (a[l-i] == '1' || (a[l-i] == '2' && a[l-i+1] - '0' <= 6))
                dp[i%2] = dp[0] + dp[1];
            else
                dp[i%2] = dp[(i+1)%2];
        }
        
        return dp[l%2];
    }
}