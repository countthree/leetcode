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
    public int sumHelper(TreeNode root, int sum) {
        if (root == null)
            return 0;
        
        if (root.left == null && root.right == null)
            return sum + root.val;
            
        return sumHelper(root.right, 10*(sum+root.val)) + sumHelper(root.left, 10*(sum+root.val));
    }
    
    public int sumNumbers(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return sumHelper(root, 0);
    }
}