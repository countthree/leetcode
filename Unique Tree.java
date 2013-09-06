public class Solution {
    public int numTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int[] num = new int[n+1];
        num[0] = num[1] = 1;
        
        for (int i = 2; i <= n; ++i)
            for (int j = 0; j < i; ++j)
                num[i] += num[i-1-j] * num[j];
                
        return num[n];
    }
}