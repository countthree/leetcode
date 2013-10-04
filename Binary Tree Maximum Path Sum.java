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
    public int maxPathSum(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return helper(root).maxSum;
    }
    
    public RetValue helper(TreeNode root) {
        if (root == null)
            return null;
        
        RetValue left = helper(root.left);
        RetValue right = helper(root.right);
        
        int maxPath = root.val;
        
        if (left != null)
            maxPath = Math.max(root.val, root.val + left.maxPath);
            
        if (right != null)
            maxPath = Math.max(maxPath, root.val + right.maxPath);
        
        int maxSum = maxPath;
        
        if (left != null && right != null)
            maxSum = Math.max(maxSum, root.val + left.maxPath + right.maxPath);

        if (left != null)
            maxSum = Math.max(maxSum, left.maxSum);
            
        if (right != null)
            maxSum = Math.max(maxSum, right.maxSum);
        
        return new RetValue(maxSum, maxPath);
    }
    
    public class RetValue {
        int maxSum;
        int maxPath;

        RetValue(int maxSum, int maxPath) {
            this.maxSum = maxSum;
            this.maxPath = maxPath;
        }
    }
}