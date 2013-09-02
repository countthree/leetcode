public class Solution {
    public ArrayList<String[]> solveNQueens(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String[]> res = new ArrayList<String[]>();
        
        int []pos = new int[n];
        
        queenHelper(pos, 0, res);
        
        return res;
    }
    
    public void queenHelper(int[] pos, int row, ArrayList<String[]> res) {
        if (row == pos.length) {
            char []template = new char[pos.length];
            String []board = new String[pos.length];
            
            Arrays.fill(template, '.');
            
            for (int i = 0; i < pos.length; ++i) {
                template[pos[i]] = 'Q';
                board[i] = new String(template);
                template[pos[i]] = '.';
            }
            
            res.add(board);
            
            return;
        }
        
        for (int j = 0; j < pos.length; ++j) {
            if (validQueen(pos, row, j)) {
                pos[row] = j;
                queenHelper(pos, row+1, res);
            }
        }
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