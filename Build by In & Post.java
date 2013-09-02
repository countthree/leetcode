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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return buildTreeHelper(inorder, 0, postorder, 0, inorder.length);
    }
    
    public TreeNode buildTreeHelper(int[] in, int inBegin, int[] post, int postBegin, int len) {
        if (len == 0)
            return null;
        
        TreeNode root = new TreeNode(post[postBegin+len-1]);
            
        int i;
        for (i = 0; i < len; ++i)
            if (in[i+inBegin] == post[postBegin+len-1])
                break;
                
        root.left = buildTreeHelper(in, inBegin, post, postBegin, i);
        root.right = buildTreeHelper(in, inBegin+i+1, post, postBegin+i, len-i-1);
        
        return root;
    }
}