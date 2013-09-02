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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        
        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        q.offer(root);
        
        int count = q.size();
        int levelNum = 0;
        
        ArrayList<Integer> level = new ArrayList<Integer>();
        
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            level.add(node.val);
            
            --count;
            
            if (node.left != null)
                q.offer(node.left);
                
            if (node.right != null)
                q.offer(node.right);
                
            if (count == 0) {
                if (levelNum % 2 != 0)
                    Collections.reverse(level);
                    
                res.add(level);
                count = q.size();
                level = new ArrayList<Integer>();
                ++levelNum;
            }
        }
        
        return res;
    }
}