public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        int h = matrix.length;
        
        if (h == 0)
            return res;
            
        int w = matrix[0].length;
        
        int layer = 0;
        
        while (h > 0 && w > 0) {
            addLayer(matrix, layer, w, h, res);
            
            w -= 2;
            h -= 2;
            ++layer;
        }
        
        return res;
    }
    
    public void addLayer(int [][]matrix, int layer, int w, int h, ArrayList<Integer> res) {
        for (int i = 0; i < w; ++i)
            res.add(matrix[layer][layer+i]);
            
        for (int i = 1; i < h-1; ++i)
            res.add(matrix[layer+i][layer+w-1]);
            
        if (h != 1) {
            for (int i = w-1; i >= 0; --i)
                res.add(matrix[layer+h-1][layer+i]);
        }
        
        if (w != 1) {
            for (int i = h-2; i >= 1; --i)
                res.add(matrix[layer+i][layer]);
        }
    }
}