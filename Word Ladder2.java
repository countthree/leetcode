public class Solution {
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        int l = start.length(), count = 1;
        
        Queue<String> q = new LinkedList<String>();
        q.offer(start);
        
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    		HashSet<String> levelSet = new HashSet<String>();
        boolean found = false;

        while (!q.isEmpty()) {
            --count;
            String word = q.poll();
            
            for (int i = 0; i < l; ++i) {
                char[] a = word.toCharArray();

                for (int j = 0; j  < 26; ++j) {
                    a[i] = (char) ('a' + j);
                    String s = new String(a);
                    
                    if (s.equals(end)) {
                        ArrayList<String> list = map.get(end);
                        if (list == null) {
                            list = new ArrayList<String>();
                            map.put(end, list);
                        }
                        
                        found = true;
                        list.add(word);
                        break;
                    }
                    
                    if (dict.contains(s)) {
                        ArrayList<String> list = map.get(s);
                        if (list == null) {
                            list = new ArrayList<String>();
                            map.put(s, list);
                        }
                        
                        list.add(word);
                        
                        if (!levelSet.contains(s)) {
                        	levelSet.add(s);
                        	q.offer(s);
                        }
                    }
                }
            }
            
            if (count == 0) {
                if (found)
                    break;
                
                count = q.size();
                levelSet.clear();
                dict.removeAll(q);
            }
        }
        
        
        ArrayList<ArrayList<String>> ret = new ArrayList<ArrayList<String>>();
        
        if (found) {
        	ArrayList<String> path = new ArrayList<String>();
        	path.add(end);
        	buildPath(map, end, start, path, ret);
        }
        
        return ret;
    }
    
    public void buildPath(HashMap<String, ArrayList<String>> map, String end, String start, ArrayList<String> path, ArrayList<ArrayList<String>> ret) {
        if (end.equals(start)) {
            ret.add(new ArrayList<String>(path));
            return;
        }
        
        ArrayList<String> list = map.get(end);
        
        for (String word : list) {
            path.add(0, word);
            buildPath(map, word, start, path, ret);
            path.remove(0);
        }
    }
}