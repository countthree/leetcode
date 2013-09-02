public class Solution {
    public void solveSudoku(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        boolean [][]row = new boolean[9][9];
        boolean [][]col = new boolean[9][9];
        boolean [][]grid = new boolean[9][9];
        
        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;
                    grid[toGridNum(i, j)][num] = true;
                }
            }
            
        solveHelper(board, row, col, grid);    
    }
    
    public boolean solveHelper(char[][] board, boolean[][] row, boolean[][] col, boolean[][] grid) {
        boolean finded = false;
        int x = -1, y = -1;
        
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    x = i;
                    y = j;
                    finded = true;
                    break;
                }
            }
            
            if (finded)
                break;
        }
        
        if (!finded)
            return true;
            
        for (int i = 0; i < 9; ++i) {
            if (!row[x][i] && !col[y][i] && !grid[toGridNum(x, y)][i]) {
                row[x][i] = true;
                col[y][i] = true;
                grid[toGridNum(x, y)][i] = true;
                board[x][y] = (char) ('1' + i);
                
                if (solveHelper(board, row, col, grid))
                    return true;
                    
                board[x][y] = '.';
                row[x][i] = false;
                col[y][i] = false;
                grid[toGridNum(x, y)][i] = false;
            }
        }
        
        return false;
    }
    
    public int toGridNum(int x, int y) {
        return x / 3 * 3 + y / 3;
    }
}