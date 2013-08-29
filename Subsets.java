public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(S);
        
        return sub(S, 0);
    }
    
    public ArrayList<ArrayList<Integer>> sub(int[] s, int index) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if (index == s.length) {
            res.add(new ArrayList<Integer>());
            return res;
        }
        
        ArrayList<ArrayList<Integer>> set = sub(s, index+1);
        
        for (ArrayList<Integer> a : set) {
            res.add(a);
            
            ArrayList<Integer> b = new ArrayList<Integer>(a);
            b.add(0, s[index]);
            
            res.add(b);
        }
        
        return res;
    }
    
}
