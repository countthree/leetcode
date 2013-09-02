public class Solution {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if (numRows == 0)
            return res;
            
        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(1);
        res.add(row);
        
        for (int i = 1; i < numRows; ++i) {
            row = new ArrayList<Integer>();
            row.add(1);
            
            ArrayList<Integer> lastRow = res.get(i-1);
            
            for (int j = 1; j < lastRow.size(); ++j)
                row.add(lastRow.get(j-1) + lastRow.get(j));
            
            row.add(1);
            
            res.add(row);
        }
        
        return res;
    }
}