public class Solution {
    public int removeElement(int[] A, int elem) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int l = 0;
        int r = A.length-1;
        
        while (l <= r) {
            if (A[l] == elem) {
                A[l] = A[r];
                A[r] = elem;
                --r;
            } else {
                ++l;
            }
        }
        
        return l;
    }
}
