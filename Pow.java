public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean neg = n < 0 ? true : false;
        n = Math.abs(n);
        
        double res = 1;
        
        int bit = (int) (Math.log(n) / Math.log(2));
        for (; bit >= 0; --bit) {
            res *= res;
            if (((n >>> bit) & 1) != 0)
                res *= x;
        }
        
        return neg ? 1/res : res;
    }
}