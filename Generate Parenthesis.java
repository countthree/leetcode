public class Solution {
    public void genParenHelper(int n, int l, int r, char[] s, ArrayList<String> res) {
        if (l == 0 && r == 0)
            res.add(new String(s));
            
        if (l != 0) {
            s[2*n - l - r] = '(';
            genParenHelper(n, l-1, r, s, res);
        }
        
        if (l < r) {
            s[2*n - l - r] = ')';
            genParenHelper(n, l, r-1, s, res);
        }
            
    }
    
    public ArrayList<String> generateParenthesis(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        
        char []s = new char [2*n];
        
        genParenHelper(n, n, n, s, res);
        
        return res;
    }
}