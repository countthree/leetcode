public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int max = 1;
        
        for (int x : num)
            map.put(x, 1);
            
        for (int key : num) {
            if (map.containsKey(key)) {
                int val = map.get(key);
                int next = key + val;
                
                while (map.containsKey(next)) {
                    val += map.get(key+val);
                    
                    if (val > max)
                        max = val;
                        
                    map.put(key, val);
                    
                    map.remove(next);
                    next = key + val;
                }
            }
        }
        
        return max;
    }
}