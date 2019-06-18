/*
All Indices of Number.
Given an array of length N and an integer x, you need to find all the indexes where x is present in the input array. 
Save all the indexes in an array (in increasing order).
Do this recursively. Indexing in the array starts from 0.
*/

public class AllIndexes {

    public static int[] allIndexes(int input[], int x) {
          return allIndexes(input, x, 0, new int[0]);
    }
    
    public static int[] allIndexes(int input[], int x, int index, int res[]) {
		    if (index == input.length) {
            return res;
        }
        if (input[index] == x) {
            int length = res.length;
            int[] temp = new int[length + 1];
            for (int i=0; i<length; i++) {
                temp[i] = res[i];
            }
            temp[length] = index;
            res = temp;
        }
        return allIndexes(input, x, ++index, res);
	  }
	
}
