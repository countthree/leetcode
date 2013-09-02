public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if (num.length == 0)
            return res;
            
        ArrayList<Integer> perm = new ArrayList<Integer>();
        
        permuteHelper(num, 0, perm, res);
        
        return res;
    }
    
    public void permuteHelper(int []num, int index, ArrayList<Integer> perm, ArrayList<ArrayList<Integer>> res) {
        if (index == num.length-1) {
            ArrayList<Integer> temp = new ArrayList<Integer>(perm);
            temp.add(num[index]);
            res.add(temp);
            return;
        }
        
        for (int i = index; i < num.length; ++i) {
            perm.add(num[i]);
            swap(num, index, i);
            
            permuteHelper(num, index+1, perm, res);
            
            swap(num, index, i);
            perm.remove(perm.size()-1);
        }
    }
    
    public void swap(int []num, int i, int j) {
        int t = num[i];
        num[i] = num[j];
        num[j] = t;
    }
}