public class Solution {
    public int[][] generateMatrix(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int [][]matrix = new int[n][n];
        
        int w = n, next = 1;
        int layer = 0;
        
        while (w > 0) {
            next = addLayer(matrix, layer, w, next);

            ++layer;
            w = n - 2 * layer;
        }
        
        return matrix;
    }
    
    public int addLayer(int [][]matrix, int layer, int w, int val) {
        for (int i = 0; i < w; ++i)
            matrix[layer][layer+i] = val++;
            
        for (int i = 1; i < w-1; ++i)
            matrix[layer+i][layer+w-1] = val++;
        
        if (w != 1) {
            for (int i = w-1; i >= 0; --i)
                matrix[layer+w-1][layer+i] = val++;
                
            for (int i = w-2; i >= 1; --i)
                matrix[layer+i][layer] = val++;
        }
        
        return val;
    }
}