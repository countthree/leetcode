/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public ArrayList<TreeNode> generateTrees(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return assembleTree(1, n+1);
    }
    
    public ArrayList<TreeNode> assembleTree(int start, int end) {
        ArrayList<TreeNode> array = new ArrayList<TreeNode>();
        
        if (start == end)
            array.add(null);
        
        for (int i = start; i < end; ++i) {
            ArrayList<TreeNode> left = assembleTree(start, i);
            ArrayList<TreeNode> right = assembleTree(i+1, end);
         
            for (TreeNode leftNode : left)
                for (TreeNode rightNode : right) {
                TreeNode root = new TreeNode(i);
                root.left = leftNode;
                root.right = rightNode;
                array.add(root);
            }
        }
        
        return array;
    }
    
    
}