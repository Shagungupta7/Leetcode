class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        if (root == null) return ans;
        int col = 0;
        Queue<Pair> queue = new ArrayDeque<>(); // Using custom Pair class

        queue.offer(new Pair(root, col));
        int min = 0, max = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            Map<Integer, List<Integer>> levelMap = new HashMap<>();

            for (int i = 0; i < size; i++) {
                Pair removed = queue.poll();
                TreeNode node = removed.node;
                col = removed.col;

                if (node != null) {
                    levelMap.putIfAbsent(col, new ArrayList<>());
                    levelMap.get(col).add(node.val);

                    min = Math.min(col, min);
                    max = Math.max(col, max);

                    queue.offer(new Pair(node.left, col - 1));
                    queue.offer(new Pair(node.right, col + 1));
                }
            }

            // Sort each column's nodes before adding to the main map
            for (int key : levelMap.keySet()) {
                List<Integer> nodeList = levelMap.get(key);
                Collections.sort(nodeList); // Sorting node values within the column
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).addAll(nodeList);
            }
        }

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    // Custom Pair class to store (TreeNode, column index)
    static class Pair {
        TreeNode node;
        int col;
        Pair(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }
}
