class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        if(matrix == null || n == 0 || m == 0) return 0;

        int[][] dp = new int[n][m];

        int len = 0;
        for(int r = n-1; r >= 0; r--){
            for(int c = m-1; c >= 0; c--){
                if(matrix[r][c] == '1'){
                    if(r < n-1 && c < m-1 ){
                        dp[r][c] =1 + Math.min(dp[r+1][c+1], Math.min(dp[r+1][c], dp[r][c+1]));
                    }else dp[r][c] = 1;
                }
                len = Math.max(len, dp[r][c]);
            }
        }

        return len*len;
    }

}

//bottom-up
class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        if(matrix == null || n == 0 || m == 0) return 0;

        int[][] dp = new int[n+1][m+1];

        int len = 0;
        for(int r = 1; r <= n; r++){
            for(int c = 1; c <= m; c++){
                if(matrix[r-1][c-1] == '1'){
                    dp[r][c] = Math.min(dp[r-1][c-1], Math.min(dp[r-1][c], dp[r][c-1]))+1;
                    len = Math.max(len, dp[r][c]);
                }
            }
        }

        return len*len;
    }

}
