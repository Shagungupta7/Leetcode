public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> a) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < a.size(); i++){
            while(!stack.isEmpty() && stack.peek() >= a.get(i)){
                stack.pop();
            }
            if(stack.isEmpty()) ans.add(-1);
            else ans.add(stack.peek());
            stack.push(a.get(i));
        }
        
        return ans;
    }
}
