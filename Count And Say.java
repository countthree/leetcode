public class Solution {
    public String countAndSay(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String s = "1";
        
        for (int i = 1; i < n; ++i)
            s = nextString(s);
            
        return s;
    }
    
    public String nextString(String s) {
        StringBuilder builder = new StringBuilder();
        int i = 0;
        
        while (i < s.length()) {
            int count = 0;
            char c = s.charAt(i);
            
            while (i < s.length() && c == s.charAt(i)) {
                ++i;
                ++count;
            }
            
            builder.append(count);
            builder.append(c);
        }
        
        return builder.toString();
    }
}