public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; ++i) {
            boolean []map = new boolean[10];
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.')
                    continue;
                    
                int num = board[i][j] - '0';
                if (num > 9 || num <= 0 || map[num])
                    return false;
                    
                map[num] = true;
            }
        }
        
        for (int i = 0; i < 9; ++i) {
            boolean []map = new boolean[10];
            for (int j = 0; j < 9; ++j) {
                if (board[j][i] == '.')
                    continue;
            
                int num = board[j][i] - '0';
                if (num > 9 || num <= 0 || map[num])
                    return false;
                    
                map[num] = true;
            }
        }
        
        for (int i = 0; i < 9; ++i) {
            boolean []map = new boolean[10];
            
            for (int j = 0; j < 9; ++j) {
                int row = i / 3 * 3 + j / 3;
                int col = i % 3 * 3 + j % 3;
                
                if (board[row][col] == '.')
                    continue;
                    
                int num = board[row][col] - '0';
                if (num > 9 || num <= 0 || map[num])
                    return false;
                    
                map[num] = true;                
            }
        }
        
        return true;
    }
}