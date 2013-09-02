public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(1);
        
        for (int i = 0; i < rowIndex; ++i) {
            for (int j = row.size()-1; j > 0; --j)
                row.set(j, row.get(j)+row.get(j-1));
            row.add(1);
        }
        
        return row;
    }
}