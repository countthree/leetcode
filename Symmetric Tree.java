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
    public boolean isSymmetric(TreeNode root) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (root == null)
            return true;
            
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
            
        if (left == null || right == null)
            return false;
        
        if (left.val == right.val)
            return helper(left.right, right.left) && helper(left.left, right.right);
        else
            return false;
    }
}