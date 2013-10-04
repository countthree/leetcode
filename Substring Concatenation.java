public class Solution {
    public ArrayList<Integer> findSubstring(String S, String[] L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int m = L[0].length();
        int n = L.length;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String s : L) {
            if (map.containsKey(s))
                map.put(s, map.get(s) + 1);
            else
                map.put(s, 1);
        }
        
        Map<String, Integer> cur = new HashMap<String, Integer>();
        
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        for (int i = 0; i <= S.length() - m * n; ++i) {
            cur.clear();
            
            String s = S.substring(i, i + m * n);
            
            int pos = 0;
            while (pos < n) {
                String temp = s.substring(pos * m, (pos + 1) * m);
                
                if (cur.containsKey(temp))
                    cur.put(temp, cur.get(temp) + 1);
                else
                    cur.put(temp, 1);
                    
                if (!map.containsKey(temp) || map.get(temp) < cur.get(temp))
                    break;
                
                ++pos;
            }
            
            if (pos == n)
                res.add(i);
        }
        
        return res;
    }
}