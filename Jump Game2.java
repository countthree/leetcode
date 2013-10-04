public class Solution {
    public int jump(int[] A) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int minStep = 0;
        int start = 0, end = 0;
        
        while (end < A.length - 1) {
            ++minStep;
            int max = end;
            
            for (int i = start; i <= end; ++i) {
                if (A[i] + i >= A.length - 1)
                    return minStep;
                else if (A[i] + i > max)
                    max = A[i] + i;
            }
            
            if (max == end)
                return -1;
            
            start = end + 1;
            end = max;
        }
        
        return minStep;
    }
}