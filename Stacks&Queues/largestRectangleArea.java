class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        
        int area = 0;
        for(int i = 0; i <= heights.length; i++){
            int h = (i == heights.length) ? 0:heights[i];
            while(!stack.isEmpty() && heights[stack.peek()] > h){
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek()-1;
                area = Math.max(area, height*width);
            }
            stack.push(i);
        }
        return area;
    }
}
