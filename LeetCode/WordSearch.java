//https://leetcode.com/problems/word-search/
class WordSearch {
    public boolean exist(char[][] board, String word) {
        int rows = board.length, columns = board[0].length;
        for (int i=0; i<rows; i++) {
            for (int j=0; j<columns; j++) {
                if (word.length() > 0 
                    && word.charAt(0) == board[i][j] 
                    && dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (word.length() == index) {
            return true;
        }
        if (i < 0 || j < 0 || i >= board.length 
            || j >= board[i].length || board[i][j] == '#' 
            || word.charAt(index) != board[i][j]) {
            return false;
        }
        char c = board[i][j];
        board[i][j] = '#';
        boolean res = dfs(board, word, i+1, j, index+1)     
                   || dfs(board, word, i-1, j, index+1) 
                   || dfs(board, word, i, j+1, index+1) 
                   || dfs(board, word, i, j-1, index+1);
        board[i][j] = c;
        return res;
    }
}
