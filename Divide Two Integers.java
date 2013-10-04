public class Solution {
    public int divide(int dividend, int divisor) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        boolean neg = (dividend < 0) ^ (divisor < 0);
        long x = dividend, y = divisor;
		x = x < 0 ? -x : x;
		y = y < 0 ? -y : y;
        
        int ret = 0;
        while (x >= y) {
            int c = 0;
            while ((y << (c + 1)) <= x)
                ++c;
                
            x -= y << c;
            ret += 1 << c;
        }
        
        return neg ? -ret : ret;
    }
}