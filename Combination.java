public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> comb = new ArrayList<Integer>();
        
        combineHelper(n, k, comb, res);
        
        return res;
    }
    
    public void combineHelper(int n, int k, ArrayList<Integer> comb, ArrayList<ArrayList<Integer>> res) {
        if (k == 0) {
            res.add(new ArrayList<Integer>(comb));
            return;
        }
        
        if (n < k)
            return;
            
        combineHelper(n-1, k, comb, res);
        
        comb.add(0, n);
        combineHelper(n-1, k-1, comb, res);
        comb.remove(0);
    }
}