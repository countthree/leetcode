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
    TreeNode pre, p1, p2;
    
    public void recoverTree(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        pre = p1 = p2 = null;    
        
        inOrder(root);
        
        int t = p1.val;
        p1.val = p2.val;
        p2.val = t;
    }
    
    public void inOrder(TreeNode root) {
        if (root != null) {
            inOrder(root.left);
            
            if (pre != null && pre.val > root.val) {
                if (p1 == null) {
                    p1 = pre;
                    p2 = root;
                } else {
                    p2 = root;
                }
            }
            
            pre = root;
            inOrder(root.right);
        }
    }
}