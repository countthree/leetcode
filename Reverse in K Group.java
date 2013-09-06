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
    public ListNode reverseKGroup(ListNode head, int k) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int l = 0;
        ListNode p = head;
        
        while (p != null) {
            p = p.next;
            ++l;
        }
        
        ListNode prev = null;
        p = head;
        
        for (int i = 0; i + k <= l; i += k) {
            ListNode next = reverse(p, k);
            
            if (prev == null)
                head = next;
            else
                prev.next = next;
                
            prev = p;
            p = p.next;
        }
        
        return head;
    }
    
    public ListNode reverse(ListNode p, int k) {
        ListNode w = null, q = null;
        ListNode head = p;
        
        for (int i = 1; i <= k; ++i) {
            q = p.next;
            p.next = w;
            w = p;
            p = q;
        }
        
        head.next = p;
        return w;
    }
}