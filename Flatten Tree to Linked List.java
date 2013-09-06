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
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root != null)
            flattenHelper(root);
    }
    
    public TreeNode flattenHelper(TreeNode root) {
        TreeNode right = root.right;
        TreeNode left = root.left;
        
        root.left = null;
        root.right = left;
        
        TreeNode next = (left == null) ? root : flattenHelper(left);
        next.right = right;
        
        return (right == null) ? next : flattenHelper(right);
    }
}