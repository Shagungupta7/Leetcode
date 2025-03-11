class Solution {
    public int[] findMode(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        if(root == null) return ans.stream().mapToInt(i -> i).toArray();
        int[] max = {0};
        helper(root, map, max, ans);
        
        return ans.stream().mapToInt(i -> i).toArray();
    }

    void helper(TreeNode node, HashMap<Integer, Integer> map, int[] max, List<Integer> ans){
        if(node == null) return;

        helper(node.left, map, max, ans);

        int count = map.getOrDefault(node.val, 0) +  1;
        map.put(node.val, count);

        if(count > max[0]){
            max[0] = count;
            ans.clear();
            ans.add(node.val);
        }else if(count == max[0]) {
            ans.add(node.val);
        }

        helper(node.right, map, max, ans);
        return;
    }
}
