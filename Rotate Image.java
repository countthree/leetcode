public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = matrix.length;
        int layer = 0;
        
        while (n > 1) {
            for (int i = 0; i < n - 1; ++i) {
                int t = matrix[layer][layer+i];
                matrix[layer][layer+i] = matrix[layer+n-1-i][layer];
                matrix[layer+n-1-i][layer] = matrix[layer+n-1][layer+n-1-i];
                matrix[layer+n-1][layer+n-1-i] = matrix[layer+i][layer+n-1];
                matrix[layer+i][layer+n-1] = t;
            }
            
            ++layer;
            n -= 2;
        }
    }
}