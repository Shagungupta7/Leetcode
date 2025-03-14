/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/

import java.util.*;

public class Solution {
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        if(!isLeaf(root)) ans.add(root.data);

        addLeft(root.left, ans);
        addBottom(root, ans);

        List<Integer> right = new ArrayList<>();
        addRight(root.right, right);
        Collections.reverse(right);
        ans.addAll(right);

        return ans;
    }

    static boolean isLeaf(TreeNode root){
        return root.left == null && root.right == null;
    }

    static void addLeft(TreeNode node, List<Integer> ans){
        while(node != null){
            if(!isLeaf(node)) ans.add(node.data);
            node = node.left == null ? node.right : node.left;
        }
        return;
    }
    static void addRight(TreeNode node, List<Integer> ans){
        while(node != null){
            if(!isLeaf(node)) ans.add(node.data);
            node = node.right == null ? node.left : node.right;
        }
        return;
    }

    static void addBottom(TreeNode node, List<Integer> ans){
        if(node == null) return;
        if(node.left == null && node.right == null){
            ans.add(node.data);
        }
        addBottom(node.left, ans);
        addBottom(node.right, ans);
        return;
    }

    
}
