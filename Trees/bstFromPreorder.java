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
    int index = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0) return null;

        return helper(preorder, Integer.MAX_VALUE);
    }

    TreeNode helper(int[] pre, int bound){
        if(pre.length == index || pre[index] > bound) return null;

        TreeNode root = new TreeNode(pre[index++]);

        root.left = helper(pre, root.val);
        root.right = helper(pre, bound);
        return root;
    }
}
