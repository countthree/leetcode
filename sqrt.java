public class Solution {
    public int sqrt(int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int low = 0, high = x;
        int mid = (high - low) / 2 + low;
        
        while (low <= high) {
            mid = (high - low) / 2 + low;
            if (mid == 0)
                return x;
                
            if (mid  > (x / mid)) {
                high = mid - 1;
            } else if (mid <= (x / mid) && ((mid+1) > x / (mid+1))) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        
        return mid;
    }
}