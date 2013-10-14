public class Solution {
    boolean[][] row, col, sqr;
    
    public void solveSudoku(char[][] board) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        row = new boolean[9][9];
        col = new boolean[9][9];
        sqr = new boolean[9][9];

        for (int i = 0; i < 9; ++i)
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    row[i][num] = true;
                    col[j][num] = true;
                    sqr[i / 3 * 3 + j / 3][num] = true;
                }
            }
            
        solver(board, 0, 0);
    }
    
    public boolean solver(char[][] board, int i, int j) {
        if (i == 9)
            return true;
        
        int nextI = j == 8 ? i + 1 : i;
        int nextJ = j == 8 ? 0 : j + 1;
        
        if (board[i][j] == '.') {
            for (int n = 0; n < 9; ++n) {
                if (isValid(board, i, j, n)) {
                    board[i][j] = (char) ('1' + n);
                    row[i][n] = true;
                    col[j][n] = true;
                    sqr[i / 3 * 3 + j / 3][n] = true;
                    
                    if (solver(board, nextI, nextJ))
                        return true;
                        
                    row[i][n] = false;
                    col[j][n] = false;
                    sqr[i / 3 * 3 + j / 3][n] = false;
                }
            }
            
            board[i][j] = '.';
            return false;
        } else {
            return solver(board, nextI, nextJ);
        }
    }
    
    public boolean isValid(char[][] board, int i, int j, int num) {
        return !(row[i][num] || col[j][num] || sqr[i / 3 * 3 + j / 3][num]);
    }
}