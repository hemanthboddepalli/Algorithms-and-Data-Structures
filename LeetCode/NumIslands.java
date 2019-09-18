//https://leetcode.com/problems/number-of-islands/
//Number of Islands
class NumIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int res = 0; int rows = grid.length; int columns = grid[0].length;
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    depthFirstSearch(grid, i, j, rows, columns);
                }
            }
        }
        return res;
    }
    public void depthFirstSearch(char[][] grid, int i, int j, int rows, int columns) {
        if (i < 0 || i >= rows || j < 0 || j >= columns || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        depthFirstSearch(grid, i+1, j, rows, columns);
        depthFirstSearch(grid, i-1, j, rows, columns);
        depthFirstSearch(grid, i, j+1, rows, columns);
        depthFirstSearch(grid, i, j-1, rows, columns);
    }
}
