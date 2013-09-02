public class Solution {
    public int search(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int low = 0, high = A.length-1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (A[mid] == target)
                return mid;
            
            if (A[low] <= A[mid]) {
                if (target < A[mid] && target >= A[low])
                    high = mid - 1;
                else
                    low = mid + 1;
            } else {
                if (target > A[mid] && target <= A[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            
        }
        
        return -1;
    }
}