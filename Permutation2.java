public class Solution {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> temp = new ArrayList<Integer>();
        HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>(); 
        
        helper(set, temp, 0, num);
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        res.addAll(set);
        
        return res;
    }
    
    public void helper(HashSet<ArrayList<Integer>> set, ArrayList<Integer> temp, int start, int[] num) {
        if (start == num.length) {
            ArrayList<Integer> perm = new ArrayList<Integer>(temp);
            set.add(perm);
            return;
        }
        
        for (int i = start; i < num.length; ++i) {
            temp.add(num[i]);
            swap(num, i, start);
            
            helper(set, temp, start+1, num);
            
            temp.remove(temp.size()-1);
            swap(num, i, start);
        }
    }
    
    public void swap(int[] num, int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
}