class ReplacingOnes {
    public int longestOnes(int[] arr, int k) {
        int windowstart = 0, windowend=0, zeros = 0, max = -1;
        while (windowend < arr.length) {
          if (arr[windowend] == 0) {
            zeros++;
          }
          while (zeros > k) {
            max = Math.max(max, windowend - windowstart);
            if (arr[windowstart] == 0) {
              zeros--;
            }
            windowstart++;
          }
          windowend++;
        }
        max = Math.max(max, windowend - windowstart);
        return max;
    }
}
