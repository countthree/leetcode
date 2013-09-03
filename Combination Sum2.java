public class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> set = new ArrayList<Integer>();
        Arrays.sort(candidates);

        sumHelper(candidates, 0, target, set, res);
        return res;
    }
    
    public void sumHelper(int[] a, int start, int sum, ArrayList<Integer> set, ArrayList<ArrayList<Integer>> res) {
        if (sum == 0) {
            ArrayList<Integer> temp = new ArrayList<Integer>(set);
            res.add(temp);
            return;
        }
            
        for (int i = start; i < a.length; ++i) {
            if (i != start && a[i] == a[i-1])
                continue;
                
            if (a[i] > sum)
                break;
                
            set.add(a[i]);
            sumHelper(a, i+1, sum-a[i], set, res);
            set.remove(set.size()-1);
        }
    } 
}