public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if (n == 0) {
            res.add(0);
            return res;
        }
        
        ArrayList<Integer> gray = grayCode(n - 1);
        
        for (int i = 0; i < gray.size(); ++i)
            res.add(gray.get(i));
            
        for (int i = gray.size() - 1; i >= 0; --i)
            res.add(gray.get(i) + (1 << (n - 1)));
            
        return res;
    }
}