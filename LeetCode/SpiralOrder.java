//Spiral Matrix
//https://leetcode.com/problems/spiral-matrix/
class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int rows = matrix.length;
        if (rows == 0) return res;
        int columns = matrix[0].length;
        int i=0; int j=0; int count = 0;
        while (res.size() < rows*columns) {
            while (j < columns - count) {
                res.add(matrix[i][j]);
                j++;
            }
            i++; j--;
            if (res.size() >= rows*columns) break;
            while (i < rows - count) {
                res.add(matrix[i][j]);
                i++;
            }
            i--; j--;
            if (res.size() >= rows*columns) break;
            while (j >= count) {
                res.add(matrix[i][j]);
                j--;
            }
            i--; j++;
            if (res.size() >= rows*columns) break;
            while (i >= count+1) {
                res.add(matrix[i][j]);
                i--;
            }
            i++; j++; 
            count++;
        }
        return res;
    }
}
