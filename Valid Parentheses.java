public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        Stack<Character> t = new Stack<Character>();
        
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            
            if (c == '[' || c == '{' || c == '(')
                t.push(c);
                
            else {
                try {
                    char out = t.pop();
                    if (c == ']' && out != '[')
                        return false;
                    if (c == ')' && out != '(')
                        return false;
                    if (c == '}' && out != '{')
                        return false;
                } catch (Exception e) {
                    return false;
                }
            }
        }
        
        if (!t.empty())
            return false;
            
        return true;
    }
}