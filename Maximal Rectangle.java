public class Solution {
    public int maximalRectangle(char[][] matrix) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        int m = matrix.length;
        if (m == 0)
            return 0;
            
        int n = matrix[0].length;
        int[] l = new int[n];
        int[] r = new int[n];
        int[] h = new int[n];
        
        for (int i = 0; i < n; ++i)
            r[i] = n;

        int ret = 0;
        
        for (int i = 0; i < m; ++i) {
            int left = 0;
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == '1') {
                    ++h[j];
                    l[j] = Math.max(l[j], left);
                } else {
                    h[j] = 0;
                    left = j + 1;
                    l[j] = 0;
                    r[j] = n;
                }
            }

            int right = n;            
            for (int j = n - 1; j >= 0; --j) {
                if (matrix[i][j] == '1') {
                    r[j] = Math.min(r[j], right);
                    ret = Math.max(ret, h[j] * (r[j] - l[j]));
                } else {
                    right = j;
                }
            }
        }
        
        return ret;
    }
}