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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode start = head, prev = null;
        
        int i = 1;
        for (; i < m; ++i) {
            if (prev == null)
                prev = head;
            else
                prev = prev.next;
                
            start = start.next;
        }
        
        ListNode p = start, w = null;
        for (; i <= n; ++i) {
            ListNode q = p.next;
            p.next = w;
            w = p;
            p = q;
        }
        
        start.next = p;
    
        if (prev == null) {
            return w;
        } else {
            prev.next = w;
            return head;
        }
    }
}