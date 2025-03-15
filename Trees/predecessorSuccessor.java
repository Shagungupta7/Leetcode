import java.util.*;
public class Solution {
    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        // Write your code here.
        TreeNode successor = null;
        TreeNode predcessor = null;

        TreeNode node = root;

        while (node != null) {
            if(node.data > key){
                successor = node;
                node = node.left;
            }else{
                node = node.right;
            }
        }

        node = root;
        while (node != null) {
            if(node.data >=key){
                node = node.left;
            }else{
                predcessor = node;
                node = node.right;

            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add((predcessor == null ? -1 : predcessor.data));
        ans.add(successor == null ? -1 : successor.data);
        return ans;
    }
}
