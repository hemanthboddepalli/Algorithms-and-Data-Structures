class MinSizeSubArraySum {
  public static int findMinSubArray(int S, int[] arr) {
    int sum=0, min=Integer.MAX_VALUE, curr=0;
    for (int i=0; i<arr.length; i++) {
      sum += arr[i];
      while (sum >= S) {
        min = Math.min(min, i-curr+1);
        sum -= arr[curr];
        curr++;
      }
    }
    return min == Integer.MAX_VALUE ? 0 : min;
  }

  public static void main(String[] args) {
    int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
    System.out.println("Smallest subarray length: " + result);
    result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
    System.out.println("Smallest subarray length: " + result);
  }
}
