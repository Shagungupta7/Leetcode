class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root == null) return res;
        queue.offer(root);

        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i = 0; i < level; i++){
                TreeNode curr = queue.poll();

                if(i == level - 1){
                    res.add(curr.val);
                }

                if(curr.left != null) queue.offer(curr.left);
                if(curr.right != null) queue.offer(curr.right);
            }
        }
        return res;
    }
}
