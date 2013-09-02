public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int gap = Integer.MAX_VALUE;
        int res = 0;
        
        Arrays.sort(num);
        
        for (int i = 0; i < num.length; ++i) {
            int j = i+1, k = num.length-1;
            
            while(j < k) {
                int sum = num[i]+num[j]+num[k];
            
                int diff = Math.abs(sum-target);
                
                if (diff == 0)
                    return target;
                    
                if (diff < gap) {
                    res = sum;
                    gap = diff;
                }
                
                if (sum < target) {
                    ++j;
                } else {
                    --k;
                }
            }
        }
        
        return res;
    }
}