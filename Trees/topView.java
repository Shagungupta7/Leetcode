class Solution {l
    // Function to return a list of nodes visible from the top view
    // from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return null;
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair it = q.poll();
            int col = it.col;
            Node temp = it.node;
            
            if (!map.containsKey(col)) map.put(col, temp.data);
            if(temp.left != null) q.offer(new Pair(temp.left, col - 1));
            if(temp.right != null) q.offer(new Pair(temp.right, col + 1));
            
        }
        ans.addAll(map.values());         
        return ans;
    }
}
class Pair {
    Node node;
    int col;

    Pair(Node node, int col) {
        this.node = node;
        this.col = col;
    }
}
