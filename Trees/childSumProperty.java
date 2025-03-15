class Solution
{
    //Function to check whether all nodes of a tree have the value 
    //equal to the sum of their child nodes.
    public static int isSumProperty(Node root)
    {
        // add your code here
        if(root == null) return 1;
        
        if(root.left == null && root.right == null) return 1;
        
        int leftval = (root.left != null) ? root.left.data : 0;
        int rightval = (root.right != null) ? root.right.data : 0;
        
        if(root.data == leftval + rightval){
            int left = isSumProperty(root.left);
            int right = isSumProperty(root.right);
            
            return (left == 1 && right == 1) ? 1 : 0;
        }
        
        return 0;
        
        
    }
}
