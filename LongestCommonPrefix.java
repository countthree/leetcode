public class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (strs.length == 0)
            return "";
            
        String s = strs[0];
        
        for (int i = 0; i < s.length(); ++i) {
            for (String x : strs) {
                if (x.length() == i)
                    return x;
                
                if (x.charAt(i) != s.charAt(i))
                    return x.substring(0, i);
            }
        }
        
        return s;
    }
}
