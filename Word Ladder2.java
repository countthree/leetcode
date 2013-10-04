public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int l = start.length(), count = 1;
        
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        map.put(start, new ArrayList<String>());

        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        
        while (!q.isEmpty()) {
            --count;
            String word = q.poll();
                
            for (int i = 0; i < l; ++i) {
                char[] a = word.toCharArray();

                for (int j = 0; j  < 26; ++j) {
                    a[i] = (char) ('a' + j);
                    String s = new String(a);
                    
                    if (s.equals(end)) {
                        ArrayList<String> ladder = new ArrayList<String>();
                        ladder.add(start);
                        ladder.addAll(map.remove(word));
                        ladder.add(end);
                        
                        res.add(ladder);
                        break;
                    }
                    
                    if (dict.contains(s) && !map.containsKey(s)) {
                        ArrayList<String> tempList = new ArrayList<String>(map.get(word));
                        tempList.add(s);
                        map.put(s, tempList);
                        q.offer(s);
                    }
                }
            }
            
            if (count == 0) {
                if (res.size() != 0)
                    break;
                count = q.size();
            }
        }
        
        return res;
    }
}