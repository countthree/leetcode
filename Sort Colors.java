public class Solution {
    public void sortColors(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int blue = A.length - 1;
        int white = -1;
        int i = 0;
        
        while (i <= blue) {
            if (A[i] == 2) {
                swap(A, i, blue);
                --blue;
            } else if (A[i] == 0) {
                if (white != -1) {
                    swap(A, white, i);
                    ++white;
                } else {
                    ++i;
                }
            } else {
                if (white == -1)
                    white = i;
                    
                ++i;
            }
        }
    }
    
    public void swap(int[] A, int i, int j) {
        int t = A[i];
        A[i] = A[j];
        A[j] = t;
    }
}