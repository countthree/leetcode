public class Solution {
    public int maxSubArray(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int res = A[0];
        int current = 0;
        
        for (int i = 0; i < A.length; ++i) {
            int sum = current + A[i];
            
            if (sum > res)
                res = sum;
                
            if (sum <= 0) {
                current = 0;
            } else {
                current += A[i];
            }            
        }
        
        return res;
    }
}