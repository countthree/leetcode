public class Solution {
    public int maxArea(int[] height) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = 0, r = height.length - 1;
        int area = 0;
        
        while (r > l) {
            area = Math.max(area, (r - l) * Math.min(height[r], height[l]));
            
            if (height[l] < height[r])
                ++l;
            else
                --r;
        }
        
        return area;
    }
}