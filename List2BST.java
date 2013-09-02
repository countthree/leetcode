/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null)
            return null;
            
        int l = 0;
        ListNode slow = head, fast = head, prev = null;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            
            prev = (prev == null) ? head : prev.next;
            slow = slow.next;
        }
        
        if (prev != null)
            prev.next = null;
        else
            head = null;
            
        TreeNode root = new TreeNode(slow.val);
        
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        
        return root;
    }
}