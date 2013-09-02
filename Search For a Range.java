public class Solution {
    public int[] searchRange(int[] A, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int []res = new int[2];
        res[0] = findFirst(A, target);
        
        res[1] = res[0] == -1 ? -1 : findLast(A, target);
        return res;
    }
    
    public int findFirst(int []a, int t) {
        int low = 0, high = a.length-1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (t > a[mid]) {
                low = mid + 1;
            } else if (t < a[mid]) {
                high = mid - 1;
            } else {
                if (mid == low)
                    return mid;
                    
                if (a[mid-1] == a[mid])
                    high = mid - 1;
                else
                    return mid;
            }
        }
        
        return -1;
    }
    
    public int findLast(int []a, int t) {
        int low = 0, high = a.length-1;
        
        while (low <= high) {
            int mid = (low + high) / 2;
            
            if (t > a[mid]) {
                low = mid + 1;
            } else if (t < a[mid]) {
                high = mid - 1;
            } else {
                if (mid == high)
                    return mid;
                    
                if (a[mid+1] == a[mid])
                    low = mid + 1;
                else
                    return mid;
            }
        }
        
        return -1;
    }
}