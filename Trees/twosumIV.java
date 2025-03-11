class Solution {
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return helper(root, set, k);
    }

    boolean helper(TreeNode node, HashSet<Integer> set, int k){
        if(node == null) return false;

        if(set.contains(k - node.val)) return true;

        set.add(node.val);

        return helper(node.left, set, k) || helper(node.right, set, k);
        
    }
}
