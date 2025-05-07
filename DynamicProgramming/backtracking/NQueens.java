class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> res = new ArrayList<>();
        queens(res, board, 0, n);
        return res;
    }

    private int queens (List<List<String>> res, boolean[][] board, int row, int n){
        if(row == n){
            display(res, board);
            return 1;
        }

        int count = 1;
        for(int col = 0; col < n; col++){
            if(isSafe(board, col, row)){
                board[row][col] = true;
                count += queens(res, board, row+1, n);
                board[row][col] = false;
            }
        }
        return count;
    }

    private boolean isSafe(boolean[][] board, int col, int row){
        //check vertically
        for(int i = 0; i < board.length; i++){
            if(board[i][col]) return false;
        }

        //check left diagonal
        int maxLeft = Math.min(row, col);
        for(int i = 1; i <= maxLeft; i++){
            if(board[row-i][col-i]) return false;
        }

        //check right diagonal
        int maxRight = Math.min(row, board.length-col-1);
        for(int i = 1; i <= maxRight; i++){
            if(board[row-i][col+i]) return false;
        }

        return true;
    }

    private void display(List<List<String>> res, boolean[][] board){
        List<String> temp = new ArrayList<>();
        for(boolean[] row : board){
            StringBuilder str = new StringBuilder();
            for(boolean ele : row){
                if(ele) str.append("Q");
                else str.append(".");
            }
            temp.add(str.toString());
        }
        res.add(temp);
    }
}
