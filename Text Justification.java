public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> res = new ArrayList<String>();
        
        int i = 0;
        while (i < words.length) {
            int j = i;
            int len = 0;
            
            while (j < words.length && len + j - i + words[j].length() <= L) {
                len += words[j].length();
                ++j;
            }
            
            String temp = "";
            
            if (j == words.length) {
                for (int k = i; k < j; ++k) {
                    if (k != i)
                        temp += " ";
                    temp += words[k];
                }
                
                while (temp.length() != L)
                    temp += " ";
            } else {
                if (j - i - 1 != 0) {
                    int num = (L - len) / (j - i - 1);
                    int mod = (L - len) % (j - i - 1);
                    
                    String spaces = "";
                    for (int k = 0; k < num; ++k)
                        spaces += " ";
                    
                    for (int k = i; k < i + mod; ++k) {
                        temp += words[k];
                        temp += spaces + " ";
                    }
                    
                    for (int k = i + mod; k < j; ++k) {
                        temp += words[k];
                        if (k != j - 1)
                            temp += spaces;
                    }
                } else {
                    temp = words[i];
                    while (temp.length() != L)
                        temp += " ";
                }
            }
            
            res.add(temp);
            i = j;
        }
        
        return res;
    }
}