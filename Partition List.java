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
    public ListNode partition(ListNode head, int x) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode smallTail = null, bigTail = null;
        ListNode smallHead = null, bigHead = null;
        
        for (ListNode p = head; p != null; p = p.next) {
            if (p.val < x) {
                if (smallHead == null)
                    smallHead = p;
                else
                    smallTail.next = p;
                    
                smallTail = p;
            } else {
                if (bigHead == null)
                    bigHead = p;
                else
                    bigTail.next = p;
                    
                bigTail = p;
            }
        }
        
        if (bigTail != null)
            bigTail.next = null;
            
        if (smallTail != null) {
            smallTail.next = bigHead;
            return smallHead;
        } else {
            return bigHead;
        }
    }
}