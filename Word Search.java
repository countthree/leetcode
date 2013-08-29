public class Solution {
    public boolean exist(char[][] board, String word) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int m = board.length;
        int n = board[0].length;
        
        char []a = word.toCharArray();
        
        boolean [][]v = new boolean[m][n];
        
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                if (dfs(board, v, i, j, 0, a))
                    return true;
            }
            
        return false;            
    }
    
    public boolean dfs(char[][] b, boolean[][] v, int x, int y, int p, char[] a) {
        int m = b.length;
        int n = b[0].length;
        
        if (p == a.length)
            return true;
            
        if (x < 0 || x >= m)
            return false;
            
        if (y < 0 || y >= n)
            return false;
        
        if (v[x][y])
            return false;
            
        if (a[p] == b[x][y]) {
            v[x][y] = true;
            
            if (dfs(b, v, x+1, y, p+1, a)) {
                v[x][y] = false;
                return true;
            }
            
            if (dfs(b, v, x-1, y, p+1, a)) {
                v[x][y] = false;
                return true;
            }
            
            if (dfs(b, v, x, y+1, p+1, a)) {
                v[x][y] = false;
                return true;
            }
            
            if (dfs(b, v, x, y-1, p+1, a)) {
                v[x][y] = false;
                return true;
            }   
            
            v[x][y] = false;
            
            return false;
        } else {
            return false;
        }
    }
}
