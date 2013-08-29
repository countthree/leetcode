public class Solution {
    public int[] plusOne(int[] digits) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int c = 1;
        int i = digits.length-1;
        
        while (i >= 0 && c != 0) {
            digits[i] += c;
            c = digits[i]/10;
            digits[i] %= 10;
            --i;
        }
        
        if (c == 0)
            return digits;
            
        int[] res = new int[digits.length + 1];
        
        res[0] = 1;
        
        for (i = 1; i < res.length; ++i)
            res[i] = digits[i-1];

        return res;
    }
}
