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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    
    public TreeNode buildTreeHelper(int[] pre, int preBegin, int preEnd, int[] in, int inBegin, int inEnd) {
        if (preBegin == preEnd)
            return null;
        
        TreeNode root = new TreeNode(pre[preBegin]);
            
        int i;
        for (i = inBegin; i < inEnd; ++i)
            if (in[i] == pre[preBegin])
                break;
                
        root.left = buildTreeHelper(pre, preBegin+1, preBegin+1+i-inBegin, in, inBegin, i);
        root.right = buildTreeHelper(pre, preBegin+1+i-inBegin, preEnd, in, i+1, inEnd);
        
        return root;
    }
}