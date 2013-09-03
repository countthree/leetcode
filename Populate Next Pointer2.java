/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (root == null)
            return;
            
        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
        q.offer(root);
        
        TreeLinkNode prev = null;
        int count = 1;
        
        while (!q.isEmpty()) {
            TreeLinkNode node = q.poll();
            
            if (node.left != null)
                q.offer(node.left);
                
            if (node.right != null)
                q.offer(node.right);
            
            if (prev != null)
                prev.next = node;
            
            prev = node;
            --count;
            
            if (count == 0) {
                count = q.size();
                prev = null;
            }
        }
    }
}