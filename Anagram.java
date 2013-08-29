public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        for (String s : strs) {
            char []ca = s.toCharArray();
            Arrays.sort(ca);
            
            String ss = new String(ca);
            
            ArrayList<String> a = map.get(ss);
            
            if (a == null)
                a = new ArrayList<String>();
                
            a.add(s);
            map.put(ss, a);
        }
        
        ArrayList<String> res = new ArrayList<String>();
        
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1)
                res.addAll(map.get(key));
        }
            
        return res;            
    }
}
