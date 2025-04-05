class Solution {
    public String removeOuterParentheses(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == ')') count--;
            if(count > 0) sb.append(c);
            if(c == '(') count++;
        }
        return sb.toString();
    }
}
