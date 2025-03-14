class Solution
{
    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        
        Queue<Pair> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        q.offer(new Pair(root, 0));
        
        while(!q.isEmpty()){
            Pair p = q.poll();
            Node curr = p.node;
            int col = p.col;
            
            map.put(col, curr.data);
                
            if(curr.left != null) q.offer(new Pair(curr.left, col-1));
            if(curr.right != null)q.offer(new Pair(curr.right, col+1));
        }
        
        ans.addAll(map.values());
        
        return ans;
    }
}

class Pair{
    Node node;
    int col;
    
    Pair(Node node, int col){
        this.node = node;
        this.col = col;
    }
}
