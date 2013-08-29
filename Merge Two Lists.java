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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (l1 == null)
            return l2;
        
        if (l2 == null)
            return l1;
            
        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode tail = head;

        if (head == l1)
            l1 = l1.next;
        else
            l2 = l2.next;

        ListNode p1 = l1, p2 = l2;
        
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail.next = p1;
                tail = p1;
                p1 = p1.next;
            } else {
                tail.next = p2;
                tail = p2;
                p2 = p2.next;
            }
        }
        
        if (p1 == null)
            tail.next = p2;
        else
            tail.next = p1;
            
        return head;
    }
}