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
    public ListNode rotateRight(ListNode head, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (head == null)
            return null;
            
        int l = 1;
        ListNode tail = head;
        
        while (tail.next != null) {
            ++l;
            tail = tail.next;
        }
        
        n %= l;
        
        if (n == 0)
            return head;
            
        ListNode prev = null, p = head;
        
        for (int i = 0; i < l - n; ++i) {
            p = p.next;
            
            if (prev == null)
                prev = head;
            else
                prev = prev.next;
            
        }
        
        prev.next = null;
        tail.next = head;
        
        return p;
    }
}