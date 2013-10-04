public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Arrays.sort(num);
        
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        
        solver(num, res, temp, 4, num.length-1, target);
        return res;
    }
    
    public void solver(int[] num, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp, int 

count, int end, int target) {
        if (end < count - 1)
            return;
            
        if (count == 1) {
            ArrayList<Integer> ans = new ArrayList<Integer>(temp);
            if (tryFind(num, end, target)) {
                ans.add(0, target);
                res.add(ans);
            }
             
            return;
        }
        
        for (int i = end; i >= 0; --i) {
            if (i != end && num[i] == num[i+1])
                continue;
            
            temp.add(0, num[i]);
            solver(num, res, temp, count-1, i-1, target-num[i]);
            temp.remove(0);
        }
    }
    
    public boolean tryFind(int[] num, int end, int target) {
        int l = 0, r = end;
        
        while (l <= r) {
            int mid = (l + r) / 2;
            
            if (num[mid] == target)
                return true;
            else if (num[mid] > target)
                r = mid - 1;
            else
                l = mid + 1;
        }
        
        return false;
    }
}