class Solution {
    
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        int sum = 0;
        TreeNode leftmost = root.left;
        if(leftmost != null && leftmost.left == null && leftmost.right == null){
            sum += leftmost.val;
        }
        sum += sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        return sum;
    }
}
