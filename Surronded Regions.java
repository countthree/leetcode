public class Solution {
    class Point {
        int x, y;
        
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    };
    
    public void solve(char[][] board) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = board.length;
        
        if (m == 0)
            return;
            
        int n = board[0].length;
        
        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O')
                bfs(board, i, 0);
                
            if (board[i][n-1] == 'O')
                bfs(board, i, n-1);
        }
        
        for (int i = 0; i < n; ++i) {
            if (board[0][i] == 'O')
                bfs(board, 0, i);
                
            if (board[m-1][i] == 'O')
                bfs(board, m-1, i);
        }
        
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                    
                if (board[i][j] == '.')
                    board[i][j] = 'O';
            }
    }
    
    public void bfs(char[][] board, int x, int y) {
        int m = board.length, n = board[0].length;
        
        Queue<Point> q = new LinkedList<Point>();
        q.offer(new Point(x, y));
        
        while (!q.isEmpty()) {
            Point temp = q.poll();
            board[temp.x][temp.y] = '.';
            
            if (temp.x+1 != m && board[temp.x+1][temp.y] == 'O')
                q.offer(new Point(temp.x+1, temp.y));
            
            if (temp.x-1 != -1 && board[temp.x-1][temp.y] == 'O')
                q.offer(new Point(temp.x-1, temp.y));
                
            if (temp.y+1 != n  && board[temp.x][temp.y+1] == 'O')
                q.offer(new Point(temp.x, temp.y+1));
            
            if (temp.y-1 != -1 && board[temp.x][temp.y-1] == 'O')
                q.offer(new Point(temp.x, temp.y-1));
        }
    }
}