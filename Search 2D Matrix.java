public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = matrix.length;
        
        if (m == 0)
            return false;
            
        int n = matrix[0].length;
        
        int low = 0, high = m * n - 1;
        
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            
            int num = matrix[mid/n][mid%n];
            
            if (num == target)
                return true;
            else if (num < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        
        return false;
    }
}