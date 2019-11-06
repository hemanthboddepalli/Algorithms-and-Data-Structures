//https://leetcode.com/problems/interval-list-intersections/
class IntervalIntersection {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> res = new ArrayList<int[]>();
        int i = 0, j=0;
        while (i < A.length && j < B.length) {
            if (A[i][0] <= B[j][0]) {
                if (A[i][1] >= B[j][0]) {
                    int x = B[j][0];
                    int y = Math.min(A[i][1], B[j][1]);
                    int[] element = new int[2];
                    element[0] = x; element[1] = y;
                    res.add(element);
                }
            }
            else {
                if (A[i][0] <= B[j][1]) {
                    int x = A[i][0];
                    int y = Math.min(A[i][1], B[j][1]);
                    int[] element = new int[2];
                    element[0] = x; element[1] = y;
                    res.add(element);
                }
            }
            if (A[i][1] < B[j][1]) {
                i++;
            }
            else {
                j++;
            }
        }
        int[][] arr = new int[res.size()][2];
        int k=0;
        for (int[] value : res) {
            arr[k] = value;
            k++;
        }
        return arr;
    }
}
