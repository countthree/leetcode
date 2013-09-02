public class Solution {
    public int totalNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int []pos = new int[n];
        
        return queenHelper(pos, 0);
    }
    
    public int queenHelper(int[] pos, int row) {
        if (row == pos.length) {
            return 1;
        }
        
        int count = 0;
        
        for (int j = 0; j < pos.length; ++j) {
            if (validQueen(pos, row, j)) {
                pos[row] = j;
                count += queenHelper(pos, row+1);
            }
        }
        
        return count;
    }
    
    public boolean validQueen(int []pos, int x, int y) {
        for (int i = 0; i < x; ++i) {
            if (pos[i] == y)
                return false;
            
            if (i - pos[i] == x - y)
                return false;
                
            if (pos[i] + i == x + y)
                return false;
        }
        
        return true;
    }
}