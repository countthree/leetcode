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
        ListNode prev = null, p = head;
        
        while (p != null && p.next != null) {
            if (p.next.val == p.val) {
                ListNode q = p.next.next;
                while (q != null && q.val == p.val)
                    q = q.next;
                    
                if (prev == null) {
                    head = q;
                } else {
                    prev.next = q;
                }
                
                p = q;
            } else {
                prev = p;
                p = p.next;
            }
            
        }
        
        return head;
    }
}