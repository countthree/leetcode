public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subSet = new ArrayList<Integer>();
        
        sub(S, 0, subSet, res, false);
        return res;
    }
    
    public void sub(int[] s, int index, ArrayList<Integer> subSet, ArrayList<ArrayList<Integer>> res, boolean added) {
        if (index == s.length) {
            res.add(new ArrayList<Integer>(subSet));
            return;
        }
        
        sub(s, index+1, subSet, res, false);
        
        if (index != 0 && s[index] == s[index - 1]) {
            if (added) {
                subSet.add(s[index]);
                sub(s, index+1, subSet, res, true);
                subSet.remove(subSet.size() - 1);
            }
        } else {
            subSet.add(s[index]);
            sub(s, index+1, subSet, res, true);
            subSet.remove(subSet.size() - 1);            
        }
        
    }
}