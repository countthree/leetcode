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
        Queue<Point> q = new LinkedList<Point>();
        
        for (int i = 0; i < m; ++i) {
            if (board[i][0] == 'O')
                q.offer(new Point(i, 0));
                
            if (board[i][n-1] == 'O')
                q.offer(new Point(i, n-1));
        }
        
        for (int i = 0; i < n; ++i) {
            if (board[0][i] == 'O')
                q.offer(new Point(0, i));
                
            if (board[m-1][i] == 'O')
                q.offer(new Point(m-1, i));
        }        
        
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
        
        for (int i = 0; i < m; ++i)
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                    
                if (board[i][j] == '.')
                    board[i][j] = 'O';
            }
    }
}