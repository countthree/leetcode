public class Solution {
    public String getPermutation(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] perm = new char[n];
        
        for (int i = 0; i < n; ++i)
            perm[i] = (char) (1 + i + '0');
            
        for (int i = 1; i < k; ++i)
            nextPerm(perm);
            
        return new String(perm);
    }
    
    public void nextPerm(char[] perm) {
        int i, j;
        
        for (i = perm.length-2; i >= 0; --i) {
            if (perm[i+1] > perm[i])
                break;
        }
        
        char min = (char) 255;
        int minIndex = i + 1;
        
        for (j = i+1; j < perm.length; ++j) {
            if (perm[j] > perm[i] && perm[j] < min) {
                min = perm[j];
                minIndex = j;
            }
        }
        
        perm[minIndex] = perm[i];
        perm[i] = min;
        
        Arrays.sort(perm, i+1, perm.length);
    }
}