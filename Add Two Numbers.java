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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode head = null, tail = null;
        
        int c = 0;
        
        ListNode p = l1;
        ListNode q = l2;
        
        while (p != null && q != null) {
            int v = c + p.val + q.val;
            
            c = v / 10;
            v %= 10;
            
            ListNode node = new ListNode(v);
            
            if (head == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
            }
            
            tail = node;
            
            p = p.next;
            q = q.next;
        }
        
        if (p == null)
            p = q;
        
        while (p != null) {
            int v = c + p.val;
            
            c = v / 10;
            v %= 10;
            
            ListNode node = new ListNode(v);
            
            if (head == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
            }
            
            tail = node;
            
            p = p.next;
        }
        
        if (c == 1)
            tail.next = new ListNode(1);
            
        return head;
    }
}