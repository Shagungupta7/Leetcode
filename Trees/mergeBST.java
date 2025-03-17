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
    public TreeNode canMerge(List<TreeNode> trees) {
        HashSet<Integer> set = new HashSet<>();
        
        for(TreeNode node : trees){
            if(node.left != null) set.add(node.left.val);
            if(node.right != null) set.add(node.right.val);
        }

        TreeNode root = null;
        for(TreeNode node : trees){
            if(!set.contains(node.val)) root = node;//root cannot be a leaf
        }
        if(root == null) return null;

        Map<Integer, TreeNode> rootNodes = new HashMap<>();

        for(TreeNode node : trees){
            if(node != root) { 
                rootNodes.put(node.val, node);
            }
        }

        root = mergeBST(root, rootNodes);

        return validate(root, new int[] {-1}) && rootNodes.size() == 0 ? root : null;
    }

    TreeNode mergeBST(TreeNode root, Map<Integer, TreeNode> rootNodes){
        if(root == null) return null;

        if(rootNodes.containsKey(root.val)){
            TreeNode node = rootNodes.get(root.val);

            root.left = node.left;
            root.right = node.right;

            rootNodes.remove(root.val);
        }

        root.left = mergeBST(root.left, rootNodes);
        root.right = mergeBST(root.right, rootNodes);

        return root;
    }

    boolean validate(TreeNode root, int[] prev){
        if(root != null){
            if(!validate(root.left, prev)) return false;

            if(prev[0] != -1 && root.val <= prev[0]) return false;

            prev[0] = root.val;

            return validate(root.right, prev);
        }
        return true;
    }
}
