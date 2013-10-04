/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        RandomListNode newHead = null;
        RandomListNode prev = null;
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        
        for (RandomListNode p = head; p != null; p = p.next) {
            RandomListNode temp = new RandomListNode(p.label);
            map.put(p, temp);
            
            if (newHead == null) {
                newHead = temp;
                prev = temp;
            } else {
                prev.next = temp;
                prev = temp;
            }
        }
        
        for (RandomListNode p = head; p != null; p = p.next)
            map.get(p).random = map.get(p.random);
            
        return newHead;
    }
}