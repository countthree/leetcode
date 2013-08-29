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
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
        if (head == null || head.next == null)
            return head;
            
        ListNode p = head;
        ListNode q = null, r = null;
        ListNode res = head.next;
        
        while (p != null && p.next != null) {
            if (q != null)
                q.next = p.next;
                
            q = p.next;
            r = q.next;
            
            q.next = p;
            p.next = r;
            
            q = p;
            p = r;
        }
        
        return res;
    }
}
