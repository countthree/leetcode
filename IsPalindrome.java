public class Solution {
    public boolean isPalindrome(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
                // DO NOT write main() function
        int y = x;
        
        boolean neg = x < 0;
        if (neg)
            x = -x;
        int res = 0;
        
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        
        
        return y == res;
    }
}
