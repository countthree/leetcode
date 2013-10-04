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
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<Integer> res = new ArrayList<Integer>();
        
        if (root == null)
            return res;
            
        HashSet<TreeNode> set = new HashSet<TreeNode>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        while (!stack.empty()) {
            TreeNode top = stack.peek();
            
            while (top.left != null && !set.contains(top.left)) {
                stack.push(top.left);
                top = top.left;
            }
            
            top = stack.pop();
            set.add(top);
            res.add(top.val);
            
            if (top.right != null)
                stack.push(top.right);
        }
        
        return res;
    }
}