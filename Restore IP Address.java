public class Solution {
    public ArrayList<String> restoreIpAddresses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        char[] ip = s.toCharArray();
        int[] dots = new int[4];
        
        split(ip, 0, 3, dots, res);
        
        return res;
    }
    
    public void split(char[] ip, int start, int dot, int[] dots, ArrayList<String> res) {
        if (dot == 0) {
            if (validAddr(ip, start, ip.length)) {
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < 3; ++i) {
                    builder.append(ip, dots[i], dots[i+1]-dots[i]);
                	builder.append('.');
                }
                
                builder.append(ip, start, ip.length-start);
                
                res.add(builder.toString());
            }
            
            return;
        }
        
        for (int i = 1; i <= 3; ++i)
            if (validAddr(ip, start, start+i)) {
                dots[4 - dot] = start+i;
                split(ip, start+i, dot-1, dots, res);
            }
    }
    
    public boolean validAddr(char[] ip, int start, int end) {
        int len = end - start;
        
        if (len > 3 || len <= 0 || end > ip.length)
            return false;
            
        if (ip[start] == '0')
            return len == 1 ? true : false;
            
        if (len == 3) {
            switch (ip[start]) {
            case '1':
                return true;
            case '2':
                if (ip[start+1] < '5')
                    return true;
                else if (ip[start+1] > '5')
                    return false;
                else
                    return ip[start+2] > '5' ? false : true;
            default:
                return false;
            }
        }
        
        return true;
    }
}
