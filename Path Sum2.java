/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        
        sumHelper(root, sum, path, res);
        return res;
    }
    
    public void sumHelper(TreeNode root, int sum, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> res) {
        if (root == null)
            return;
            
        if (root.left == null && root.right == null && sum == root.val) {
            ArrayList<Integer> temp = new ArrayList<Integer>(path);
            temp.add(root.val);
            res.add(temp);
        }
        
        path.add(root.val);
        
        sumHelper(root.left, sum-root.val, path, res);
        sumHelper(root.right, sum-root.val, path, res);
        
        path.remove(path.size()-1);
    }
}