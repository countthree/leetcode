public class Solution {
    public int searchInsert(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int low = 0, high = A.length - 1;
            
        while (low <= high) {
            if (low == high)
                return A[low] >= target ? low : low + 1;
                
            int mid = (low + high) / 2;
            
            if (A[mid] == target)
                return mid;
                
            if (A[mid] > target) {
                high = mid;
            } else {
                if (target < A[mid+1])
                    return mid + 1;
                
                low = mid + 1;
            }
        }
        
        return -1;
    }
}