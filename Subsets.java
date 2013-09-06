public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subSet = new ArrayList<Integer>();
        
        sub(S, 0, subSet, res);
        return res;
    }
    
    public void sub(int[] s, int index, ArrayList<Integer> subSet, ArrayList<ArrayList<Integer>> res) {
        if (index == s.length) {
            res.add(new ArrayList<Integer>(subSet));
            return;
        }
        
        sub(s, index+1, subSet, res);
        
        subSet.add(s[index]);
        sub(s, index+1, subSet, res);
        subSet.remove(subSet.size() - 1);
    }
}