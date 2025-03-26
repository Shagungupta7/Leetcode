class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] prefix = new int[n][m];

        for(int j = 0; j < m; j++){
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += (matrix[i][j] - '0');
                if(matrix[i][j] == '0') sum = 0;
                prefix[i][j] = sum;
            }
        }

        for(int i = 0; i < n; i++){
            maxArea = Math.max(maxArea, histogram(prefix[i]));
        }
        return maxArea;
    }

    int histogram(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int area = 0;

        for(int i = 0; i <= arr.length; i++){
            int x = (i == arr.length) ? 0 : arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] >= x){
                int h = arr[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                area = Math.max(area, w*h);
            }
            stack.push(i);
        }
        return area;
    }
}
