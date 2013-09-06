public class Solution {
    public boolean canJump(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int current = 0;
        
        for (int i = 0; i < A.length; ++i) {
            if (current >= A.length - 1)
                return true;
                
            if (i > current)
                return false;
                
            int reach = i + A[i];
            
            if (reach > current)
                current = reach;
        }
        
        return false;
    }
}