/*
educative.io
Remove Even Integers From an Array
*/

class CheckRemoveEven {
  
	public static int[] removeEven(int[] arr) {
		int oddElements = 0;
    
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) oddElements++;
		}
    
		int[] result = new int[oddElements];
		int result_index = 0;
    
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) 
        result[result_index++] = arr[i];
		}

		return result;
	}
}
