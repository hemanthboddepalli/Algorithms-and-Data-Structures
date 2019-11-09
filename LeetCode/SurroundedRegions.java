//https://leetcode.com/problems/surrounded-regions/
class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        int rows = board.length;
        int columns = board[0].length;
        
        for (int i=0; i<rows; i++) {
            if (board[i][0] == 'O')
                borderDFS(board, i, 0, rows, columns);
            if (board[i][columns-1] == 'O')
                borderDFS(board, i, columns-1, rows, columns);
        }
        
        for (int i=1; i<columns-1; i++) {
            if (board[0][i] == 'O')
                borderDFS(board, 0, i, rows, columns);
            if (board[rows-1][i] == 'O')
                borderDFS(board, rows-1, i, rows, columns);
        }
        
        for (int i=1; i<rows-1; i++) {
            for (int j=1; j<columns-1; j++) {
                if (board[i][j] == 'O') {
                    insideDFS(board, i, j, rows, columns);
                }
            }
        }
        
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    public void borderDFS(char[][] board, int i, int j, int rows, int columns) {
        if (i < 0 || j < 0 || i >= rows || j >= columns || board[i][j] != 'O') return;
        board[i][j] = '#';
        borderDFS(board, i+1, j, rows, columns);
        borderDFS(board, i-1, j, rows, columns);
        borderDFS(board, i, j+1, rows, columns);
        borderDFS(board, i, j-1, rows, columns);
    }
    
    public void insideDFS(char[][] board, int i, int j, int rows, int columns) {
        if (i <= 0 || j <= 0 || i >= rows-1 || j >= columns-1 || board[i][j] != 'O') return;
        board[i][j] = 'X';
        insideDFS(board, i+1, j, rows, columns);
        insideDFS(board, i-1, j, rows, columns);
        insideDFS(board, i, j-1, rows, columns);
        insideDFS(board, i, j+1, rows, columns);
    }
}
