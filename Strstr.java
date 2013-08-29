public class Solution {
    public String strStr(String haystack, String needle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        char []s = haystack.toCharArray();
        char []t = needle.toCharArray();
        
        for (int i = 0; i < s.length-t.length+1; ++i) {
            int j = 0;
            
            while (j < t.length) {
                if (s[i+j] == t[j])
                    ++j;
                else 
                    break;
            }
            
            if (j == t.length)
                return haystack.substring(i);
        }
        
        return null;
    }
}
