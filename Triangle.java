public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int n = triangle.size();
        int[] min = new int[n];
        int[] tempMin = new int[n];
        min[0] = triangle.get(0).get(0);
        
        for (int i = 1; i < n; ++i) {
            ArrayList<Integer> row = triangle.get(i);
            
            tempMin[0] = min[0] + row.get(0);
            tempMin[i] = min[i-1] + row.get(i);
            
            for (int j = 1; j < i; ++j)
                tempMin[j] = Math.min(min[j-1], min[j]) + row.get(j);
                
            int[] t = min;
            min = tempMin;
            tempMin = t;
        }
        
        int res = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; ++i)
            if (min[i] < res)
                res = min[i];
                
        return res;
    }
}