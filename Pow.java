public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean neg = n < 0 ? true : false;
        n = Math.abs(n);
        
        double res = 1;
        
        for (int bit = 31; bit >= 0; --bit) {
            res *= res;
            if (((n >>> bit) & 1) != 0)
                res *= x;
        }
        
        return neg ? 1/res : res;
    }
}