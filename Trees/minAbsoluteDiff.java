class Solution {
    int min = Integer.MAX_VALUE;
    int prev = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return min;
    }

    void inorder(TreeNode root){
        if(root == null) return;
        if(root.left != null) getMinimumDifference(root.left);
        min = Math.min(min, Math.abs(root.val - prev));
        prev = root.val;
        if(root.right != null) getMinimumDifference(root.right);
        return;
    }
}
