class Solution {
    public int maxDepth(String s) {
        int count = 0;
        int max = 0;

        for(char c : s.toCharArray()){
            if(c == '(') count++;
            if(c == ')') count--;
            max = Math.max(count, max);
        }
        return max;
    }
}
