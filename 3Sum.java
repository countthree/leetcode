public class Solution {
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function

        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        for (int i = 0; i < num.length; ++i) {
            if (i > 0 && num[i] == num[i-1])
                continue;
                
            int j = i+1, k = num.length-1;
            
            while (j < k) {
                if (num[i]+num[j]+num[k] > 0) {
                    --k;
                } else if (num[i]+num[j]+num[k] < 0) {
                    ++j;
                } else {
                    ArrayList<Integer> tuple = new ArrayList<Integer>();
                    tuple.add(num[i]);
                    tuple.add(num[j]);
                    tuple.add(num[k]);
                    
                    res.add(tuple);
                    
                    ++j;
                    
                    while (j < k && num[j] == num[j-1])
                        ++j;
                }
            }
        }
        
        return res;
    }
}