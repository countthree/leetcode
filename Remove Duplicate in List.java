/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null)
            return head;
            
        ListNode prev = head, p = head.next;
        
        while (p != null) {
            boolean deleted = false;
            
            for (ListNode node = head; node != p; node = node.next) {
                if (node.val == p.val) {
                    prev.next = p.next;
                    p = p.next;
                    deleted = true;
                    break;
                }
            }
            
            if (!deleted) {
                prev = prev.next;
                p = p.next;
            }
        }
        
        return head;
    }
}