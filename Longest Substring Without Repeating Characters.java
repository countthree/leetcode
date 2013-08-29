public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (s.length() <= 1)
            return s.length();
            
        boolean []map = new boolean[256];
        
        char []a = s.toCharArray();
        
        int res = 1;
        int l = 0, r = 0;
        
        while (r < a.length) {
            if (map[a[r]]) {
                if (r - l > res)
                    res = r - l;
                
                while (a[l] != a[r]) {
                    map[a[l]] = false;
                    ++l;
                }
                
                ++l;
                ++r;
            } else {
                map[a[r]] = true;
                ++r;
            }
        }
        
        if (r - l > res)
            res = r - l;
            
        return res;
    }
}
