public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = s.length();
        boolean[][] dp = new boolean[l][l];
        
        for (int sub = 1; sub <= l; ++sub)
            for (int i = 0; i + sub - 1 < l; ++i) {
                int j = i + sub - 1;
                
                if (sub == 1)
                    dp[i][j] = true;
                else if (sub == 2)
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                else
                    dp[i][j] = (dp[i+1][j-1] && (s.charAt(i) == s.charAt(j)));
            }
            
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        ArrayList<String> temp = new ArrayList<String>();
        
        helper(ret, temp, 0, s, dp);
        
        return ret;
    }
    
    public void helper(ArrayList<ArrayList<String>> ret, ArrayList<String> temp, int start, String s, boolean[][] dp) {
        if (start == s.length()) {
            ArrayList<String> part = new ArrayList<String>(temp);
            ret.add(part);
            return;
        }
        
        for (int j = start; j < s.length(); ++j) {
            if (dp[start][j]) {
                temp.add(s.substring(start, j + 1));
                helper(ret, temp, j + 1, s, dp);
                temp.remove(temp.size()-1);
            }
        }
    }
}