public class Solution {
    public String convert(String s, int nRows) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (nRows == 1)
            return s;
            
        int l = s.length();
        
        char [][]a = new char[nRows][l];
        
        boolean down = true;
        
        int x = 0, y = 0;
        for (int i = 0; i < l; ++i) {
            char c = s.charAt(i);
            
            a[x][y] = c;
            
            if (x == nRows-1)
                down = false;
            if (x == 0)
                down = true;
                
            if (down) {
                ++x;
            } else {
                ++y;
                --x;
            }    
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < nRows; ++i)
            for (int j = 0; j < l; ++j) {
                if (a[i][j] != '\0')
                    sb.append(a[i][j]);
            }
            
        return sb.toString();
    }
}