public class Solution {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int len = 1, l = start.length();
        
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        
        int count = 1;
        
        while (!q.isEmpty()) {
            String word = q.poll();
            --count;
            
            if (word.equals(end))
                return len;
                
            for (int i = 0; i < l; ++i) {
                char[] a = word.toCharArray();

                for (int j = 0; j  < 26; ++j) {
                    a[i] = (char) ('a' + j);
                    String s = new String(a);
                    
                    if (dict.contains(s)) {
                        dict.remove(s);
                        q.offer(s);
                    }
                    
                }
            }
            
            if (count == 0) {
                count = q.size();
                ++len;
            }
        }
        
        return 0;
    }
}