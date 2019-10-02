//https://leetcode.com/problems/n-queens/
class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        char[][] board = new char[n][n];
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                board[i][j] = '.';
            }
        }
        solveNQueens(board, n, 0, res);
        return res;
    }
    private void solveNQueens(char[][] board, int n, int row, List<List<String>> res) {
        if (row == n) {
            createResult(board, res, n);
            return;
        }
        for (int column = 0; column<n; column++) {
            if (isValidMove(board, row, column, n)) {
                board[row][column] = 'Q';
                solveNQueens(board, n, row+1, res);
                board[row][column] = '.';
            }
        }
    }
    private boolean isValidMove(char[][] board, int row, int column, int n) {
        for (int i=0; i<n; i++) {
            if (board[i][column] == 'Q') {
                return false;
            }
        }
        for (int i=row, j=column; i >= 0 && j >= 0; i--,j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        for (int i=row, j=column; i >= 0 && j < n; i--,j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    private void createResult(char[][] board, List<List<String>> res, int n) {
        List<String> list = new ArrayList<String>();
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j<n; j++) {
                sb.append(board[i][j]);
            }
            list.add(sb.toString());
        }
        res.add(list);
    }
}
