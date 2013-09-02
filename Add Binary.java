public class Solution {
    public String addBinary(String a, String b) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char []x = a.toCharArray();
        char []y = b.toCharArray();
        
        int lx = x.length, ly = y.length;
        
        boolean carry = false;
        
        StringBuilder builder = new StringBuilder();
        
        for (int i = 0; i < lx || i < ly; ++i) {
            boolean dx = (i < lx) ? (x[lx-i-1] == '1') : false;
            boolean dy = (i < ly) ? (y[ly-i-1] == '1') : false;
            
            char digit = dx ^ dy ^ carry ? '1' : '0';
            
            builder.insert(0, digit);
            
            if (dx & dy || dx & carry || dy & carry)
                carry = true;
            else
                carry = false;
        }
        
        if (carry)
            builder.insert(0, '1');
            
        return builder.toString();
    }
}