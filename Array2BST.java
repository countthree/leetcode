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
    public TreeNode sortedArrayToBST(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        return toBST(num, 0, num.length-1);
    }
    
    public TreeNode toBST(int []n, int low, int high) {
        if (low > high)
            return null;
            
        int mid = low + (high - low) / 2;
        
        TreeNode root = new TreeNode(n[mid]);
        
        root.left = toBST(n, low, mid-1);
        root.right = toBST(n, mid+1, high);
        
        return root;
    }
}