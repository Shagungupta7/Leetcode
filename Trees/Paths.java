class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        helper(ans, root, new ArrayList<Integer>());
        return ans;
    }
    
    static void helper(ArrayList<ArrayList<Integer>> ans, Node root, ArrayList<Integer> temp){
        if(root == null) return;
        
        temp.add(root.data);
        
        if(root.left == null && root.right == null) {
            ans.add(new ArrayList<Integer>(temp));
            
        }else{
            helper(ans, root.left, temp);
        
            helper(ans, root.right, temp);
        }
        
        
        temp.remove(temp.size()-1);
    }
}
