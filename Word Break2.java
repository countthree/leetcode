public class Solution {
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> ret = new ArrayList<String>();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<ArrayList<Integer>>();
        dp.add(new ArrayList<Integer>());
        
        int max = 0;
        for (String w : dict)
            max = Math.max(w.length(), max);
            
        for (int i = 0; i < s.length(); ++i) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            
            for (int j = i + 1 - max; j <= i; ++j) {
                if (j < 0)
                    continue;

                if (j == 0) {
                    String word = s.substring(j, i + 1);
                    if (dict.contains(word))
                        temp.add(0);
                } else if (dp.get(j).size() > 0) {
                    String word = s.substring(j, i + 1);
                    if (dict.contains(word)) {
                        ArrayList<Integer> list = dp.get(j);
                        temp.add(j);
                    }
                }
            }
            
            dp.add(temp);
        }
        
        return buildBreak(s, dp, s.length(), "");
    }
    
    public ArrayList<String> buildBreak(String s, ArrayList<ArrayList<Integer>> dp, int end, String temp) {
        ArrayList<String> ret = new ArrayList<String>();

        if (end == 0) {
            ret.add(temp);
            return ret;
        }
        
        ArrayList<Integer> path = dp.get(end);
        for (int i : path) {
            String added = end == s.length() ? s.substring(i, end) : s.substring(i, end) + " " + temp;
            ArrayList<String> sub = buildBreak(s, dp, i, added);
            ret.addAll(sub);
        }
        
        return ret;
    }
}