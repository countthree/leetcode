public class Solution {
    public String simplifyPath(String path) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String []dirs = path.split("/");
        
        Stack<String> stack = new Stack<String>();
        
        for (String dir : dirs) {
            if (dir.equals(".") || dir.equals(""))                
                continue;
                
            if (dir.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(dir);
            }
        }
        
        if (stack.isEmpty())
            return "/";
            
        StringBuilder builder = new StringBuilder();
        
        for (String dir : stack) {
            builder.append("/");
            builder.append(dir);
        }
        
        return builder.toString();
    }
}