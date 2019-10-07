class QuickSort {
  public static int[] quickSort(int[] arr) {
    return quickSort(arr, 0, arr.length-1);
  }
  public static int[] quickSort(int[] arr, int low, int high) {
    if (low < high) {
			int pivot_index = partition(arr, low, high);
			quickSort(arr, low, pivot_index-1);
			quickSort(arr, pivot_index+1, high);
		}
		return arr;
  }
	public static int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
		int index = low;
		for (int i=low; i<high; i++) {
			if (arr[i] < pivot) {
				int temp = arr[i];
				arr[i] = arr[index];
				arr[index] = temp;
				index++;
			}
		}
		int temp = arr[high];
		arr[high] = arr[index];
		arr[index] = temp;
		return index;
  }
}
