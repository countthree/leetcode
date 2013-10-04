/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        if (node == null)
            return node;
            
        Stack<UndirectedGraphNode> stack = new Stack<UndirectedGraphNode>();
        stack.push(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        
        UndirectedGraphNode retNode = null;
        
        while (!stack.isEmpty()) {
            UndirectedGraphNode oldNode = stack.pop();
            
            UndirectedGraphNode newNode = map.get(oldNode);
            
            if (newNode == null) {
                newNode = new UndirectedGraphNode(oldNode.label);
                map.put(oldNode, newNode);
            }
            
            if (retNode == null)
                retNode = newNode;
            
            for (UndirectedGraphNode neigh : oldNode.neighbors) {
                UndirectedGraphNode copied = map.get(neigh);
                
                if (copied == null) {
                    stack.push(neigh);
                    copied = new UndirectedGraphNode(neigh.label);
                    map.put(neigh, copied);
                }
                
                newNode.neighbors.add(copied);
            }
        }
        
        return retNode;
    }
}