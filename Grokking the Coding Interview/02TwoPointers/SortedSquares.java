class SortedSquares {
    public int[] sortedSquares(int[] A) {
        int i=0, j=A.length-1, index = j;
        int[] res = new int[A.length];
        while (i <= j) {
            int a = Math.abs(A[i]);
            int b = Math.abs(A[j]);
            if (a > b) {
                res[index] = a*a;
                i++;
            }
            else {
                res[index] = b*b;
                j--;
            }
            index--;
        }
        return res;
    }
}
