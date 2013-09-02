public class Solution {
    public int removeDuplicates(int[] A) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (A.length == 0)
            return 0;
            
        int end = 0, i = 1;
        
        while (i < A.length) {
            boolean twice = false;
            
            A[++end] = A[i];
            if (A[end-1] == A[end]) 
                twice = true;
            else
                twice = false;

            ++i;
            
            if (twice)
                while (i < A.length && A[i] == A[end])
                    ++i;
        }
        
        return end+1;
    }
}