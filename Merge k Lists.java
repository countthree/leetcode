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
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode head = null, tail = null;
        
        while (true) {
            boolean hasNode = false;
            
            int index = 0, min = Integer.MAX_VALUE;
            
            for (int i = 0; i < lists.size(); ++i) {
                ListNode list = lists.get(i);
                
                if (list == null)
                    continue;
                
                hasNode = true;
                
                if (list.val < min) {
                    index = i;
                    min = list.val;
                }
            }
            
            if (!hasNode)
                break;
                
            if (head == null) {
                head = tail = lists.get(index);
            } else {
                tail.next = lists.get(index);
                tail = tail.next;
            }
            
            lists.set(index, lists.get(index).next);
        }
        
        return head;
    }
}