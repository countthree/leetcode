/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        return getHeight(root) != -1;
    }
    
    public int getHeight(TreeNode root) {
        if (root == null)
            return 0;
            
        int lHeight = getHeight(root.left);
        
        if (lHeight == -1)
            return -1;
            
        int rHeight = getHeight(root.right);
        
        if (rHeight == -1)
            return -1;
        
        if (Math.abs(lHeight - rHeight) > 1)
            return -1;
            
        return 1 + Math.max(lHeight, rHeight);    
    }
}