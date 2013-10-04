public class Solution {
    public int largestRectangleArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        Stack<Integer> index = new Stack<Integer>();
        Stack<Integer> heights = new Stack<Integer>();
        
        int ret = 0;
        
        for (int i = 0; i < height.length; ++i) {
            if (heights.isEmpty() || height[i] > heights.peek()) {
                heights.push(height[i]);
                index.push(i);
            } else if (height[i] < heights.peek()) {
                int start = i;
                
                while (!heights.isEmpty() && heights.peek() > height[i]) {
                    start = index.pop();
                    int h = heights.pop();
                    ret = Math.max(ret, h * (i - start));
                }
                
                index.push(start);
                heights.push(height[i]);
            }
        }
        
        while (!heights.isEmpty()) {
            int start = index.pop();
            int h = heights.pop();
            ret = Math.max(ret, (height.length - start) * h);
        }
        
        return ret;
    }
}