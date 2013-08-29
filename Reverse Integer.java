public class Solution {
    public int reverse(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean neg = x < 0;
        if (neg)
            x = -x;
        int res = 0;
        
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
        }
        
        
        return neg ? -res : res;
    }
}
