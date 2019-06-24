/*
Merge Sort Code
Sort an array A using Merge Sort.
Change in the input array itself. So no need to return or print anything.
*/


package org.hackerrank.com;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = {2,1,5,3,9};
		mergeSort(arr);
		for (int i=0; i<arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static void mergeSort(int[] input){
		if (input.length <= 1) {
			return;
		}
		int mid = input.length/2;
		int[] low = new int[mid];
		int[] high = new int[input.length - mid];
		for (int i=0; i<mid; i++) {
			low[i] = input[i];
		}
		int k = 0;
		for (int i=mid; i<input.length; i++) {
			high[k] = input[i]; k++;
		}
		mergeSort(low);
		mergeSort(high);
		merge(low, high, input);
	}

	public static void merge (int[] low, int[] high, int[] input) {
		int i = 0, j = 0, k = 0;
		while (i < low.length && j < high.length) {
			if (low[i] < high[j]) {
				input[k] = low[i];
				i++;
			}
			else {
				input[k] = high[j];
				j++;				
			}
			k++;
		}
		while (i < low.length) {
			input[k] = low[i];
			i++;k++;
		}
		while (j < high.length) {
			input[k] = high[j];
			j++;k++;
		}
	}
}
