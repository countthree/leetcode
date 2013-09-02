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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode first = head, second = head;
        ListNode prev = null;
        
        for (int i = 0; i < n; ++i)
            second = second.next;
            
        while (second != null) {
            first = first.next;
            second = second.next;
            
            if (prev == null)
                prev = head;
            else
                prev = prev.next;
        }
        
        if (prev == null)
            return head.next;
            
        prev.next = first.next;    
        return head;
    }
}