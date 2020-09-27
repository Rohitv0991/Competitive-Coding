/*Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. 
The path must contain at least one node and does not need to go through the root.

Example 2:

Input: [-10,9,20,null,null,15,7]

   -10
    / \
  9  20
      /  \
   15   7

Output: 42*/

//https://leetcode.com/problems/binary-tree-maximum-path-sum/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        maxPath(root);
        return max;
    }
    
    public int maxPath(TreeNode root) {
        //base case
        if(root == null) return 0;
        
        //get left and right most values of passed root
        int left = Math.max(0, maxPath(root.left));
        int right = Math.max(0, maxPath(root.right));
        
        //calc max value
        max = Math.max(max, left + right + root.val);
        
        //add max child of passed root and root value
        return(Math.max(left, right) + root.val);
    }
}