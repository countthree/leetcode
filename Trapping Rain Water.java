public class Solution {
    public int trap(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int[] max = new int[A.length];
        for (int i = 0; i < A.length; ++i)
            max[i] = (i == 0) ? A[i] : Math.max(max[i-1], A[i]);
            
        int right = 0;
        int ret = 0;
        for (int i = A.length - 1; i > 0; --i) {
            int height = Math.min(max[i - 1], right);
            right = Math.max(right, A[i]);
            
            if (height > A[i])
                ret += height - A[i];
        }
        
        return ret;
    }
}