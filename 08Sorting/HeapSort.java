class HeapSort {
  public static int[] heapSort(int[] arr) {
		int n = arr.length;
    for (int i=(n/2)-1; i>=0; i--) {
			heapify(arr, n, i);
		}
    for (int i=n-1; i>=0; i--) {
			int swap = arr[i];
			arr[i] = arr[0];
			arr[0] = swap;
			heapify(arr, i, 0);
		}
		return arr;
  }
	public static void heapify(int[] arr, int n, int i) {
		int root = i;
		int left = 2*i+1;
		int right = 2*i+2;
		if (left < n && arr[root] < arr[left]) {
			root = left;
		}
		if (right < n && arr[root] < arr[right]) {
			root = right;
		}
		if (root != i) {
			int swap = arr[root];
			arr[root] = arr[i];
			arr[i] = swap;
			heapify(arr, n, root);
		}
	}
}
