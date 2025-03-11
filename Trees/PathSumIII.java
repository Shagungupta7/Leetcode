class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return helper(root, 0, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int helper(TreeNode node, long currSum, int targetSum) { 
        if (node == null) return 0;

        currSum += node.val;
        int count = (currSum == targetSum) ? 1 : 0;

        count += helper(node.left, currSum, targetSum);
        count += helper(node.right, currSum, targetSum);

        return count;
    }
}
