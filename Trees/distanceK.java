class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        HashMap<Integer, TreeNode> map = new HashMap<>();
        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                if(curr.left != null) {
                    map.put(curr.left.val, curr);
                    q.offer(curr.left);
                }
                if(curr.right != null) {
                    map.put(curr.right.val, curr);
                    q.offer(curr.right);
                }
            }
        }
        Map<Integer, Integer> visited = new HashMap<>();
        q.offer(target);

        while(k > 0 && !q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                visited.put(curr.val, 1);

                if(curr.left != null && !visited.containsKey(curr.left.val)) q.offer(curr.left);
                if(curr.right != null && !visited.containsKey(curr.right.val)) q.offer(curr.right);
                if(map.containsKey(curr.val) && !visited.containsKey(map.get(curr.val).val)) q.offer(map.get(curr.val));
            }
            k--;
        }

        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}
